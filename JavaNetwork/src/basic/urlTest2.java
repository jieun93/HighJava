package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class urlTest2 {
	public static void main(String[] args) throws IOException {
		
		// url 에 접근해서 해당 자원 내용 읽어오기
		
		// 예) naver.com의 index.html 문서 읽어오기
		
		URL url = new URL("https://www.naver.com/index.html");
		
		
		//url 객체를 이용해서 URLConnection객체를 구한다.
		URLConnection urlCon = url.openConnection();
		
		// Header 정보 보기
		System.out.println("Content-Type :"+urlCon.getContentType());
		System.out.println("Encoding : "+urlCon.getContentEncoding());
		System.out.println("Content: "+urlCon.getContent());
		System.out.println("----------------------------------------");
		
		// 내용 출력하기 
		
		// Stream 객체 생성 

		// 방법 1 ==> URLConnection의 getInputStream()메서드 이용하기
		//InputStream is = urlCon.getInputStream();
		
		// 방법2 --> url객체의 openStream()메서드 이용하기 
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new  BufferedReader(isr);
		
		// 내용 출력하기
		while(true) {
			String str = br.readLine(); // 한줄씩 읽어오기 
			if(str== null)break;
			System.out.println(str);
		}
		br.close();
		System.out.println("-------------------------------------------");
		
	}
}
