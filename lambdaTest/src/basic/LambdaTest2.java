package basic;

public class LambdaTest2 {
	
	public static void main(String[] args) {
		   // 람다식을 사용하지 않은 경우
		   LambdaTestInterface  t1 = new LambdaTestInterface() {  //여기서 ctrl +space
			
			@Override
			public void test() {
				System.out.println("람다식을 사용하지 않은 경우입니다.");
			 	}
			};
		
				t1.test();
				
				
			// 람다식 사용하는 방법	
				
		
			LambdaTestInterface t2 = 
				//매개변수가 없으니  ()만 적는다.
				() ->{System.out.println("안녕...람다식입니니다.111");};
				t2.test();   // 람다식 실행 
				
				
			LambdaTestInterface t3 = 
				// 괄호없이 사용하는 방법			
				() ->System.out.println("안녕...람다식입니니다.2222222");		
				t3.test();
			
			System.out.println("---------------------------------------------");	
			
			
			LambdaTestInterface2  t4 = (int a ) ->{
				int result =  a + 40;
				System.out.println(a+" + 40 ="+result);
			
				};
				t4.test(30);
			
			LambdaTestInterface2 t5 = k -> {
				int result = k * 20;
				System.out.println(k+" * 20 = "+result);
			};
			t5.test(30);
			
			
			LambdaTestInterface2 t6 = k -> System.out.println(k+" - 10 = "+(k-10));
			t6.test(30);
			System.out.println("=====================================================");
			
			
			LambdaTestInterface3 t7 = (int x, int y) ->{ //자료형 생략가능
				int result = x + y;
				return result;
			};
			int k = t7.test(20, 50);
			System.out.println("k = " + k);
			
			LambdaTestInterface3 t8 = (int x, int y) ->{ //자료형 생략가능
				int result = x - y;
				return result;
			};
			int j = t8.test(40, 10);
			System.out.println("j = " + j);
			
			
			
			LambdaTestInterface3 t9 = (int x, int y) ->{ //자료형 생략가능
				
				return x * y;
			};
			int i = t9.test(4, 6);
			System.out.println("i = " + i);
			
			
			LambdaTestInterface3 t10 = (int x, int y) -> x / y;
				
			int a = t10.test(20, 4);
			System.out.println("a = " + a);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
				
			
			
			
	}
}
