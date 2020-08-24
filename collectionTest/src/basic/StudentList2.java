package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* 문제)
 * 학번, 이름, 국어점수, 영어점수 , 수학점수, 총점, 등수를 멤버로 갖는 student클래스를 만든다.
 * 이 클래스의 생성자에서는 학번, 이름 ,국어점수, 영어점수, 수학점수만 매개변수로 받아서 처리한다.
 * 
 * 이 student 객체들은 list에 저장하여 관리한다.
 * 
 * list에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분(내부 정렬기준)과  총점의 역순으로 정렬하는 부분(외부정렬기준)을 프로그램하시오.
 * (그리고, 총점이 같으면 이름의 내림차순으로 정렬되도록 한다.)
 */

/*
 * ArrayList => 내부에서 데이터를 관리할 때 배열을 이용한다.
 * 
 * LinkedList => Link를 이용해서 데이터를 관리한다.
 */
 class Student implements Comparable<Student> {

		private int num; // 학번
		private String name; //이름
		private int korSC; //국어점수
		private int engSC; //영어점수
		private int mathSC; //수학점수
		private int sum; // 총점
		int rank; //등수
		

		public Student(int num, String name, int korSC, int engSC, int mathSC) {
			super();
			this.num = num;
			this.name = name;
			this.korSC = korSC;
			this.engSC = engSC;
			this.mathSC = mathSC;
			this.sum = korSC+engSC+mathSC;
			this.rank = 1;
		}

		//접근을 위해서 GETTER,SETTER 만들기
		public int getNum() {
			return num;
		}


		public int getSum() {
			return sum;
		}

		public void setSum(int sum) {
			this.sum = sum;
		}

		public int getRank() {
			return rank;
		}

		public void setRank(int rank) {
			this.rank = rank;
		}

		public void setNum(int num) {
			this.num = num;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public int getKorSC() {
			return korSC;
		}


		public void setKorSC(int korSC) {
			this.korSC = korSC;
		}


		public int getEngSC() {
			return engSC;
		}


		public void setEngSC(int engSC) {
			this.engSC = engSC;
		}


		public int getMathSC() {
			return mathSC;
		}


		public void setMathSC(int mathSC) {
			this.mathSC = mathSC;
		}
		
		
		//toString 만들기 입력값을 string으로 받는거
		@Override
		public String toString() {

			return "Student [학번="+num+", 이름="+name+", 국어점수"+korSC+", 영어점수"+engSC+", 수학점수"+mathSC+", 총점"+sum+", 등수"+rank+"]";
		}
		
		// 학번을 기준으로 오름차순 정렬(내부정렬)
		@Override
		public int compareTo(Student str1) {
			/*if(this.getNum() > str1.getNum()){ 
				return 1; 
			   }else if(this.getNum()==str1.getNum()){ 
				   return 0; 
			    }else{
			    	return -1;
			    	}*/
			
			return Integer.compare(this.getNum(), engSC);
				
			}
			
		}

	
 
 
 public class  StudentList2{
	 public static void main(String[] args) {
		 ArrayList<Student> stuList = new ArrayList<>();
		 
		 //초기 데이터 입력하기
		 stuList.add(new Student(12,"연지은",90,80,70));
		 stuList.add(new Student(13,"김가나",52,96,65));
		 stuList.add(new Student(11,"최다라",40,20,70));
		 stuList.add(new Student(10,"이마바",40,20,70));
		 stuList.add(new Student(14,"박사아",100,80,50));
		 
		 
		 //등수 구하기
		 for(int i = 0; i < stuList.size(); i++){
			 for(int j = 0; j < stuList.size(); j++){
				 if(stuList.get(i).getSum()< stuList.get(j).getSum()){
					 stuList.get(i).rank++;
				 }
			 }
		 }
		 //정렬 전
		 System.out.println("정렬전...");
		 for(Student st : stuList){// stuList 만큼 for문을 돌려서 st에 담는다 **향상된 for 문**
			 System.out.println(st);
		 }
		 System.out.println("--------------------------------");
		//-------------------------------------------------------------
		 
		 // 학번의 오름차순으로 정렬하는거
		 Collections.sort(stuList);
		
		 // 학번의 오름차순 정렬 후 출력
		 System.out.println("정렬 후 ...");
		 for(Student st : stuList){
			 System.out.println(st);
		 }
		 System.out.println("----------------------------------");
		 
		 //-------------------------------------------------------------
		 Collections.sort(stuList, new SortDesc()); //총점의 역순 정렬을 가져오는거
		 
		 //총점의 내림차순 정렬 후 출력하는거 
		 for(Student st : stuList){
			 System.out.println(st);
		 }
		 System.out.println("----------------------------------");
		 
		}
	 
	 }
 
 
		 //총점의 역순으로 정렬(외부정렬기준)
		class SortDesc implements Comparator<Student>{
			
			@Override
			public int compare(Student st3, Student st4) {
				if(new Integer(st3.getSum()).compareTo(st4.getSum())*-1==0){
					return st3.getName().compareTo(st4.getName())*-1;
				}
				return new Integer(st3.getSum()).compareTo(st4.getSum())*-1;
			}
			
		}
		 
		
		 
		 
	
		 

