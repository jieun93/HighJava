package kr.or.ddit.main.mypage;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kr.or.ddit.service.mypage.IMymemberService;
import kr.or.ddit.service.mypage.MymemberServiceImpl;

// 마이페이지 main
public class MymemberMain {

	public static void main(String[] args) {
		try {
			IMymemberService service = MymemberServiceImpl.getInstance();
			
			Registry reg = LocateRegistry.createRegistry(9999);
			reg.rebind("IMymemberService",service);
			
			System.out.println("서버가 준비되었습니다.");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}

