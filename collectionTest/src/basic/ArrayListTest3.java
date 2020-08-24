package basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest3 {
/*
 *  문제1) 5명의 별명을 Scanner로 입력하여 ArrayList에 저장하고
 *       이 들중 별명의 길이가 제일 긴 별명을 출력하시오.
 *       (단, 각 별명의 길이는 모두 다르게 입력한다.)    
 *       
 *  문제2) 문제 1번에서 별명을 입력할 때 별명의 길이가 같은 것이 허용될 경우를 처리하시오.
 *         
 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);  //시스템으로 입력받는거
		
		 ArrayList<String> name = new ArrayList<>(); //ArrayList 생성
		
		 String name2 = " ";
		 String name3 = " ";
		 System.out.println("별명 5개를 입력해주세요.");
		
		 for(int i=1; i<=5; i++){
			name2 = sc.nextLine();
			
			name.add(name2);//시스템으로 받은 걸 name2에 for문으로 5번 받아서 넣고 name arraylist 배열에 name2를 더한다.
			System.out.println(i+"번째 별명:"+name2);
			
			
		}
		
		 //배열을 비교할만큼 돌리는거
		for(int i =0; i<name.size(); i++){
	   //temp에 제일 긴 별명을 넣을 것이다.ㄹ
			int temp = name.get(0).length(); //temp에 기준을 둘 0번째 인덱스의 길이를 넣는다.(초기화)
			
			if(temp < name.get(i).length()){ //temp가 get(i)번쨰 보다 작으면  get(i)가 큰거니깐
				temp = name.get(i).length(); //다시 temp에  get(i)번쨰를 넣는다.
			}
		}
		
		System.out.println("가장 긴 이름 :"+name3);
		
		// 위에서 출력한 긴 이름들만 담을 배열
		ArrayList<String> aNmList = new ArrayList<>();
		  aNmList.add(name3);
		  
		//한번 더 name의 배열을 반복해서 길이가 긴걸 찾는거
		 for(int i = 0; i<name.size(); i++){
			 //aNmList의 0번쨰 길이랑 name의 i번쨰 길이가 같거나 이름이 같지 않는 name의 get을
			 if(aNmList.get(0).length()== name.get(i).length() && aNmList.get(0)!= name.get(i)){
				 //aNmList에 더해준다.
				 aNmList.add(name.get(i));
			 }
			 
			
			 }
		 
		 for(int i = 0; i<aNmList.size(); i++){
			 System.out.println("동일한 크기의 이름"+aNmList.get(i));
		 }
		 }
		
		
	
			
			
			
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	

}
