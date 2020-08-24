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

public class HorseTest {

	public static void main(String[] args) {
		//배열을 가지고 말을 저장
		Horse[] horses =new Horse[]{
				new Horse("1번말"),
				new Horse("2번말"),
				new Horse("3번말"),
				new Horse("4번말"),
				new Horse("5번말"),
				new Horse("6번말"),
				new Horse("7번말"),
				new Horse("8번말"),
				new Horse("9번말"),
				new Horse("10번말")
		};
		
		
		PlayState display = new PlayState(horses);
				
		System.out.println("경기 시작!!");
		
		for(Horse h : horses){
			h.start();
		}
		
		display.start();
		
		for(Horse h : horses){
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		try {
			display.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		//경기가 끝나면 배열을 등수순으로 정렬한다.
		Arrays.sort(horses);
		
		System.out.println("경기 결과");
		for(Horse h : horses){
			System.out.println(h);
		}
		
		
		
		
	}

}





//경주마를 나타내는 클래스 --> 각 말들은 경주를 해야하기 때문에 이 클래스는 쓰레드로 만든다.
class Horse extends Thread implements Comparable<Horse>{
	public static int currentRank = 0;  // 경주가 끝난 말의  등수를 결정하기 위한 변수
	
	private String horseName; // 말이름
	private int rank; //말등수
	private int location; //현재위치
	
	public Horse(String horseName) {
		this.horseName=horseName;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}
	
	@Override
	public String toString(){
		return "경주마" + horseName +"는"+ rank + "등 입니다.";
	}
	
	// 등수의 오름차수능로 정렬 할 수 있는 정렬 기준 만들기
	@Override
	public int compareTo(Horse h) {
		return Integer.compare(rank, h.rank); //내 등수와 상대편 등수를 비교해서 등수를 바꿀지 말지 
	};
	
	@Override
	public void run() {
		for(int i =1;  i<=50; i++){
			location = i;  //현재 달리고 있는 구간이 현재 말의 위치가 된다.
			try {
				Thread.sleep((int)(Math.random()*400));
			} catch (InterruptedException e) {
			}
		}
		++currentRank; //말의 등수를 결정하는 변수값 증가시키기 
		this.rank = currentRank;
		
	}
}


//경기 중 현재의 상황을 출력하는 쓰레드
class PlayState extends Thread{
	private Horse[] horses; //경주에 참가한 말들을 저장 할 배열
	
	public PlayState(Horse[] horses) {
		this.horses = horses;
	}
	
	@Override
	public void run() {
		//경기에 참가한 말의 개수만큼 출력
		while(true){
			if(Horse.currentRank==horses.length){
				break;
			}
			for(int i = 0; i<horses.length; i++){
				System.out.print(horses[i].getHorseName()+":");
				
				//1~50 구간을 나타대는 반복문
				for(int j = 1; j<=50; j++){
					if(horses[i].getLocation()== j){
						System.out.println(">");
					}else{
						System.out.print("-");					
					}
				}// for j
				System.out.println(); // 줄 바꿈
				
			}//for i
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}

























