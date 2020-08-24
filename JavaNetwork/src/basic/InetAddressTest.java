package basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	
	public static void main(String[] args) throws UnknownHostException {
		//InetAddress 클래스 -> IP 주소를 다루기 위한 클래스 
		
		// Naver 사이트의 IP주소 가져오기
		InetAddress  naverIp = InetAddress.getByName("www.naver.com");
		System.out.println("HostName : " + naverIp.getHostName());
		System.out.println("HostAddress : " + naverIp.getHostAddress());
		System.out.println();
		
		
		// 자신의 컴퓨터 ip 주소 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("HostName : "+localIp.getHostName());
		System.out.println("HostAddress : "+localIp.getHostAddress());
		System.out.println();
	
		//ip 주소가 여러개인 호스트의 정보 가져오기
		//InetAddress[] naverArrays = InetAddress.getAllByName("www.naver.com");
		//InetAddress[] daumArrays = InetAddress.getAllByName("www.daum.com");
		InetAddress[] dditArrays = InetAddress.getAllByName("www.ddit.com");
		for(InetAddress nIp : dditArrays) {
			System.out.println(nIp.toString());
		}
	}
}

