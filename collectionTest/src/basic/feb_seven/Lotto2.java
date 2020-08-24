package basic.feb_seven;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Lotto2 {
	
	//변수선언
	int lottoNum;		//로또개수
	int lottoChange;	//거스름돈
	int money;
	int division = 1000; 
	int random;
	
	
	//스캐너 생성
	Scanner scan = new Scanner(System.in);
	HashSet<Integer> list = new HashSet<>();
	ArrayList list2 = new ArrayList<>();
	
	

	public static void main(String[] args) {
		new Lotto2().start();
	}//메인끝
	
	
	public void start(){
		boolean bl = true;
		do{
			System.out.println("==========================");
			System.out.println("      LOTTO구입프로그램               ");
			System.out.println("==========================");
			System.out.println(" 1. LOTTO구입");
			System.out.println(" 2. 프로그램 종료");
			System.out.println("==========================");
			System.out.println("메뉴선택>");
			
			//스캐너생성
			Scanner scan2 = new Scanner(System.in);
			int input = Integer.parseInt(scan2.nextLine());
			
			
			//스위치문
			switch(input){
				case 1 : //로또구입 
						Money(); break;
				case 2 : //프로그램 종료
						System.out.println("프로그램이 종료됩니다.");
						bl=false; break;
				
			}
			
		}while(bl); //참이면 나간다
	}
	
	
	//입력돈 계산 메서드
	public void Money(){
		System.out.println("로또를 구매할 금액을 입력해주세요.");
		System.out.print("금액입력 : ");
		int input = Integer.parseInt(scan.nextLine());
		money = input;
		

			if(money < 1000){
				System.out.println("==========================");
				System.out.println("입력금액이 너무 적습니다.");
				System.out.println("로또 구입 실패!");
				System.out.println("==========================");
			}else if(money > 100000){
				System.out.println("==========================");
				System.out.println("입력금액이 너무 많습니다.");
				System.out.println("로또 구입 실패!");
				System.out.println("==========================");
			}else if(money>=1000 && money <= 100000){
				System.out.println("==========================");
				System.out.println("행운의 로또번호는 다음과 같습니다.");
				LottoBuy();
				System.out.println("==========================");
				
		
		}
	}
	
	
	//랜덤숫자 생성 메서드
	public void RadomNum(){
		list.clear();
		//숫자생성 6개
		while(list.size()< 6){
			random = (int)(Math.random()*45 +1);
			list.add(random);
		}
		
		list2.add(list);
		
		//출력
		
		for(int print : list){
			System.out.print(print + " ");

		}
		
	}
	
	
	//구매 메서드
	public void LottoBuy(){
		//RadomNum(); //랜덤수 생성 메서드 객체 생성
		
		
		lottoNum = money/division; //로또개수
		lottoChange = money%division;//거스름돈
	
		//lottoNum 만큼 행운번호 나오게 
		for(int i = 0; i < lottoNum; i++){
			
			
				System.out.print("로또번호"+ (i+1) + ":" );
				RadomNum();
				System.out.println("거스름돈은" + lottoChange +"입니다.");
			
			
		}
		
		
		
	}
	
	

}
