package basic.feb_seven;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/*
 * 문제) 이름, 주소, 전화번호 속성을 갖는 Phone클래스를 만들고
 * 		이 Phone클래스를 이용하여 전화번호 정보를 관리하는 프로그램을 완성하시오.
 * 		이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체출력하는 기능이 있다.
 * 
 *  	전체 전화번호 정보는 Map을 이용하여 관리한다.
 *  	(key값은 '이름'으로 사용하고, value값으로는 Phone클래스의 인스턴스로 한다.)
 *  
 *  	실행예시)
 *  	==============================================
 *  			전화번호 관리 프로그램
 *  	==============================================
 *  		1. 전화번호 등록
 *  		2. 전화번호 수정
 *  		3. 전화번호 삭제
 *  		4. 전화번호 검색
 *  		5. 전화번호 전체 출력
 *  		0. 프로그램 종료
 *  	==============================================
 *  	메뉴선택 >> 1
 *  	
 *  	새롭게 등록할 전화번호 정보를 입력하세요.
 *  	이름 >> 홍길동
 *  	전화번호 >> 010-1111-2222
 *  	주소 >> 대전시
 *  
 *  	홍길동 전화번호 정보가 추가되었습니다.
 *  
 *  		1. 전화번호 등록
 *  		2. 전화번호 수정
 *  		3. 전화번호 삭제
 *  		4. 전화번호 검색
 *  		5. 전화번호 전체 출력
 *  		0. 프로그램 종료
 *  	==============================================
 *  	메뉴선택 >> 5
 *  
 *  	==============================================
 *  	번호		이름		전화번호			주소	
 *  	==============================================
 *  	1		홍길동	010-1111-2222	대전시
 *  	~~~
 *  	==============================================
 *  	출력 완료...
 *  	
 *  		1. 전화번호 등록
 *  		2. 전화번호 수정
 *  		3. 전화번호 삭제
 *  		4. 전화번호 검색
 *  		5. 전화번호 전체 출력
 *  		0. 프로그램 종료
 *  	==============================================
 *  	메뉴선택 >> 0
 *  
 *  	프로그램을 종료함니다...
 *  
 *  
 */

class Phone{
	private String name;
	private String phone;
	private String addr;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "name=" + name + ", phone=" + phone + ", addr=" + addr;
	}
}

