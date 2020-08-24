package basic;

public class ThreadTest03 {

	public static void main(String[] args) {
		//쓰레드와 수행 시간을 체크해 보자
		Thread th = new Thread (new MyRunner());
		
		//1970 년 1월1일 0시 0분 0초(표준시간)부터 경과한 시간을 밀리세컨드(1/1000초) 단위로 반환한다.
		//쓰레드가 작동되기전 현재 시간 저장하기
		long startTime= System.currentTimeMillis();
		
		//쓰레드 작동  start는 run이 실행되고 끝난다.
		th.start();
		try{
			th.join();  //현재 쓰레드에서 th 쓰레드가 끝날때 까지 기다렬라 라는 의미
		}catch(InterruptedException e){
			
		}
		
		 long endTime = System.currentTimeMillis();
		 
		 System.out.println("실행시간:"+ (endTime - startTime));
	}

}

//1부터 10억까지의 합계를 구하는 쓰레드
class MyRunner implements Runnable{
	
	@Override
	public void run() {
		long sum = 0L;
		for(int i =1; i<=1_000_000_000L; i++){
			sum += i;
		}
		System.out.println("합계 = "+sum);
	}
}