package basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TcpMultiChatServer {
	
	//  대화명과 클라이언트의 socket객체를 저장하기 위한 Map 객체 선언  ==> 대화방  정보 저장 역할 socket에 클라이언트를 저장한다 
	public Map<String, Socket> clientMap;
	
	
	// 생성자
	public TcpMultiChatServer() {
		//clientMap을 동기화 처리한 다. 
		clientMap = Collections.synchronizedMap(new HashMap<String, Socket>());
	}
	
	
	// 서버 프로그램의  시작 메서드 
	public void serverStart() {
		
		ServerSocket server = null;
		Socket socket = null;
		try {
			server = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다.");
			
			while(true) {
				socket = server.accept(); // 클라이언트의 접속을 기다린다.
				
				System.out.println("["+socket.getInetAddress()+ ":"+
							socket.getPort()+"]에서  접속했습니다.");
				
				// 서버에서 클라이언트로 메세지를 전송할  Thread객체 생성 
				ServerReceiver sr = new ServerReceiver(socket);
				sr.start();
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(server != null ) try { server.close();} catch(IOException e) {}
		}
		
	}
	// 대화방에 저장된 모든 클라이언트에게 메세지를 전송하는 메서드 
	public void sendToAll(String msg) {
		// 대화방에 접속한 사용자의 대화명(key값)들을 추출한다. 
		Iterator<String> it = clientMap.keySet().iterator();
		while(it.hasNext()) {
			try {
			String name = it.next(); // 대화명(key값) 구하기 
			Socket soc = clientMap.get(name);	// 대화명의 Socket객체 구하기 
			
			DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
			
			dos.writeUTF(msg);// 메세지 전송
			
			}catch(IOException e) {	}
		}
	}
	
	
	public static void main(String[] args) {
		// 사용자의 접속을 기다렸다가 접속하면 list,map에 저장을 해야한다. 
		new TcpMultiChatServer().serverStart();
	}
	
	// 서버에서 클라이언트로 메시지를 전송하는 Thread 
	class ServerReceiver extends Thread{
		Socket socket;
		DataInputStream in;
		DataOutputStream out;
		
		// 생성자  소켓을 받아야 한다. 
		public ServerReceiver(Socket socket) {
			this.socket= socket;
			try {
				// 클라이언트의 소켓에서 데이터를 수신받을 inputStream객체 생성
				in = new DataInputStream(socket.getInputStream());
				
				// 클라이언트의 소켓에서 데이터를 송신할  outputStream객체 생성
				out = new DataOutputStream(socket.getOutputStream());
				
						
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
		
		
		
		/*중복되지 않을때 까지 검사한다. 
		 * 
		 *  	서버  					   	클라이언트
		 *  ---------------------------------------  
		 * 						  	1. 대화명 서버로 전송 
		 * 2.대화명이 중복되는지 여부 검사
		 * (중복: "이름중복",중복없음: "ok")
		 * 클라이언트로 전송
		 * 
		 * ----------------------------------------- 중복되지 않을 때 까지 반복
		 * 
		 */
		
		
		@Override
		public void run() {
			String name =""; // 대화명이 저장될 변수 선언
			try {
				while(true) {
					// 서버에서는 클라이언트가 최초로 보낸 대화명을 받아서  대화명의 중복 여부를 검사하여
					// feedback으로 클라이언트에게 보내준다.
					
					name = in.readUTF();
					
					if(clientMap.containsKey(name)) { // 중복 여부 검사(중복될 때)
						out.writeUTF("이름중복");
						
					}else { // 중복되지 않을때 
						out.writeUTF("ok");
						break; // while 문 탈출
					}
						
				}// while문
				
				// 대화명을 받아서 전체 클라이언트에게 대화방 참여 메세지를 보낸다.
				sendToAll("["+name + "]님이  대화방에 입장하셨습니다.");
				
				// 대화명과 socket객체를 대화방 Map에 추가한다.
				clientMap.put(name, socket);
				
				
				System.out.println("현재 서버 접속자 수:"+  clientMap.size()+"명");
				
				
				// 한 클라이언트가 보낸 메세지를 받아서 전체 대화방 참여자에게 보내준다.
				 while(in!=null) {
					 sendToAll(in.readUTF());
				 }
				
			} catch (IOException e) {
				// TODO: handle exception
			}finally {
				// 이부분이 실행된다는 것은 해당 클라이언트가 접속이 종료되었다는 의미이다.
				sendToAll("["+name+"]님이 대화방을 나갔습니다.");
				
				
				//  대화방 목록에서 삭제
				clientMap.remove(name);
				
				System.out.println("현재 접속자 수:"+clientMap.size()+"명");
				
			}
		
		}
	}
}
