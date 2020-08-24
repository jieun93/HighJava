package basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Koala {

	public static void main(String[] args) {
		
		try {
			FileInputStream inkoala = new FileInputStream("d:/d_other/koala.jpg");
			FileOutputStream oukoala = new FileOutputStream("d:/d_Other/연습용/koala.jpg"); 
		
			int c;
			
			while((c=inkoala.read()) != -1){
				System.out.println((char)c);
			}
		
			inkoala.close();
			oukoala.close();
		
		
		} catch (IOException e) {
			System.out.println(" 파일에 쓰기 오류입니다.");
		}

	}

}
