package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 정렬과  관련되 interface는 Comparable 과 Comparator 이렇게 두 가지가 잇다.
 * 
 * 이 중에 사용자가 작성하는 객체 자체에 정렬 기준을 넣기 위해서 Comparable 인터페이스를 구현하고 ,
 * 정렬 기준을 외부에 별도로 구현할 경우에는 Comparator 인터페이스를 구현하여 사용하면 된다.
 * 
 * Comparable 인터페이스는 compareTo()메서드를 재정의 해서 구현해야 하고,
 * Comparator 인터페이스는 compare() 메서드를 재정의 해서 구현해야 한다.
 */

// 회원 정보를 저장할 수 있는 클래스 작성 ==> 회원의 이름을 기주으로 오름차순 정렬이 될 수 잇도록 구현한다.
class Member implements Comparable<Member> {
	private int num; // 회원번호
	private String name; // 회원이름
	private String tel; // 전화번호

	// 생성자 만들기 (컨트롤 +시프트 +에스 => 유징 필드)
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	// 접근을 위해서 getter,setter 만들기
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	// toString 만들기
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	// 이 메서드에서 회원의 이름을 기준으로 오름차순 정렬이 되도록 재정의 한다.
	@Override
	public int compareTo(Member mem) {

		return this.getName().compareTo(mem.getName());// 회원이름

		/*
		 * //회원번호의 오름차순일 경우
		 *  if(this.getNum() > mem.getNum()){ return 1; 
		 *  }else if(this.getNum()==mem.getNum()){ return 0; 
		 *    }else{ return -1; } 
		 */
	}

}

public class ListSortTest2 {

	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<>();

		memList.add(new Member(1, "이제경", "010-1433-1111"));
		memList.add(new Member(2, "연지은", "010-6554-1111"));
		memList.add(new Member(6, "박선정", "010-7656-1111"));
		memList.add(new Member(5, "송효진", "010-7655-1111"));
		memList.add(new Member(9, "심주영", "010-1765-1111"));
		memList.add(new Member(7, "남아름", "010-5347-1111"));

		System.out.println("정렬전....");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("-----------------------------------");

		// 정렬하기
		Collections.sort(memList);// 정렬기준이 없어서 정렬을 못한다.//정렬기준 만들어줌
		// Member 클래스에 정렬기준을 추가해줘야 한다.

		System.out.println("정렬후....");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("-----------------------------------");

		// 회원 번호의 내림차순으로 정렬이 될 수 있는 외부 정렬 기준을 작성하여
		// 리스트의 데이터를 정렬한 후 출력하시오.

		// 내림차순 정렬
		Collections.sort(memList, new SortNumDesc());
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("-----------------------------------");

	}

}

// 회원번호를 기준으로 내림차순 정렬을 수행하는 외부정렬 기준 class 작성
class SortNumDesc implements Comparator<Member> {
	@Override
	public int compare(Member mem1, Member mem2) {
		
		
		// 수식을 이용한 방법
		//return mem2.getNum() - mem1.getNum();
		
		//wrapper 클래스를 이용한 방법1 ==> 전역 메서드 compareTo() 이용하기
//		return Integer.compare(mem1.getNum(), mem2.getNum()) * -1;
		
		//wrapper 클래스를 이용한 방법 ==> 멤버 메서드인  compareTo() 이용하기
		return  new Integer(mem1.getNum()).compareTo(mem2.getNum())*-1;
		
		// if를 이용한 방법
		/*if (mem1.getNum() < mem2.getNum()) {
			return 1; //양수를 반환하면 두 값의 순서가 바뀐다.
		} else if (mem1.getNum() > mem2.getNum()) {
			return -1;
		} else {
			return 0;
		}*/
	}
}