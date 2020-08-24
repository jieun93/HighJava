package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


/*
 * 문제)  사용자로부터 lprod_id 값을 입력받아 입력한 값보다 lprod_id가 큰 자료를 출력하시오.
 * 
 */
public class jdbcTest02 {

	public static void main(String[] args) {
		// DB작업에 필요한 객체 변수 선언
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				
				try {
					Scanner sc = new Scanner(System.in);
					
					System.out.println("입력해주세요.>");
					
					int input = Integer.parseInt(sc.nextLine());
					
					//1. 드라이버 로딩
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					//2. 접속하기
					conn = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:xe", /*외원야 하는 구문*/
							"jieun",
							"java");
							
					//3. SQL 문을 만들어서 실행하기
					
					//3-1 SQL문 작성
					String sql = " select * from lprod";
					//3-2 Statement 객체 또는 PreparedStatement 객체를 생성한다. 
					stmt = conn.createStatement(); // Statement 객체 생성
					
					// 4.SQL문을  실행하고 결과를 받아온다.
					rs = stmt.executeQuery("select * from lprod where lprod_id >" + input);
					
					// 5. 결과를 받아서 처리한다.
					// select 문의 처리 결과는 ResultSet에 저장되는데 이 ResyltSet객체에 저장된 데이터는 
					// 반복문과 next() 메서드를 이용해서 차례로 읽어와 처리한다.
					
					
					//rs.next() ==> Result 객체의 데이터를 가리키는 포인터를 다음 레코드 위치로 이동시키고
					//				그 곳에 데이터가 있으면 true를 반환하고 없으면 false로 반환한다.
					
					
		
					
					while(rs.next()){
						// 현재의 레코드에서 컬럼값을 가져오는 방법
						// 1) rs.get테이터타입명("컬럼명")
						// 2) rs.get 데이터 타입명(컬럼번호) ==> 컬럼번호는 1번부터 시작
						// 3) rs.get 데이터타입명("alias명")
						
						
							
						System.out.println("lprod_id : "+rs.getInt("lprod_id"));
						System.out.println("lprod_Gu : "+rs.getString("lprod_gu"));
						System.out.println("lprod_Nm : "+rs.getString("lprod_nm"));
						System.out.println("---------------------------------------------");
						
						
					}
					
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}finally{
					//6. 사용했던 자원 반납==> 생성된 순서의 역순으로 반납한다.
					if(rs!=null) try{rs.close();}catch(SQLException e){}
					if(stmt!=null) try{stmt.close();}catch(SQLException e){}
					if(conn!=null) try{conn.close();}catch(SQLException e){}
					
				}
				
			 
			 
			 
			 
	}

}
