package mymember.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.sun.org.apache.bcel.internal.generic.Select;

import mymember.vo.A_ArticleVO;
import mymember.vo.ArticleInterestMemVO;
import mymember.vo.Com_AnswerVO;
import mymember.vo.Com_QuestionVO;
import mymember.vo.InterestVO;
import mymember.vo.MemberVO;
import util.BuildSqlMapClient;

public class MymemberDaoImpl implements IMymemberDao {

	private SqlMapClient smc;
	
	private static MymemberDaoImpl dao;
	
	public MymemberDaoImpl() {
		
		
		smc = BuildSqlMapClient.getSqlMapClient();
		
	}
	
	public static MymemberDaoImpl getInstance() {
		if(dao == null) dao =new MymemberDaoImpl();
		
		return dao;
	}
	
	
	// 관심 물건 다 가지고 오는거 
	@Override
	public List<InterestVO> getAllInterstProd(String mem_id) {
		List<InterestVO> interestList = null;
		try {
			interestList = smc.queryForList("mymember.getAllInterstProd",mem_id);
		} catch (SQLException e) {
			interestList = null;
			e.printStackTrace();
		}
		return interestList;
	}
	
	// 내정보 수정  아이디는 수정 안됨
	@Override
	public int updataMyInfo(MemberVO memVO) {
		int cnt = 0;
		try {
			cnt = smc.update("mymember.updataMyInfo", memVO);
			if(cnt >0 ) {
				System.out.println("update 작업성공!");
			}else {
				System.out.println("update 작업실패...");
			}
		} catch (Exception e) {
			memVO = null;
			e.printStackTrace();
		}
				
		return cnt;
	}
	
	// 내 정보 다 가져오는거 
	@Override
	public MemberVO getMyInfoList(String mem_id) {
		MemberVO myInfo = null;
		try {
			myInfo = (MemberVO) smc.queryForObject("mymember.getMyInfoList",mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myInfo;
	}
	

		
	// 내 경매 내역 
	@Override
	public ArticleInterestMemVO getMyArticle(String A_ART_NO) {
		ArticleInterestMemVO myAuctionList = null;
		try {
			myAuctionList = (ArticleInterestMemVO) smc.queryForObject("mymember.getMyArticle",A_ART_NO);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return myAuctionList;
	}

	// 회원 탈퇴 
	@Override
	public int deleteMySec(MemberVO memVO) {
		int cnt = 0;
		try {
			cnt = smc.delete("mymember.deleteMySec",memVO);
			if(cnt>0) {
				System.out.println("delete 작업성공!!");
			}else {
				System.out.println("delete 작없실패..");
			}
			
		} catch (Exception e) {
			memVO = null;
			e.printStackTrace();
		}
			return 0;
	}

	// 내 질문 가져오기
	@Override
	public List<Com_QuestionVO> getMyQuestion(String mem_id) {
		List <Com_QuestionVO> myQyestion = null;
		try {
			myQyestion = smc.queryForList("mymember.getMyQuestion",mem_id);
		} catch (SQLException e) {
			myQyestion = null;
			e.printStackTrace();
		}
		
		return myQyestion;
	}
	
	
	
	
	// 내 질문에 대한 답변
	@Override
	public Map <Com_AnswerVO, String> getMyAnswer(String com_que_writeID) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
