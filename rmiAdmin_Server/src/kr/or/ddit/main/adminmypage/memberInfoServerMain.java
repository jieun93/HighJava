package kr.or.ddit.main.adminmypage;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import kr.or.ddit.service.adminmypage.ImemberInfoService;
import kr.or.ddit.service.adminmypage.memberInfoServiceImpl;
// 회원정보 관리 화면 창 
public class memberInfoServerMain {

	public static void main(String[] args) {
		
		try {
			ImemberInfoService service =  memberInfoServiceImpl.getinstance();
			
			Registry reg = LocateRegistry.createRegistry(9999);
			reg.rebind("ImemberInfoService", service);
			
			System.out.println("서버가 준비되었습니다.");
		
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}

