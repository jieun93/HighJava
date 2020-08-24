package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
/*
 *  숫자 야구 게임 프로그램 작성하기
 *  
 *  - Set을 이용하여 숫자 야구 게임 프로그램을 작성한다.
 *    컴퓨더의 숫자는 난수를 이용해서 구한다.
 *    (스트라이크는 S, 볼은 B로 출력한다.)
 *    
 *    예) 컴퓨터 난수 ==> 9 5 7
 *		
 *	실행예시)  nextint 를 사용해서 할 수 있다.
 * 		숫자입력 : 3 5 6  
 * 		3 5 6 ==> 1S 0B
 * 		숫자입력 : 7 8 9
 * 		7 8 9 ==> 0S 2B
 * 		숫자입력 : 9 7 5
 * 		9 7 5 ==> 1S 2B
 * 		숫자입력 : 9 5 7
 * 		9 5 7 ==> 3S 0B
 * 
 *    4번만에 맞췄습니다.
 */

public class BaseballTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//랜덤으로 숫자 3개 만들기
		HashSet<Integer> baseball = new HashSet<>();
		 
		while(baseball.size()<3){
			 int num = (int)(Math.random() * 9 + 1);
			 baseball.add(num);
		 }
		 		 
		//리스트에 3개를 넣어주는 거
		ArrayList<Integer> list = new ArrayList<>(baseball);
			int str=0;
			int ball=0;
			int count=0;
			
			//리스트에 있는 값을 섞어 주는거
			Collections.shuffle(list);
		 
			
			//컴퓨터가 보내는 값
		System.out.print(list.get(0)+" ");
		System.out.print(list.get(1)+" "); 
		System.out.println(list.get(2)); 
		
		
		 while(str !=3){
			 //반복을 할떄 값을 초기화  시작할 수 있게 0으로 해준다.
			 str=0;
			 ball=0;
		System.out.print("숫자 입력 :");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if(a == list.get(0)){
			str++;
		}else if (a == list.get(1)|| a == list.get(2)){
			ball++;
		}
		if(b == list.get(1)){
			str++;
		}else if(b==list.get(0)||b==list.get(2)){
			ball++;
		}
		if(c == list.get(2)){
			str++;
		}else if(c==list.get(0)||c==list.get(1)){
			ball++;;
		}
		
		
		System.out.println(a+" "+b+" "+c+"==>"+str+"S"+ball+"B");
		
		count++;
		 }
		 System.out.println(count+"만에 맞췄습니다.");
	}
	

}


