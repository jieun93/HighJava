package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/*
 * DB의 정보가 저장된 파일의 내용으로 DB접속 정보를 설정하기 
 * 방법1) Propeties 객체를 이용하는 방법
 */

public class DBUtil2 {
	private static Properties prop; // Properties객체 변수 선언
	static{
		prop = new Properties(); //Properties 객체 생성
		File f = new File("res/dbinfo.properties"); // 읽어 올 파일명이 설정된  File 객체 생성
		
		try {
			// 파일을 읽어오기 위해서 FileInputStream 객체를 생성한다.
			FileInputStream fin = new FileInputStream(f);
			
			prop.load(fin); // 파일내용을 읽어 와  Properties 객체에 데이터를 셋팅한다.
				
			//Properties 객체에 설정된 내용을 getProperty()메서드를 사용해서 읽어와 사용한다.
			//Class.forName("oracle.jdbc.driver.OracleDriver");			
			Class.forName(prop.getProperty("driver"));			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버로딩 실패!!");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("DB설정 파일이 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("입출력 오류 입니다.");
			e.printStackTrace();
		}
			
	}
	
	
public static Connection getConnection(){
    	
    	try {
			//return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jieun", "java");
    		
    		return DriverManager.getConnection( prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("pass"));
    				
		} catch (SQLException e) {
			System.out.println("오라클연결실패");
			return null;
		}
    }
	
	
}
