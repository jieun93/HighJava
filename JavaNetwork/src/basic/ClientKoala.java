package basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientKoala {
	private Socket socket;
	
	public void clientStart() {
		// D드라이브에서 server로 사진 파일 보내는거 
		File file = new File("D:/D_Other/Koala.jpg");
		
		// 파일이 존재하지 않으면 
		if(!file.exists()) {
			System.out.println("전송할 파일이 없습니다.");
			return;
		}
		
		
		// 내 컴퓨터 안에서 전송하는거 , 다른 컴퓨터로 전송하려면 
		try {
			socket = new Socket("localhost",9999);
			System.out.println(" 파일전송 시작 ");
			
			
			FileInputStream fin = new FileInputStream(file);
			OutputStream os = socket.getOutputStream();
			
			byte[] tmp = new byte[1024];
			int len = 0;
			while((len=fin.read(tmp))!=-1) {
				os.write(tmp, 0, len);
			}
			System.out.println("파일전송 끝...");
			
			fin.close();
			os.close();
			socket.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
		public static void main(String[] args) {
			new ClientKoala().clientStart();
		}
}
