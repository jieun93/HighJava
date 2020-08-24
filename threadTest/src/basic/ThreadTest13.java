package basic;

//yield()메서드 연습용 예제

public class ThreadTest13 {

	public static void main(String[] args) {
		ThreadYield th1 = new ThreadYield("1번 쓰레드");
		ThreadYield th2 = new ThreadYield("2번 쓰레드");
		
		th1.start();
		th2.start();
	
	try {
		Thread.sleep(10);
	} catch (InterruptedException e) {
	}System.out.println("=========================11111111111111111111111");
	th1.work = false;
	
	
	try {
		Thread.sleep(10);
	} catch (InterruptedException e) {
	}System.out.println("=========================22222222222222222222222222");
	th1.work = true;
	
	try {
		Thread.sleep(10);
	} catch (InterruptedException e) {
	}
	th1.stop = true;
	th2.stop = true;
	
	
	
	}

}

//yield()메서드 연습용 쓰레드
class ThreadYield extends Thread{
	//쉽게 접근을 위해 public으로 함
	public boolean stop = false;   //쓰레드 전체의 실행 제어용
	public boolean work = true;		// 쓰레드 작동 중 작업의 실행 여부 제어용
	
	public ThreadYield(String name) {
		super(name);		//쓰레드의 이름 설정(Thread클래스에 name 속성이 있는데 이 속성에는 쓰레드의 이름이 저장된다.
	}
	
	@Override
	public void run() {
		while(!stop){ //stop이 true가 되면 반복문 종료
			if(work){//true이면 여기가 작동
				// getName()메서드 ==> 현재 쓰레드의 name속성값을 반환한다.
				System.err.println(getName()+"작업중...");
			}else{//false이면 여기가 작동
				Thread.yield(); 	// yield()메서드는 Thread의 정적(static) 메서드이다.
									//Threa.yield 를 넣는 이유  시간을 줄여 효율성을 높이기 위해서
				}
			
		}
		System.out.println(getName() +"종료...");
	}
}