public class PhoneBookTest {
	Scanner s = new Scanner(System.in);
	HashMap<String, Phone> phoneMap = new HashMap<String, Phone>();
	int select;
	{
		Phone p = new Phone();
		p.setAddr("대전시");
		p.setName("연지은");
		p.setPhone("010");
		phoneMap.put("연지은", p);

		p = new Phone();
		p.setAddr("서울시");
		p.setName("김태평");
		p.setPhone("01110");
		phoneMap.put("김태평", p);
		
		p = new Phone();
		p.setAddr("청주시");
		p.setName("박서준");
		p.setPhone("012340");
		phoneMap.put("박서준", p);
	}

	
	public void start(){
		System.out.println("==============================================");
   		System.out.println("             전화번호 관리 프로그램");	
   		System.out.println("==============================================");
   		do{
   		System.out.println("\t1. 전화번호 등록");
   		System.out.println("\t2. 전화번호 수정");
   		System.out.println("\t3. 전화번호 삭제");
   		System.out.println("\t4. 전화번호 검색");
   		System.out.println("\t5. 전화번호 전체 출력");
   		System.out.println("\t0. 프로그램 종료");
   		System.out.println("==============================================");
   		System.out.print("메뉴선택 >> ");
   		select = Integer.parseInt(s.nextLine());
   		System.out.println();
   		
   		switch(select){
   		case 1 :
   			add();
   			break;
   		case 2 :
   			edit();
   			break;
   		case 3 :
   			del();
   			break;
   		case 4 :
   			search();
   			break;
   		case 5 :
   			all();
   			break;
   		case 0 :
   			break;
   		
   		}
   		}while(select != 0);
   		System.out.println("프로그램을 종료합니다...");
	}
//	새롭게 등록할 전화번호 정보를 입력하세요.
//	 *  	이름 >> 홍길동
//	 *  	전화번호 >> 010-1111-2222
//	 *  	주소 >> 대전시
//	 *  
//	 *  	홍길동 전화번호 정보가 추가되었습니다.
//	 *  
	public void add(){
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요");
		System.out.print("이름 >> ");
		String name = s.nextLine();
		if(phoneMap.containsKey(name)){
			System.out.println("이미 등록된 이름입니다.");
			return;
		}
		System.out.print("전화번호 >> ");
		String phone = s.nextLine();
		System.out.print("주소 >> ");
		String addr = s.nextLine();
		Phone temp = new Phone();
		temp.setAddr(addr);
		temp.setName(name);
		temp.setPhone(phone);
		phoneMap.put(name, temp);
		System.out.println(name + " 전화번호 정보가 추가되었습니다.");
	}
	public void edit(){
		System.out.println("수정할 이름을 입력하세요");
		System.out.print("이름 >> ");
		String name = s.nextLine();
		if(phoneMap.containsKey(name)){
	   		System.out.println("==============================================");
			System.out.println(phoneMap.get(name));
	   		System.out.println("\t1. 전화번호 수정");
	   		System.out.println("\t2. 주소 수정");
	   		System.out.println("\t0. 뒤로가기");
	   		System.out.println("==============================================");
	   		System.out.print("수정할 항목 선택 >> ");
	   		int select = Integer.parseInt(s.nextLine());
	   		switch(select){
	   		case 1 :
	   			System.out.print("수정할 전화번호를 입력하시오 >> ");
	   			String a = s.nextLine();
	   			phoneMap.get(name).setPhone(a);
	   			System.out.println(phoneMap.get(name));
	   			break;
	   		case 2 :
	   			System.out.print("수정할 주소를 입력하시오 >> ");
	   			a = s.nextLine();
	   			phoneMap.get(name).setAddr(a);
	   			System.out.println(phoneMap.get(name));
	   			break;
	   		case 0 :
	   			return;
	   		}
	   		
		}else{
			System.out.println(name + "님은 전화번호 목록에 없습니다.");
			return;
		}
		System.out.println("수정 완료");
		
	}
	public void del(){
		System.out.println("삭제할 이름을 입력하세요");
		System.out.print("이름 >> ");
		String name = s.nextLine();
		if(phoneMap.containsKey(name)){
	   		System.out.println("==============================================");
			System.out.println(phoneMap.get(name));
			System.out.println("삭제 하시겠습니까");
	   		System.out.println("\t1. 삭제");
	   		System.out.println("\t2. 취소");
	   		System.out.println("==============================================");
	   		System.out.print("항목 선택 >> ");
	   		int select = Integer.parseInt(s.nextLine());
	   		switch(select){
	   		case 1 :
	   			System.out.println(phoneMap.get(name));
	   			System.out.println("삭제 완료");
	   			phoneMap.remove(name);
	   			break;
	   		case 2 :
	   			break;
	   		}
	   		
		}else{
			System.out.println(name + "님은 전화번호 목록에 없습니다.");
			return;
		}
		
	}
	public void search(){
		System.out.println("검색할 이름을 입력하세요");
		System.out.print("이름 >> ");
		String name = s.nextLine();
		if(phoneMap.containsKey(name)){
	   		System.out.println("==============================================");
			System.out.println(phoneMap.get(name));
	   		System.out.println("==============================================");
		}else{
			System.out.println(name + "님은 전화번호 목록에 없습니다.");
			return;
		}
		
	}
	public void all(){
		int i = 1;
		System.out.println("==============================================");
		System.out.println("번호\t이름\t전화번호\t주소");
   		System.out.println("==============================================");
   		for(String name : phoneMap.keySet()){
   			System.out.println(i + "\t" + phoneMap.get(name).getName() + "\t" + phoneMap.get(name).getPhone() + "\t" + phoneMap.get(name).getAddr());
   			i++;
   		}
   		System.out.println("출력 완료...");
   		System.out.println();
	}
	
	
	public static void main(String[] args) {
		new PhoneBookTest().start();
	}

}
