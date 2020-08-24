package rmi.chat.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import rmi.chat.inf.IChat;
import rmi.chat.inf.IChatClient;

// 클라이언트용 인터페이스 구현하여 작성
public class RmiChatClient extends UnicastRemoteObject implements IChatClient{
	
	
	// 생성자
	protected RmiChatClient() throws RemoteException {}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("대화명 입력:");
		String name = scan.next();
		scan.nextLine();	// 버퍼 비우기
		
		// Registry에 등록된 채팅 서버에 접속하여 객체 구하기
		try {
			// 서버에 저장 할 클라이언트 객체 생성
			 IChatClient client = new RmiChatClient();
			 
			 
			 //Registry에 등록된 서버객체 구하기 
			 Registry reg = LocateRegistry.getRegistry("localhost", 1099);
			 IChat server = (IChat)reg.lookup("chatServer");
			 
			 server.setClient(client); //서버에 클라이언트 객체 추가하기 
			 
			 while(true) {   // 강제로 종료하기 전에 종료 할 수 없다. 
				 String message = scan.nextLine();
				 server.setMessage("[" + name + "] "+ message);
			 }
			 
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	
	
	// 서버가 보내온 메시지를 화면에 출력하는 메서드 
	@Override
	public void printMessage(String msg) throws RemoteException {
		System.out.println(msg);
		
	}

}
