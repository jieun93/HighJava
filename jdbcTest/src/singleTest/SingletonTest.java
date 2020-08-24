package singleTest;

public class SingletonTest {

	public static void main(String[] args) {
		// MySingleTon single1 = new MySingleTon(); 싱글톤 객체는 외부에서 new로 객체를 생성 할 수 없다.
		
		//싱글톤 객체를 생성하려면  해당 객체를 생성해서 반환하는 메서드를 호출해야 한다.
		// (이 예제에서는 getInstance()메서드를 호출한다.)
		 MySingleTon single2 = MySingleTon.getInstance();
		 
		 MySingleTon single3 = MySingleTon.getInstance();
		 
		 System.out.println("single2 ="+single2);
		 System.out.println("single3 ="+single3);
		 
		 System.out.println("equals :"+single2.equals(single3));
		 System.out.println(" == : "+(single2 == single3));
		 
		 single2.displayTest(); //객체에서 만들어진 메서드 호출
	}

}
