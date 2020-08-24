package basic;
/*
 * 학생이름과 여러과목의 점수를 매개변수로 받아서 
그 학생의 평균과 평점(a학점)을 구해서 학생이름, 
각 과목 점수, 평균, 평점을 출력하는 메서드를 만드시오.
(각 학생별로 시험 과목수가 일정하지 않다.)
*/

public class Student {
	// 학생이름하고 여러 점수를 받는 매개변수 
	public void calcScore(String name, int...scores){
		
		//총점구하기
		int tot = 0;
		for(int i = 0; i<scores.length; i++){
			tot += scores[i];
		}
		
		//평균구하기(점수의 개수가 과목수)
		  double avg = (double)tot/ scores.length;
		
		  //평균을 이용해서
		  String g = "";
		  if(avg>=90){
			  g = "A";
		  }else if(avg>=80){
			  g ="B";
		  }else if(avg>=70){
			  g="C";
		  }else if(avg>=60){
			  g="F";
		  }
		  
		  
		  System.out.print(name + "\t");
		  for(int score : scores){
			  System.out.print(score + "\t");
		  }
		  
		  System.out.println(avg + "\t" + g);
	}

	
	
	
	
	public static void main(String[] args) {
		Student  test = new Student();
		
		test.calcScore("연지은", 100,70,40,80,90);
		
		
	}

}
