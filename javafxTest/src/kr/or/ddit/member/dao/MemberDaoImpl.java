package kr.or.ddit.member.dao;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.BuildSqlMapClient;


public class MemberDaoImpl implements IMemberDao {
	
	
	private SqlMapClient smc; // iBatis용 객체 변수 선언
	
	private static MemberDaoImpl dao;
	
	//생성자
	private MemberDaoImpl(){
		/*
		try {
			// 1.iBtis의 환경설정 파일을 읽어와서 실행 시킨다.
			// 1-1. 문자 인코딩  캐릭터셋 설정
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			
			// 1-2.환경설정용 xml문서 읽어오기
			Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			
			// 1-3. 위에서 읽어온 Reader 객체를 이용하여 실제 작업에 사용할 객체를 생성한다.
			// 		==> 환경설정용 xml문서의 내용을 처리한 후 작업에 사용할 객체를 생성해 준다.
			 smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();

			
		} catch (IOException e) {
			System.out.println("iBatis 환경설정실패!!");
			e.printStackTrace();
		}
	
		*/
		
		smc = BuildSqlMapClient.getSqlMapClient();
		
		
	}
	
	public static MemberDaoImpl getInstance(){
		if(dao==null) dao = new MemberDaoImpl();
		
		return dao;
	}
	
	

	@Override
	public int insertMember(MemberVO memVO) {
		
		int cnt = 0;
		
	    try {
	       
		   Object obj = smc.insert("mymember.insertMember",memVO); //iBatis 용  객체변수 smc 는 맨위에 변수 해놓은거
			if(obj==null){ // insert 성공
				cnt = 1; 
				System.out.println("insert 작업 성공!~~~");
			}else{
				cnt = 0;
				System.out.println("insert 작업 실패 ㅜㅜㅜㅜ");
			}
         } catch (Exception e) {
             e.printStackTrace(); 
         }
	         
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		
		int cnt = 0;
		try {
			 cnt = smc.delete("mymember.deleteMember", memId); // iBatis 용  객체변수 smc
			if(cnt>0){
				System.out.println("delete 작업 성공  !!!!");
			}else{
				System.out.println("delete 작업 실패 ㅠㅜㅠ");
			}
            
         } catch (Exception e) {
        	 memId = null;
             e.printStackTrace();
         }
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVO) { //전체 수정하는 update
		
		int cnt = 0;
		
		try{
			
			cnt =  smc.update("mymember.updateMember", memVO);
			
			if(cnt>0){
				System.out.println("update 작업 성공!!");
			}else{
				System.out.println("update 작업 실패 ~~ㅜㅜ");
			}
            
           
         }catch (Exception e) {
        	 memVO = null;
             e.printStackTrace();
         }
         return cnt;
	}

	@Override
	public int getMemberCount(String memId) {
		 
	   int count = 0;
	         
       try {
         
    	   count = (int)smc.queryForObject("mymember.getMemberCount", memId);
            
       } catch (SQLException e){
    	   memId = null;
           e.printStackTrace();
       }
	         
	   return count;
	}

	@Override
	public List<MemberVO> getAllMember() {
		 
         
         List<MemberVO> memList = null;
         try {
        	 memList = smc.queryForList("mymember.getAllMember");
           
         } catch (SQLException e) {
        	 memList = null;
            e.printStackTrace();

         }
      
		return memList;
	}

	@Override
	public int updateMember(Map<String, String> paramMap) {
		// 수정할 데이터 따로 한가지씩 수정하는거 
		// 매개변수 paramMap의 구조
		//  key 			value
		// field			수정할 필드명
		// data				수정할 값
		// memId			수정할 회원ID
		
	
		int cnt = 0;
		
		
		 try {

			 cnt =  smc.update("mymember.updateMember2", paramMap);
				
				/*if(cnt>0){
					System.out.println("update 작업 성공!!");
				}else{
					System.out.println("update 작업 실패 ~~ㅜㅜ");
				}*/
	            
         } catch (SQLException e) {
            e.printStackTrace();
         } 
         
		return cnt;
	}

	@Override
	public List<MemberVO> getSearchMember(Map<String, String> searchMap) {
		//Map의 구조
		//  key              value 
		// field    		검색할 컬럼명
		// search   		검색할 내용
		
		List<MemberVO> memList = null;
		
		
		try { 
			memList = smc.queryForList("mymember.getSearchMember", searchMap);
			
			
		} catch (SQLException e) {
			memList = null;
			 e.printStackTrace();
		}
		
		return memList;
	}

	@Override
	public int getAllMemberCount() {
		int cnt =0;
		try {
			cnt = (int)smc.queryForObject("mymember.getAllMemberCount");
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
			return cnt;
	}
	
	
	
	@Override
	public List<MemberVO> getPagingMemberList(Map<String, Integer> pageMap) {
		List<MemberVO> memList = null;
		try {
			memList = smc.queryForList("mymember.getPagingMemberList",pageMap);
		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		}	
		
		return memList;
	}
	
}
