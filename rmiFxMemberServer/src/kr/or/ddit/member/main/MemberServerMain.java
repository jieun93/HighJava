package kr.or.ddit.member.main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

public class MemberServerMain {

	public static void main(String[] args) {
		try {
			IMemberService service = MemberServiceImpl.getInstance();
			
			Registry reg = LocateRegistry.createRegistry(3681);
			reg.rebind("memberService", service);
			
			System.out.println("서버가 준비되었습니다!!");
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

}
