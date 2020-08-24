package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import util.DBUtil;

/*
   DB의 LPROD 테이블에 새로운 데이터를 추가하기
   
   lprod_id는 현재 lprod_id 중 제일 큰 값보다 1 증가된 값으로 한다.
   lprod_gu와 lprod_nm은 직접 입력 받아서 사용한다.
   그런데, lprod_gu는 기본키이기 때문에 데이터가 중복되면 다시 입력받는다.
 */
public class jdbcTest07 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      // 변수선언??
      Connection conn = null;
      Statement stmt = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      try {
    	  //여기는 매번 반복되는 부분 
       /* 
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jieun", "java");
       */
    	  
    	  
    	  //DBUtil 부분에서 가져오는거 
    	  conn = DBUtil.getConnection();
    			  
    	  
    	  
         //lprod_id중 제일 큰 값 구하기
         // 쿼리 문 작성
         String sql = "select max(lprod_id) maxId from lprod";
         
         stmt = conn.createStatement();
         
         rs = stmt.executeQuery(sql);
         
         int maxId = 0;
         
         if(rs.next()){
            maxId = rs.getInt("maxId");// 제일 큰 값 가져오기
         }
         maxId++; // 제일 큰 값을 1 증가 시킨다.
         
         
         
         
         //lprod_gu
         String gu;  //입력한 lprod_gu가 저장될 변수 선언
         
         int count =0;
         do{
            System.out.print("상품분류 코드 (lprod_gu)입력: ");
            gu = sc.nextLine();
           
            // 쿼리 문 작성 lprod_gu가 몇개가 있는지 묻는거 
            String sql2 = "select count(*) from lprod where lprod_gu =?";
           pstmt = conn.prepareStatement(sql2);
           pstmt.setString(1, gu);
            
            rs = pstmt.executeQuery(sql2);
            
            if(rs.next()){
            	count =rs.getInt("cnt");
            }
               if(count>0){      
                  System.out.println("중복된 "+gu+"입니다. 다시 입력해주세요.");
               }
         }while(count>0);
         
         
         //사용하던 PreparedStatement 객체를 close한 후에 다시 사용한다.
         if(pstmt != null) try{pstmt.close();} catch(SQLException e){}
          
         //lprod_nm
         System.out.println("상 품 명 > ");
         String nm = sc.nextLine();
         
         String sql3 = "insert into lprod (lprod_id, lprod_gu, lprod_nm)" 
               + "values(?,?,?)";
         
         pstmt = conn.prepareStatement(sql3);
         pstmt.setInt(1, maxId);
         pstmt.setString(2, gu);
         pstmt.setString(3, nm);
         
         
         int cnt = pstmt.executeUpdate();
         
         if(cnt>0){
        	 System.out.println("새로운 자료 등록 성공!!");
         }else{
        	 System.out.println("새로운 자료 등록 실패~~~~~");
         }
        
      } catch (SQLException e) {
         e.printStackTrace();
 //     } catch (ClassNotFoundException e){
 //        e.printStackTrace();
      } finally {
         if(rs != null) try{rs.close();} catch(SQLException e){}
         if(pstmt != null) try{pstmt.close();} catch(SQLException e){}
         if(stmt != null) try{stmt.close();} catch(SQLException e){}
         if(conn != null) try{conn.close();} catch(SQLException e){}   
      }
      

   }

}