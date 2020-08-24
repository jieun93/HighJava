package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 문제) 사용자로부터 주소의 일부분을 입력받아 Member 테이블에서 
 * 		 사용자가 입렵한 주소가 포함된 회원의 ID, 이름, 우편번호, 주소를 출력하시오.
 * 
 * 예) 만약 '대흥동'이라고 입력했다면 주소에 '대흥동'이 포함된 모든 자료를 찾아낸다.
 * 		
 */

public class jdbcTest03 {

	public static void main(String[] args) {
		 Connection conn = null;
		 Statement stmt = null;
		 ResultSet rs = null;
		 
		 try {
			 
			 Scanner sc = new Scanner(System.in);
			 
			
			 
			 System.out.println("주소를 입력해주세요>");
			 
			 String add = sc.nextLine();
			 
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 
			 conn  = DriverManager.getConnection(
					 "jdbc:oracle:thin:@localhost:1521:xe",
					 "jieun",
					 "java"
					 );
			 
			 String sql = "select  mem_id, mem_name, mem_zip, mem_add1, mem_add2"+"  from member where mem_add1 like \'%"+ add+"%\'";
			 
			 stmt = conn.createStatement();
			 
			 rs = stmt.executeQuery(sql);
			 		
			while(rs.next()){
				// ID, 이름, 우편번호, 주소
				System.out.println("id :"+rs.getString("mem_id"));
				System.out.println("이름 :"+rs.getString("mem_name"));
				System.out.println("우편번호 :"+rs.getString("mem_zip"));
				System.out.println("주소 : "+rs.getString("mem_add1"));
				System.out.println("---------------------------------------");
				
			}
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			
		}
		 

	}

}
