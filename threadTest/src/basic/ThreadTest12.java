package basic;

import java.util.Arrays;



/*
 * 	10마리의 말들이 경주하는 경마 프로그램을 작성해 보자.
 *  
 *  말은 Horse 라는 이름의 클래스로 구성하고 
 *  이 클래스는  말이름(String), 등수(int), 현재위치(int)를 멤버 변수로 갖는다.
 *  그리고 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬 기준이 잇다.
 *  (Comparable인터페이스 구현)
 *  
 *  경기 구간은 1~50 구간으로 되어 있다.
 *  
 *  경기가 진행하는 동안 일정한 시간 마다 말들의 현재 위치를 출력한다.
 *  예) 
 *  말이름1 ---->--------------------------
 *  말이름2 -------->----------------------
 *  말이름3 ------>------------------------
 *  ...
 *  말이름10 ---------->-------------------
 *  
 *  경기가 끝나면 등수 순으로 출력을 한다.
 *  
 */

public class ThreadTest12 {

	public static void main(String[] args) {
		
		//배열을 가지고 말을 저장
		Horse[] horseNm = new Horse[]{
				new Horse("연지은1"),
				new Horse("연지은2"),
				new Horse("연지은3"),
				new Horse("연지은4"),
				new Horse("연지은5"),
				new Horse("연지은6"),
				new Horse("연지은7"),
				new Horse("연지은8"),
				new Horse("연지은9"),
				new Horse("연지은10")
		};
		
		PlayState display = new PlayState(horseNm); // ???말의 이름 객체 생성???
		
		System.out.println("경기시작!!");
		
		for(Horse h : horseNm){ // 배열에 있는 말의 이름수 만큼 향상된 for문  실행
			h.start(); //쓰레드 실행
		}
		
		display.start();
		
		for(int i = 0; i<horseNm.length; i++){
			try {
				horseNm[i].join();
			} catch (InterruptedException e) {
			}
		
		} 
		try {
			display.join();
		} catch (InterruptedException e) {
		}
		
		// 경기가 끝나면 배열을 등수순으로 정렬한다.
		Arrays.sort(horseNm);
		
		System.out.println("경기 결과");
		for(Horse h : horseNm){
			System.out.println(h);
		}
		
		

	}

}

//말 쓰레드
//각 말들은 경주를 해야하기 떄문에 이 클래스는 쓰레드로 만든다.	
class Horse extends Thread implements Comparable<Horse>{
	public static int currentRank = 0; //경주가 끝난 말의 등수를 결정하기 위한 변수
	
	
	private String name;   //말의  이름
	Integer rank;  // 말의 등수 
	Integer point; // 현재위치
		
	//생성자
	public Horse(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "경주마" + name +"는 " +rank +"등 입니다.";
	}

	//등수의 오름차수순으로 정렬 할 수 있는 정렬 기준 만들기
	@Override
	public int compareTo(Horse h1) {
		return Integer.compare(rank, h1.rank); // 내 등수와 상대편 등수를 비교해서 등수를 바꿀지 말지 결정하는거
	};

	@Override
	public void run() {
		for(int i = 1; i<=50; i++){
			 point=i;  //현재 달리고 있는 구간이 현재 말의 위치가 된다.
		try {
			Thread.sleep((int)(Math.random()*400));
		} catch (InterruptedException e) {
		}
		
	}
	++currentRank; //말의 등수를 결정하는 변수값 증가시키기
	this.rank = currentRank;
	
	
}
}

//경기하는 말 쓰레드
// ------->--------- 출력하는 구문

class PlayState extends Thread{
	
	
	private Horse[] horses;//경주에 참가한 말들을 저장 할 배열
	
	public  PlayState(Horse[] horse){
		this.horses =  horse; //위의 배열에 말을 저장 
	}
	
	
  
	@Override
	public void run() {
		//경기에 참가한 말의 개수만큼 출력
		while(true){
			if(Horse.currentRank ==horses.length){
		}
			for(int i = 0; i<horses.length; i++){
				System.out.println(horses[i].getName()+":");
				
				//1~50 구간을 나타내는 반복문
				for(int j =1; j <= 50; j++){
					if(horses[i].getPoint() == j){
						System.out.println(">");
					}else{
						System.out.println("-");
					}
					
				}// for j
				System.out.println(); //줄바꿈
				
			} //for i
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
	
	
}


}
	}
