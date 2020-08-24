package basic.mvc.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import util.DBUtil;
import util.DBUtil3;
import basic.MemberInfoTest;
import basic.mvc.service.IMemberService;
import basic.mvc.service.MemberServiceImpl;
import basic.mvc.vo.MemberVO;

/*
 *  이 클래스는 Controller역할과 View역할을 같이 한다.
 */
public class MemberInfoMain {
	private IMemberService service; //service 객체가 저장될 변수 선언
	
	private Scanner scan =new Scanner(System.in);
	
	//생성자
	public MemberInfoMain() {
		//service = new MemberServiceImpl(); //service 객체 생성
		service = MemberServiceImpl.getInstance(); //service 객체 생성
	}
	
	
	
	public static void main(String[] args) {
		 new MemberInfoMain().memberStart();
	}
		   public int displayMenu(){
		         System.out.println("--------------------------------");
		         System.out.println("\t==작업 선택 ==");
		         System.out.println("\t1.자료 입력 ");
		         System.out.println("\t2.자료 삭제 ");
		         System.out.println("\t3.자료 수정 ");
		         System.out.println("\t4.자료 수정2 ");
		         System.out.println("\t5.자료 검색 ");
		         System.out.println("\t6.전체 자료 출력 ");
		         System.out.println("\t0.작업 끝 ");
		         System.out.println("-------------------------------");
		         System.out.println("작업선택>> ");
		         int num=scan.nextInt();
		         return num;
		      }

		      public void memberStart(){
		         while(true){
		            int choice=displayMenu();
		         
		            switch(choice){
		            case 1 :   //입력 (추가)
		               memberInsert();
		               break;
		            case 2 :   //삭제
		               memberDelete();
		               break;
		            case 3 :   //수정
		               memberUpdate();
		               break;
		            case 4 :   //수정2
		               memberUpdate2();
		               break;
		            case 5 :   //검색
			            memberSearch();
			           break;
		            case 6 :   //전체자료 출력
		               displayMember();
		               break;
		            case 0 : System.out.println("작업을 종료합니다.");
		               return;
		            default : System.out.println("작업 선택이 잘못되었습니다.");
		                        System.out.println("다시입력하세요");
		         
		               
		            }
		            
		         }
		      }
		      
		      //회원 정보를 검색하는 메서드 
		      public void memberSearch(){
		    	  // 검색할 필드를  보여주고 사용자가 선택하게 한다음
		    	  // 검색할 내용을 입력 받아서 
		    	  // 사용자가 선택한 필드에 입력받은 내용이 포함되는 모든 자료를 출력한다.
		    		//Map의 구조
		  		//  key              value 
		  		// field    		검색할 컬럼명
		  		// search   		검색할 내용 
		    	  
		    	     System.out.println();
		    	     
		    	     String fieldName = "";
		    	     String searchData = "";
		    	     
		    	     System.out.println();
			         System.out.println("검색할 정보를 입력하세요.");
			         System.out.println("1.회원번호 2.회원이름  3.전화번호 4.주소");
			         System.out.println("------------------------------");
			         System.out.print(" 항목 선택 >>");
			     
			         int num = scan.nextInt(); 
			         
			         switch(num){
			         case 1 : fieldName = "mem_id";
			        	 break;
			         case 2 : fieldName = "mem_name";
			        	 break;
			         case 3 : fieldName = "mem_tel";
			        	 break;
			         case 4 : fieldName = "mem_addr";
			        	 break;
			        	 default:
			        		 System.out.println("검색할 데이커를 잘못 선택했습니다.");
			        		 System.out.println("검색작업을 마칩니다.");
			        		 return;
			         }
			         System.out.println();
			         System.out.println("검색할 내용>>");
			         searchData = scan.next();
			         
			         Map<String, String> searchMap = new HashMap<>();
			         searchMap.put("field", fieldName);
			         searchMap.put("search", searchData);
			         
			         List<MemberVO> memList = service.getSearchMember(searchMap);
			         
			         System.out.println();
		             System.out.println("--------------------------------");
		             System.out.println("   ID    이름   전화번호     주소");
		             System.out.println("--------------------------------");
		             
		             if(memList == null ||memList.size()==0){
		            	 System.out.println("출력할 데이터가 없습니다.");
		             }else{
		             
		             for(MemberVO memVO : memList){ //List 개수만큼 반복
		            	
		            //반복문에서 각각의 MemberVO에 저장된 데이터를 출력한다.
		                String memId=memVO.getMem_id();
		                String memName=memVO.getMem_name();
		                String memTel=memVO.getMem_tel();
		                String memAddr=memVO.getMem_addr();
		                
		                System.out.println(" " + memId +"   "+memName+"    "+memTel+"    "+memAddr);
		                 
		                
		             }
		            }
		             
		             System.out.println("-------------------------------");
		             System.out.println("출력끝");
		             
		          } 
			      
			       
		      
