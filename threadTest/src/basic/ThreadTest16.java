package basic;

public class ThreadTest16 {
	public static void main(String[] args) {
	//공통으로 사용할 객체 생성
		ShareObject sObj = new ShareObject();
		
		workerThread work1 = new workerThread("Test1", sObj);
		workerThread work2 = new workerThread("Test2", sObj);
		
		work1.start();
		work2.start();
		
		
	}
}


//작업용 쓰레드
class workerThread extends Thread{
	private ShareObject sObj;
	
	public workerThread(String name, ShareObject sObj) {
		super(name); //쓰레드 이름 생성
		this.sObj = sObj; 
	}
	@Override
	public void run() {
	for(int i =0 ; i <10; i++){
		sObj.add();
	}
	}
}





class ShareObject{
	private int sum = 0;
	
	//동기화 처리하기
	//방법1(메서드 자체에 동기화 설정하기)
	
	//public synchronized void add(){
	public void add() {
		// 방법2(동기화 블럭으로 설정하기)
		synchronized (this) {
			
	
		int n = sum;
		
		n += 10;
		
		sum = n;
		
		System.out.println(Thread.currentThread().getName()+"합계:"+sum);
		}
	}
	
	public int getSum(){
		return sum; 
	}
}
