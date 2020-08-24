package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcTest06 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
			
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jieun"
					 ,"java");
			
			String sql = "select sum(cart_qty) hap from cart where cart_member ='a001'";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			//select 문의 처리 결과가 1개의 레코드일 경우에는 while문 대신 if문을 사용해도 된다.
			if(rs.next()){
				int sum = rs.getInt("hap");
				System.out.println("sum = "+sum);
			}
			
			
		} catch (SQLException e) {
					e.printStackTrace();
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
				}finally{
					if(rs!=null) try{rs.close();} catch(SQLException e){}
					if(stmt!=null) try{stmt.close();} catch(SQLException e){}
					if(conn!=null) try{conn.close();} catch(SQLException e){}
				}
	}

}
