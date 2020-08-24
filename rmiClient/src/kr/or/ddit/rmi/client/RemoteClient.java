package kr.or.ddit.rmi.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.rmi.inf.RemoteInterface;
import kr.or.ddit.rmi.vo.FileInfoVO;
import kr.or.ddit.rmi.vo.TestVO;

// 클라이어트쪽의 vo나 인터페이스는  서버의 vo나 인터페이스가 있는 패키지의 구조와  파일명 그리고 내용까지
// 같은 구조로 구성되어 있어야 한다.


public class RemoteClient {

	public static void main(String[] args) {
		
		try {
			// 등록된 서버를 찾기 위해 Registry객체를 생성한다.(서버 접속)
			Registry reg = LocateRegistry.getRegistry("localhost", 8888);
			
			// 사용할 객체는 서버에 등록된 Alias로 찾아서 객체를 불러온다.
			// 형식) Registry 객체변수.lookup("객체Alias");
			RemoteInterface inf = (RemoteInterface) reg.lookup("server"); //형변환 해줘야 한다. // try-catch
			
			// 이 이후부터는 불러온 객체의 메서드를 호출해서 사용할 수 있다.
			// 인터페이스에 있는 메소드를 호출 
			int a = inf.doRemotePrint("안녕하세요, 클라이언트입니다.");  // a에 반환값 200이 들어간다.
			System.out.println("반환값"+a);
			System.out.println("-----------------------------");
			
			System.out.println("doPrintList()메서드 호출");
			List<String> nameList = new ArrayList<String>();
			nameList.add("연지은");
			nameList.add("박서준");
			nameList.add("김태평");
			nameList.add("정지오");
			nameList.add("정해인");
			inf.doPrintList(nameList);
			System.out.println("--------------------------------");
			
			
			System.out.println("doPrintVo()메서드 호출");
			TestVO test = new TestVO();
			test.setName("정우성");
			test.setNum(2020);
			inf.doPrintVo(test); //doPrintVo에 test를 담아준다.
			System.out.println("----------------------------------");
			
			
			
			// 파일 전송하기
			// 전송할 파일의 File객체 생성
			File file = new File("d:/d_other/test.txt");  // 파일경로를 입력하면 파일에 전송된다.
			
			// 파일 존재 검사하는거 
			if(!file.exists()) {
				System.out.println("전송할 파일이 없습니다.");
				return;
			}
			
			FileInfoVO fVo = new FileInfoVO();
			fVo.setFileName(file.getName());	// 파일 이름 설정
			
			// 파일의 크기 구하기
			long fSize  = file.length();
			// 파일 내용을 읽어와 저장할  byte 형 배열 선언       ==>  배열의 크기는 파일크기와 같게 한다.
			byte[] data = new byte[(int)fSize];
			
			try {
			FileInputStream fin = new FileInputStream(file);
			fin.read(data); 	// 파일내용을 읽어와 byte형 배열에 저장한다.
			
				// 읽어온 데이터를 FileInfoVO객체에 셋팅한다.
				fVo.setFileData(data);
			
				// RMI용 파일 전송용 메서드 호출
				inf.setFile(fVo);
				System.out.println("파일 전송 끝...");
			
			}catch(IOException ee) {
				ee.printStackTrace();
			}
			
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
