package basic.feb_seven;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



public class MapTest {
	/*
	 * Map ==> key 값과 value값을 한 쌍으로 관리하는 객체
	 * 		==> key 값은 중복ㅇ르 허용하지 않고, 순서가 없다.(set의 특징을 갖는다.)
	 * 		==> value 값은 중복을 허용한다.
	 */

	public static void main(String[] args) {
		
		HashMap<String, String > map = new HashMap<>();
		
		//자료 추가 ==> put (key 값, value 값);
		map.put("name", "홍길동");
		map.put("tel", "010-3945-3681");
		map.put("addr", "대전시");
		
		System.out.println("map =>"+map);
		System.out.println("map의 데이터 개수 =>"+ map.size());
		
		
		//자료 수정 ==> 데이터를 저장할 때 key값이 중복되면  나중에 입력한 값이 저장된다.
		//		==> 즉, key 값은 같게하고 value 값을 다른 값으로 저장하면 된다.
		map.put("addr", "서울시");
		System.out.println("map =>"+map);
		
		/*//자료 삭제 => remove(key 값); ==> 해당 key값을 갖는 데이터를 삭제한다.
		// 							==> 반환값은 삭제된 데이터의 value 값이 반환된다.
		
		String temp = map.remove("tel");
		System.out.println("temp = " + temp);
		System.out.println("map = " + map);
		*/
		
		//자료 읽기 ==> get(key값);  ==> 해당 key 값을 갖는 데이터의 value 값을 반환한다.
		System.out.println("name=>"+map.get("name"));
		System.out.println();
		
		
		//----------------------------------------------------------------------
		// map의 전체 데이터를 차례로 처리하는 방법
		
		
		// 방법1  ==> keySet() 메서드 이용하기
		//		==> 맵의 key 값만 읽어와 Set형으로 반환한다.
		Set<String> keySet = map.keySet();
		Iterator<String> keyIt = keySet.iterator();
		
		
		while(keyIt.hasNext()){
			String key = keyIt.next();
			System.out.println(key+"==>"+map.get(key));
		}
		System.out.println("-----------------------------");

		//******************************************
		System.out.println("향상된 for문 이용");
		for(String key : keySet){
			System.out.println(key +"-->" + map.get(key));
			
		}
		System.out.println("------------------------------------");
		
		
		//방법 2 -->  value값만 읽어와 처리하기
		//       	values() 메서드 이용하기
		for(String val : map.values()){
			System.out.println(val);
		}
		System.out.println("----------------------------------------");
		
		
		// 방법 3 => Map에는 Entry 라는 내부 class 가 만들어져 잇다.
		//   		이 Entry 클래스는  key 와 value 라는 멤버 변수로 구성되어 잇다.
		//			Map에서는 이 Entry 클래스들을 Set 형식으로 저장하여 관리한다.
		
		
		// Entry 객체 전체를 가져오기  ==> entrySet()메서드를 이용한다.
		//		==> 가져온 Entry 들은 Set 형식으로 되어 있다.
		Set<Map.Entry<String, String>> mapSet = map.entrySet();
		
		//Iterator 나 향상된 for문으로 이용하해서 Entry 객체를 처리한다.
		Iterator<Map.Entry<String, String>> entryIt = mapSet.iterator();
		
		while(entryIt.hasNext()){
			Map.Entry<String, String> entry = entryIt.next();
			
			System.out.println("key 값 : "+ entry.getKey());
			System.out.println("value 값 : "+ entry.getValue());
					System.out.println();
		}
		
		System.out.println("---------------------------------------------");
		
		
		//key값의 존재 여부를 나타내는 메서드 ==> containsKey(key값)메서드
		//				==>해당 key값이 잇으면 true, 없으면 false
		
		System.out.println("name 키값 존재 여부:"+map.containsKey("name"));
		System.out.println("name 키값 존재 여부:"+map.containsKey("age"));
		
		
		
		
	}

}
