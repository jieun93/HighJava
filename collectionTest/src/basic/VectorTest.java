package basic;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
        Vector v1 = new Vector();
        
        System.out.println("처음 크기: "+v1.size());
        
        //자료추가 -->add()메서드 이용
        v1.add("aaa");
        v1.add(new Integer(123));
        v1.add('a'); 
        v1.add(3.14);
        v1.add(1);
        
        
        System.out.println("v1의 크기 :"+v1.size());
        
        
        //addElement()메서드 --> 이 메서드도 데이터를 추가 할 떄 사용할 수 있는데
        //					     기본 기능이 add()메서드와 같다.
        //                     이전 프로그램과의 호환성을 위해서 존재한다.
        v1.addElement("kkkk");
        
        System.out.println("v1 =>"+v1.toString()); //벡터 안에 있는 내용을 다 출력하고 싶을떄
        
        
        //add(index, 데이터) ==>인덱스번쨰의 데이터에 다가 넣는거
        //                    벡터의 index번쨰에 '데이터'를 끼워 넣는다.
        //                    index는 0부터 시작한다.
        
        v1.add(1, "가나다라");
       System.out.println("v1==>"+v1);
        // 출력결과
        //v1 =>[aaa, 123, kkkk]
       //v1==>[aaa, 가나다라, 123, kkkk]
        
       
       
      
       //set(index, 데이터) ==> 벡터의 index번째의 값을 '데이터'로 변경한다.(덮어쓴다) 수정
       //           	 ==> 반환값: 원래의 값
       v1.set(1, "zzzz");
       System.out.println("v1==>"+v1);
       //출력결과
       //v1==>[aaa, 가나다라, 123, kkkk]
       //v1==>[aaa, zzzz, 123, kkkk]

       //변경전 데이터가 궁금하면
       String temp = (String)v1.set(1, "bbbb");
       System.out.println("원래의 값"+temp);
       System.out.println("v1==>"+v1);

       
       //remove(index) ==> 벡터의 index번쨰 데이터를 삭제한다.
       //                  반환값 : 삭제된 데이터
        v1.remove(1);
        System.out.println("삭제 후 "+v1);
      
       //출력결과 
       /* v1==>[aaa, bbbb, 123, kkkk]
          		삭제 후 [aaa, 123, kkkk]*/
        
        temp = (String)v1.remove(1);
         System.out.println("원래의 값"+temp);
         System.out.println("v1==>"+v1);

         
         //remove(삭제 할 데이터) --> 벡터에서 '삭제 할 데이터'를 찾아 삭제한다.
         //   				 -->'삭제 할 데이터'가 여러개 일 경우에는 맨 앞쪽의 데이터를 삭제한다.
        //					-->'삭제 할 데이터'가  '정수형' 이거나'char형' 일 경우		
        //                        해당 데이터를 객체형으로 변환해서 사용해야 한다.
         
        
        v1.remove("kkkk");
        System.out.println("삭제 후 v1 =>"+v1);
        
        //출력결과
       /* 삭제 후 [aaa, 123, kkkk]
        		삭제 후 v1 =>[aaa, 123]
        */
        
     v1.remove(123);//123번 메세지를 지워라라는 의미  123번이 없으니 에러가 발생된다.
        System.out.println("삭제 후 v1=>"+v1);
        
        v1.remove(new Integer(123));//123번 메세지를 지워라라는 의미  123번이 없으니 에러가 발생된다.
        System.out.println("삭제 후 v1=>"+v1);
        
      /*  삭제 후 v1 =>[aaa, 123]
        		삭제 후 v1=>[aaa]*/
        
        
        
        v1.add("aaa");
        System.out.println("추가 후 =>"+v1);
        
        v1.remove("aaa");
        System.out.println("삭제 후 =>"+v1);
        
        v1.remove('a');  
        System.out.println("삭제 후 =>"+v1);
        
        
        
        //get(index) ==> 벡터의 index 번쨰 데이터를 반환한다.
         int data = (int)v1.get(0);
         System.out.println("0번째 데이터 :"+data);
         System.out.println();
 		 System.out.println("-----------------");
        
        //---------------------------------------
        /*
         * 제네릭 타입(Generic Type)이라는 것은
         * 객체를 선언할 때 < > 안에 그 Collection이 사용할 데이터 타입을 지정해 주는것이다.
         * 이런식으로 선언하게 되면  그 데이터 타입 이외의 다른 데이터를 저장할 수 없게 된다.
         * 단, 제네릭으로 선언될 수 있는 데이터 타입은 클래스형 이어야 한다.
         * int  -->Integer
         * boolean -->Boolean
         * char --> Character
         * 사용해야 한다.
         */
        Vector<Integer> v2 = new Vector<Integer>(); //int 형만 저장할 수 있는 Vector
        Vector<String> v3 = new Vector<>();			//String 형만 저장 할 수 있는 Vector
        
        v3.add("안녕하세요");
        //  v3.add(123);  //오류 : 지정한 제네릭과 다른 종류의 데이터를 추가 할 수 없다.
        
        String temp2 = v3.get(0); ///get앞에서 형변환을 하지 않앗음.. 제네릭에서는 할 필요가 없다.
        
        Vector<Vector> vv = new Vector<>(); //2차원의 배열과 같다.
        //Vector<Vector<Vector>>//3차원 배열과 같다.
        Vector<Vector<Vector>>  vvv = new Vector<>();
        
        //-----------------------------------------------------------------------
        
        //clear() ==> 벡터의 전체 데이터를 모두 삭제한다.(크기를 0으로 만든다.)
        v3.clear();
        System.out.println("v3의 size :"+ v3.size());
       
        
        v3.add("AAA");
        v3.add("BBB");
        v3.add("CCC");
        v3.add("DDD");
        v3.add("EEE");
        
        Vector<String> v4 = new Vector<>();
        v4.add("BBB");
        v4.add("EEE");
        
        System.out.println("v3 =>" + v3);
        System.out.println("v4 =>" + v4);
        
        
        //removeALL(Collection 객체)==> 'Collection객체'가 가지고 있는 데이터를 모두 삭제한다.
        v3.removeAll(v4); //v3이 가지고 있는 데이터에서 v4랑 같은거를 모두 지워라
        System.out.println("v3 =>" + v3);
        
        System.out.println("--------------------------------------------------");
        System.out.println();
        
        
        v3.clear();
        v3.add("AAA");
        v3.add("BBB");
        v3.add("CCC");
        v3.add("DDD");
        v3.add("EEE");
        
        
        //벡터의 데이터를 순서대로 모두 가져와 사용하고 싶으면 반복문을 사용하면 된다.(주로for문을 많이 사용한다.)
        
        for(int i = 0; i<v3.size(); i++){
        	System.out.println(i+"번째 자료 :"+v3.get(i));
        }
        
        System.out.println("--------------------------------------------------");

        //향상된 for문
        for(String str : v3){
        	System.out.println(str);
        }
        
        System.out.println("--------------------------------------------------");
        
        
        
	}

}
