package basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제) 5명의 사람 이름을 Scanner로 입력받아 ArrayList에 저장하고,
 *      이 사람들 중에 '김'씨 성의 이름을 출력하는 프로그램을 작성하시오.
 *      
 */
public class ArrayListTest2 {

	public static void main(String[] args) {

		Scanner sc =  new Scanner(System.in);
		
		ArrayList<String> name = new ArrayList<>();
		
		System.out.println("5명의 이름을 입력하세요.");
			
		name.add(sc.nextLine()); //0
		name.add(sc.nextLine()); //1
		name.add(sc.nextLine()); //2
		name.add(sc.nextLine()); //3
		name.add(sc.nextLine()); //4
		System.out.println("-----------------------");
		for(int i = 0; i < name.size(); i++){
			//1방법  charAt(0)
			/*if( name.get(i).charAt(0) == '김'){
				System.out.println(name.get(i));
			}*/
			
			//2방법 
			/*if( name.get(i).substring(0,1).equals("김")){
				System.out.println(name.get(i));
			}*/
			
			//3방법
			/*if( name.get(i).indexOf("김")==0){
				System.out.println(name.get(i));
			}*/
			
			//4방법 시작글자가 '김' 과 같으면 true가 된다.
			if( name.get(i).startsWith("김")){
				System.out.println(name.get(i));
			}
			
		}
		
		//charAt() ==> 몇번째에 있는 글자를 찾아낼때
		
	}

}
