package basic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerKoala {
	private ServerSocket server;
	private Socket socket;
	
	public void serverStart() {
		
		// client한테 받은 사진을  test 파일에 받는거 
		File file = new File("D:/D_Other/test/Koala.jpg");
		
		try {
			server = new ServerSocket(9999);
			System.out.println("서버가 준비되었습니다.");
			
			
			//클라이언트 접속 기다림 무한정 기다림
			socket = server.accept();
			
			System.out.println("파일 다운로드 시작...");
			InputStream in	 = socket.getInputStream();  // socket
			FileOutputStream fos = new FileOutputStream(file); // file 출력
			
			byte[] tmp = new byte[1024];
			int length = 0;
			while((length=in.read(tmp))!=-1) {
				fos.write(tmp, 0, length);
			}
			
			System.out.println(" 파일 다운로드 완료 ");
			 
			 fos.close();
			 in.close();
			 socket.close();
			 server.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	public static void main(String[] args) {
		new ServerKoala().serverStart();
		
	}

}