		   // 회원 정보를 수정하는 메서드2
		      public void memberUpdate2(){
		        
		         System.out.println();
		         System.out.println("수정할 회원 정보를 입력하세요.");
		         System.out.print("수정할 회원ID >> ");
		         String memId = scan.next();
		         
		         int count = service.getMemberCount(memId);
		         
		         if(count==0){
		            System.out.println(memId + "은 없는 회원ID입니다. 수정작업을 종료합니다.");
		            return;
		         }
		         
		         
		         int num = 0;      // 선택한 항목 번호가 저장될 변수
		         String selField = "";  // 선택한 항목의 컬럼명이 저장될 변수
		         String msg = "";
		         do{
		            System.out.println();
		            System.out.println("수정할 항목을 선택하세요");
		            System.out.println(" 1.회원이름     2.전화번호     3.주소 ");
		            System.out.println("---------------------------");
		            System.out.print(" 항목선택 >> ");
		            num = scan.nextInt();
		            
		            switch(num){
		               case 1 : selField = "mem_name"; msg = "새로운 회원 이름"; 
		                  break;
		               case 2 : selField = "mem_tel"; msg = "새로운 전화번호";
		                  break;
		               case 3 : selField = "mem_addr"; msg = "새로운 주소";
		                  break;
		               default : System.out.println("항목선택을 잘못했습니다. 다시 선택하세요");
		            }
		         }while(num<1 || num>3);
		         
		         
		         System.out.print(msg + " >> ");
		         String data = "";
		         if(selField.equals("mem_addr")){
		            scan.nextLine(); // 버퍼 비우기
		            data = scan.nextLine();
		         }else{
		            data = scan.next();
		         }
		         
		         
		        // 매개변수로 사용할 Map객체 생성
		     	// 매개변수 paramMap의 구조
		 		//  key 			value
		 		// field			수정할 필드명
		 		// data				수정할 값
		 		// memId			수정할 회원ID
		 		
		         Map<String, String> paramMap = new HashMap<>();
		         paramMap.put("field", selField);
		         paramMap.put("data", data);
		         paramMap.put("memId", memId);
		               
		             int cnt = service.updateMember(paramMap);
		             
		             if(cnt>0){
		                System.out.println(memId + "회원의 " + selField + " 정보가 수정되었습니다.");
		             }else{
		                System.out.println("수정 작업 실패");
		             }
		           
		         } 
		      
		      
		      
		      
		      //회원정보를 수정하는 메서드
		      public void memberUpdate(){
		        	         
		         System.out.println();
		         System.out.println("수정할 회원 정보를 입력하세요");
		         System.out.println("수정할 회원ID >> ");
		         String memId=scan.next();
		         
		         int count = service.getMemberCount(memId);
		         
		         if(count==0){
		            System.out.println(memId + "은 없는 회원ID입니다. 수정작업을 종료합니다.");
		            return;
		         }
		         System.out.println("새로운 회원이름 >>");
		         String memName=scan.next();
		         
		         System.out.println("새로운 회원전화번호 >>");
		         String memTel=scan.next();
		         
		         scan.nextLine(); //버퍼비우기
		         System.out.println("새로운 회원주소 >>");
		         String memAddr=scan.nextLine();
		         
		         MemberVO memVO = new MemberVO();
		         memVO.setMem_id(memId);
		         memVO.setMem_name(memName);
		         memVO.setMem_tel(memTel);
		         memVO.setMem_addr(memAddr);
		         
		         
		            int cnt=service.updateMember(memVO);
		            
		            if(cnt>0){
		               System.out.println(memId+ "회원의 정보가 수정되었습니다.");
		            }else{
		               System.out.println("수정작업실패");
		            }
		         }
		      
		         
		      
		      
		      
