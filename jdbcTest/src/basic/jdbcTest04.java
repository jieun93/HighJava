package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcTest04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jieun","java");
			System.out.println("은행정보 추가하기 \n");
			System.out.print("계화번호 :");
			String bankNo = scan.next();
			
			System.out.print("은 행 명:");
			String bankName = scan.next();
			
			System.out.print("예금주명 :");
			String bankUser = scan.next();
			
			
			
			/*
			 *statement 객체를 이용하여 처리하기
			 * String sql ="insert into bankinfo (bank_no, bank_name, bank_user_name,bank_date) "+"values ('"+bankNo+"','"+bankName+"','"+bankUser+"',sysdate)";
			
			stmt = conn.createStatement();
			
			//sql문이 select 문일 경우에는 excuteQuery()메서드를 사용한다.
			// ==> excuteQuery()의 반환값은 select한 결과가 담겨진 ResultSet객체를 반환한다.
			
			
			//SQL 문이 insert, update, delete 문  등 select 문이 아닌 경우에는 executeUpdate()메서드를 사용한다.
			//  ==> executeUpdate()메서드는 작업에 성공한 레코드 수를 반환한다.
			
			int cnt = stmt.executeUpdate(sql);
			*/
			
			
			//PreparedStatement 객체를 이용하여 처리하기 , 해킹이 어려움
			//SQL문에 외부의 데이터가 셋팅 될 곳에 물음표(?)로 나타낸다.
			String sql ="insert into bankinfo (bank_no, bank_name, bank_user_name,bank_date) "
					+"values (?,?,?,sysdate)";
			
			// PreparedStatement 객체를 생성할 때 sql 문을 넣어준다.
			
			pstmt = conn.prepareStatement(sql);
			
			// PreparedStatement객체를 생성한 후에 sql문의 물음표(?)자리에 들어갈 데이터를 셋팅한다.
			// 형식) pstmt.set자료형이름(물음표번호,셋팅할데이터); //물음표 번호는 1번부터 시작
			
			pstmt.setString(1, bankNo);
			pstmt.setString(2, bankName);
			pstmt.setString(3, bankUser);
			
			//데이터 셋팅이 완료되면 쿼리문을 실행한다.
			int cnt = pstmt.executeUpdate();
			//-------------------------------------------------------------------------------------------------
			
			System.out.println("반환값 :"+cnt);
			
			if(cnt>0){ // 작업 성공 여부 검사 
				System.out.println("작업성곻!!");
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			if(stmt!=null) try{stmt.close();} catch(SQLException e){}
			if(pstmt!=null) try{pstmt.close();} catch(SQLException e){}
			if(conn!=null) try{conn.close();} catch(SQLException e){}
			
		}
		
		
		
	}

}
