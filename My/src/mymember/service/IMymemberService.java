package mymember.service;

import java.util.List;
import java.util.Map;

import mymember.vo.A_ArticleVO;
import mymember.vo.ArticleInterestMemVO;
import mymember.vo.AuctionVO;
import mymember.vo.Com_AnswerVO;
import mymember.vo.Com_QuestionVO;
import mymember.vo.InterestVO;
import mymember.vo.MemberVO;

public interface IMymemberService {

		// 관심물건  물건번호,물건명,경매날짜 가져오는거 
		public List <InterestVO> getAllInterstProd(String mem_id);
		
		
		// 내 정보 수정  ==> 아이디는 수정이 안되는거 
		public int  updataMyInfo(MemberVO memVO);
		
		// 내 정보 가져오는 거
		public MemberVO  getMyInfoList(String mem_id);
		
		
		
		// 내 질문 목록 가져오는거 
		public List<Com_QuestionVO> getMyQuestion(String mem_id);
		
		
		// 질문에 대한 답변 가져오는거 
		public Map <Com_AnswerVO,String> getMyAnswer(String com_que_writeID);
	
		
		// 내 경매 내역 가져오는거 (물건번호, 물건이름, 경매결과)
		public ArticleInterestMemVO getMyArticle(String A_ART_NO);
		
		
		// 회원탈퇴
		public int deleteMySec(MemberVO memVO);
		
}
