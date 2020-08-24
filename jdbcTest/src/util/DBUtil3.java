package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.print.attribute.ResolutionSyntax;

/*
 * DB의 정보가 저장된 파일의 내용으로 DB접속 정보를 설정하기 
 * 방법2) ResourceBundle 객체를 이용한 방법
 * 
 * ResourceBundle 객체 ==> 확장자가 properties인 파일의 내용을 읽어와 key 값과 value값을 
 * 						  분리해서 그 정보를 갖고 있는 객체
 * 
 * 확인하려면 MemberinfoTest.java에 들어가서 확인해봐야 한다.
 * 
 */
public class DBUtil3 {
	private static ResourceBundle bundle; // ResourceBundle 객체 변수 선언
	
	static{
		// ResourceBundle 객체를 생성 할 떄 getBundle() 메서드에 읽어 올 파일 정보를 지정해 주는데 
		// 이때 '파일명'만 지정하고 확장자는 지정하지 않는다.
		// (이유: 확장자는 항상'properties'이기 떄문에...)
		
		bundle =  ResourceBundle.getBundle("dbinfo"); // ResourceBundle 객체 생성
	
		// bundle 객체의 값은 getString(key값)메서드를 이용해서 읽어온다.
		
		try {
    		 // Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(bundle.getString("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC드라이버 로딩 실패!!");
			e.printStackTrace();
		}
	}
	
	
	
	 public static Connection getConnection(){
	    	
	    	try {
				return DriverManager.getConnection(
						bundle.getString("url"),
						bundle.getString("user"),
						bundle.getString("pass"));
			} catch (SQLException e) {
				System.out.println("오라클연결실패");
				return null;
			}
	    }
	
}