		    //회원 정보를 삭제하는 메서드
		      public void memberDelete(){
		         
		    	 System.out.println();
		         System.out.println("삭제할 회원 정보를 입력하세요");
		         System.out.println("삭제할 회원ID");
		         String memId=scan.next();
		         
		         int count=service.getMemberCount(memId);
		         
		         if(count==0){
		            System.out.println(memId + "는 없는 회원ID입니다.");
		            return;
		         }
		            int cnt = service.deleteMember(memId);
		            
		            if(cnt>0){
		               System.out.println(memId + "회원의 정보가 삭제되었습니다.");
		            }else{
		               System.out.println("삭제 작업 실패!!");
		            }
		         }
		         
		      
		      
		      
		      
		      
		      
		      
		    //새로운 회원 정보를 추가하는 메서드
		      public void memberInsert(){
		        	         
		         System.out.println();
		         System.out.println("추가할 회원 정보를 입력하세요");
		         
		         System.out.print("회원ID >> ");
		         String memId = scan.next();
		         int count = service.getMemberCount(memId);
		         
		         if(count>0){
		            System.out.println(memId+"는 이미 가입된 회원ID입니다.");
		            //System.out.println("다른 ID로 다시 입력하세요 ");
		            return;
		         }
		         
		         System.out.print("회원이름 >> ");
		         String memName=scan.next();
		         
		         System.out.print("회원전화번호 >> ");
		         String memTel=scan.next();
		         
		         scan.nextLine(); //입력 버퍼 비우기 
		         System.out.print("회원주소 >> ");
		         String memAddr=scan.nextLine();
		         
		         MemberVO memVO = new MemberVO(); //입력한  추가할 데이터를 저장할 MemberVO 객체 생성
		         
		         //setter를 이용해서 입력한 값들을 vo 객체에 저장한다.
		         memVO.setMem_id(memId);
		         memVO.setMem_name(memName);
		         memVO.setMem_tel(memTel);
		         memVO.setMem_addr(memAddr);
		         
		       //vo객체를 이용해서 추가해주는 service 객체 쪽의 메서드를 호출한다.
		         int cnt = service.insertMember(memVO); 
		         
		         
		         if(cnt>0){
		        	 System.out.println(memId + "회원이 추가 되었습니다.");
		         }else {
		        	 System.out.println("추가 작업 실패 ㅜㅜ");
		         }
		         
		      }
		      
		      
		      
		      //회원 전체 자료를 출력하는 메서드 
		      
		      public void displayMember(){
		    	  
		    	  	//service에 있는 getAllMember()메서드를 호출해서 전체 회원정보를 가져온다.
		    	   	List <MemberVO> memList = service.getAllMember();
		    	  
		             System.out.println();
		             System.out.println("--------------------------------");
		             System.out.println("   ID    이름   전화번호     주소");
		             System.out.println("--------------------------------");
		             for(MemberVO memVO : memList){ //List 개수만큼 반복
		            	
		            //반복문에서 각각의 MemberVO에 저장된 데이터를 출력한다.
		                String memId=memVO.getMem_id();
		                String memName=memVO.getMem_name();
		                String memTel=memVO.getMem_tel();
		                String memAddr=memVO.getMem_addr();
		                
		                System.out.println(" " + memId +"   "+memName+"    "+memTel+"    "+memAddr);
		                 
		                
		             }
		             System.out.println("-------------------------------");
		             System.out.println("출력끝");
		             
		          } 
		       }
		      
	

