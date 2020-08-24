package basic;

import javax.swing.JOptionPane;


/*
 *  컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 *  
 *  컴퓨터의 가위 바위 보는 난수를 이용해서 구하고,
 *  사용자의 입력 showinputDialog()메서드를 이용해서 입력 받는다.
 *  
 *   입력시간은 5초로 제한하고 카운트 다운을 한다.
 *   
 *   5초안에 입력이 없으면 게임에서 진것으로 처리한다.
 *   
 *   5초안에 입력이 있으면 승패를 구해서 다음과 같이 출력한다.
 *   
 *    결과예시)
 *    	-- 결  과 --
 *    컴퓨터 : 가위
 *    사용자 : 바위
 *    결  과  : 사용자가 이겼습니다.
 *    
 */

public class ThreadTest07 {

	public static void main(String[] args) {
		Thread th1 = new DataInput2();
		Thread th2  = new CountDown2();
		
		th1.start();
		th2.start();
		
		// th1 th2가 동시에 진행하면서 main도 같이 진행이 되어 thread 가 끝날때 까지 기다림  
		try {
			th2.join();
		} catch (InterruptedException e) {
			
		}
		
		
		
		int com = (int)(Math.random()*3)+1;
		
		String b =" ";
		
		if(DataInput2.str.equals("가위") ){
			b="가위";
		}else if (DataInput2.str.equals("바위") ){
			b="바위";
		}else if(DataInput2.str.equals("보")){
			b="보";
		}
		
		int a = 0;// a가 지역 변수여서 0으로 초기화 해야 한다.
		if(DataInput2.str.equals("가위")){
			a =1;
		}else if (DataInput2.str.equals("바위")){
			 a = 2;
		}else if (DataInput2.str.equals("보")){
			a=3;
		}
				
		
		
		if(com == a){
			System.out.println("비겼습니다.");
		}else if((com == 1 && a ==2) || (com == 2 && a == 3) || (com ==3 && a ==1)){
			System.out.println("이겼습니다.");
		}else {
			System.out.println("졌습니다.");
		}
	}

}


class DataInput2 extends Thread{
	public static boolean inputChk = false;
	public static String str;
	@Override
	public void run() {
		do{
			str = JOptionPane.showInputDialog("5초 안에 가위,바위,보를 입력하세요.");
		}while(str == null);
		inputChk=true;
		System.out.println("입력값 : " + str);
		
	}
}

//카운트 다운을 담당하는 쓰레드
class CountDown2 extends Thread{
	@Override
	public void run() {
		for(int i = 5; i >=0; i--){
			System.out.println(i);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				
			}
			//입력 완료 여부 검사
			if(DataInput2.inputChk == true){
				return;
			}
		}
		System.out.println("5초가 지났습니다. 프로그램을 종료합니다.");
		System.exit(0);
	}
}