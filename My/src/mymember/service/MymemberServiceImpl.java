package mymember.service;

import java.util.List;
import java.util.Map;

import mymember.dao.IMymemberDao;
import mymember.dao.MymemberDaoImpl;
import mymember.vo.A_ArticleVO;
import mymember.vo.ArticleInterestMemVO;
import mymember.vo.AuctionVO;
import mymember.vo.Com_AnswerVO;
import mymember.vo.Com_QuestionVO;
import mymember.vo.InterestVO;
import mymember.vo.MemberVO;
import sun.security.jca.GetInstance;

public class MymemberServiceImpl implements IMymemberService {

	private static MymemberServiceImpl service;
	
	private IMymemberDao dao;
	
	public  MymemberServiceImpl() {
		dao = MymemberDaoImpl.getInstance();
	}
	public static IMymemberService getInstance() {
		if(service == null) service = new MymemberServiceImpl();
		return service;
	}
	@Override
	public List<InterestVO> getAllInterstProd(String mem_id) {
		return dao.getAllInterstProd(mem_id);
	}

	@Override
	public int updataMyInfo(MemberVO memVO) {
		return dao.updataMyInfo(memVO);
	}

	@Override
	public MemberVO getMyInfoList(String mem_id) {
		return dao.getMyInfoList(mem_id);
	}

	
	@Override
	public ArticleInterestMemVO getMyArticle(String A_ART_NO) {
		return dao.getMyArticle(A_ART_NO);
	}

	@Override
	public int deleteMySec(MemberVO memVO) {
		return dao.deleteMySec(memVO);
	}
	@Override
	public List<Com_QuestionVO> getMyQuestion(String mem_id) {
		return dao.getMyQuestion(mem_id);
	}
	
	@Override
	public Map<Com_AnswerVO, String> getMyAnswer(String com_que_writeID) {
		return dao.getMyAnswer(com_que_writeID);
	}
	

}
