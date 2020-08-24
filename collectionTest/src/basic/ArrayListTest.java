package basic;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		
		// ArrayList는 기본적인 사용법이 Vector와 같다.
		ArrayList list1 = new ArrayList();
		
		System.out.println("처음크기:"+list1.size());
		// add()메서드를 이용하여 추가한다.
		list1.add("aaa");
		list1.add("bbb");
		list1.add(111);
		list1.add('k');
		list1.add(false);
		list1.add(12.345);
		
		System.out.println("list1의 크기:"+list1.size());
		System.out.println("list1 =>"+list1);
		
		//get()메서드로 데이터를 꺼내온다.
		
		System.out.println("1번쨰:"+ list1.get(1));
		
		//데이터 끼워 넣기도 똑같다.
		list1.add(0, "zzz");
		System.out.println("list1 =>"+list1);
		
		//데이터 수정하기 ==>set 메서드
		String temp = (String)list1.set(0,"yyy");
		System.out.println("temp =>"+temp);
		System.out.println("list1 =>"+list1);
		
		//삭제도 같다.
		list1.remove(0);
		System.out.println("삭제 후 list =>"+list1);
		
		list1.remove("bbb");
		System.out.println("삭제 후 list =>"+list1);
		
		
		// 제네릭을 지정하여 선언 할 수 잇따.
		ArrayList<String> list2 = new ArrayList<>();
		
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");
		
		
		
		for (int i = 0; i<list2.size(); i++){
			System.out.println(i+" : "+list2.get(i));
		}
		System.out.println("-------------------------------------------");
		
		
		
		// 향상된 for문
		
		for(String s : list2){
			System.out.println(s);
		}
		System.out.println("-------------------------------------------");
		
		// contains(비교객체); ==> 리스트에 '비교객체'가 있으면 true, 없으면 false 반환
		System.out.println("DDDD 데이터 존재 여부 :"+list2.contains("DDDD")); //DDDD 데이터 존재 여부 :false
		System.out.println("DDDD 데이터 존재 여부 :"+list2.contains("DDD"));  //DDDD 데이터 존재 여부 :true
		
		System.out.println("-------------------------------------------");
		
		// indexOF(비교객체); ==> 리스트에 '비교객체'가 있으면 '비교객체'가 있는 index값을 
		//					      반환하고, 없으면 -1을 반환한다.
		System.out.println("DDD의 index 값:"+list2.indexOf("DDD"));
		System.out.println("ZZZ의 index 값:"+list2.indexOf("ZZZ"));
		System.out.println("-------------------------------------------");

		
		// toArray()  ==> 리스트 안의 데이터들을 배열로 반환한다.
		// 			 ==> 기본적으로 Object 형 배열로 반환된다.
		
		// toArray(new 제네릭 타입[0]) ==> 제네릭 타입의 배열로 변환된다.
		
		Object[] strArr = list2.toArray();
	//	String[]] strArr = list2.toArray();  // 오류발생
		
		System.out.println("배열의 개수:"+strArr.length);
		for(int i = 0; i<strArr.length; i++){
			//System.out.println(i+"번째:"+strArr[i]);
			String tempData = (String)strArr[i];
			System.out.println(i+"번째:"+tempData);
			
		}
		System.out.println("-------------------------------------------");
		
		String[] strArr2 = list2.toArray(new String[0]);
		for(String str : strArr2){
			System.out.println(str);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
