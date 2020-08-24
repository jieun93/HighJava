package basic.feb_seven;

import java.util.HashMap;
import java.util.Scanner;

class inf{
	
	private int  rNm; //방번호
	private String RoomNm; //방이름
	private String name; //손님이름
	

	
	public inf(int rNm, String roomNm) {
		super();
		this.rNm = rNm;
		RoomNm = roomNm;

	}
	
	
	public String getRoomNm() {
		return RoomNm;
	}
	public void setRoomNm(String roomNm) {
		RoomNm = roomNm;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getrNm() {
		return rNm;
	}
	public void setrNm(int rNm) {
		this.rNm = rNm;
	}
	
}



	
	
public class HotelRoom{
	Scanner s = new Scanner(System.in);
	private HashMap<Integer, inf> HotelMap= new HashMap<Integer, inf>();
	
	//생성자 ==> 방번호와  종류 초기화 작업 수행
	public HotelRoom() {
		
		//객실 초기화
		for(int i = 2; i<=4; i++){
			String roomType = null;
			switch(i){ //방 종류 정하기
			case 2 : roomType = "싱글룸"; break;
			case 3 : roomType = "더블룸"; break;
			case 4 : roomType = "스위트룸"; break;
			}
			
			for(int j=1; j<=9; j++){
				int roomNm = i * 100 + j;  //방번호 만들기
				Room room = new Room(roomNm, roomType);  //Room 객체 생성
				HotelMap.put(roomNm, room); //HotelMap에 Room 객체 추가
			}
		}		
	}
	
	public static void main(String[] args) {
		new HotelRoom().start();
	}//메인 끝
	
	


	
	
  public void start(){
	
	  boolean b1 = true;
		
	System.out.println("*********************************");
	System.out.println("호텔문을 열었습니다. 어서오십시오.");
	System.out.println("*********************************");
	do{
	System.out.println("---------------------------------");
	System.out.println("어떤 업무를 하시겠습니까?");
	System.out.println("1.체크인 2.체크아웃  3.객실상태 4.업무종료");
	System.out.println("---------------------------------");
	System.out.println("선택>>");
	
	int input = Integer.parseInt(s.nextLine());
	
	switch(input){
	 case 1:
		 checkin();
	 case 2:
		 checkout();
	 case 3:
		 room();
	 case 4 :
		 System.out.println("업무종료됩니다.");
		  b1 = false; break;
	}
	
	}while(b1);
 }

public void checkin(){
	
	System.out.println("---------------------------------");
			System.out.println("체크인 작업");
	System.out.println("---------------------------------");
	System.out.println(" * 201~209 : 싱글룸");
	System.out.println(" * 301~309 : 더블룸");
	System.out.println(" * 401~409 : 스위트룸");
	System.out.println("---------------------------------");
	System.out.println("방 번호 입력하세요");
	int input = Integer.parseInt(s.nextLine());
	int roomNm = input;
	
	if(HotelMap.containsKey(roomNm)){
		if(HotelMap.get(roomNm).getName().equals(roomNm)){
			System.out.println("체크인이 불가능합니다.");
		}System.out.println("체크인 가능");
		
		
		
	}
	
	
}

public void checkout(){
	System.out.println("체크아웃 할 방 번호를  입력하세요.");
	System.out.print("입력 >>");
	int RoomNm = s.nextInt();
	if(HotelMap.containsKey(RoomNm)){
		
		if(!HotelMap.get(RoomNm).getName().equals(null)){
			System.out.println(HotelMap.get(RoomNm).getName() + "님이 체크아웃하셨습니다.");
			HotelMap.get(RoomNm).setName("-");
		}else{
			System.out.println("방이 비었습니다.");
		}
		}else{
		System.out.println(RoomNm + "호 체크아웃 목록에 없습니다.");
		return;
	}
	
	
}
public void room(){
	
	System.out.println("--------------------------------");
	System.out.println("         현재 객실 상태                                ");
	System.out.println("--------------------------------");
	System.out.println(" 방번호 \t방 종류\t 투숙객이름                       ");
	System.out.println("--------------------------------");
	for(int name : HotelMap.keySet()){
		System.out.println(i+"\t"+HotelMap.get(name).getName()+"\t"+HotelMap.get(name).getrNm());
	i++;
	}
	
}
}

