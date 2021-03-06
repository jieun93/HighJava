package kr.or.ddit.service.mypage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.mypage.IMymemberDao;
import kr.or.ddit.dao.mypage.MymemberDaoImpl;
import kr.or.ddit.vo.ArticleInterestMemVO;
import kr.or.ddit.vo.Com_AnswerVO;
import kr.or.ddit.vo.Com_QuestionVO;
import kr.or.ddit.vo.InterestVO;
import kr.or.ddit.vo.MemberVO;
import sun.security.jca.GetInstance;

public class MymemberServiceImpl extends UnicastRemoteObject implements IMymemberService {

	private static MymemberServiceImpl service;
	
	private IMymemberDao dao;
	
	public  MymemberServiceImpl() throws RemoteException {
		dao = MymemberDaoImpl.getInstance();
	}
	public static IMymemberService getInstance() {
			try {
				if(service == null)
				service = new MymemberServiceImpl();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return service;
	}
	@Override
	public List<InterestVO> getAllInterstProd(String mem_id) throws RemoteException
	{
		return dao.getAllInterstProd(mem_id);
	}

	@Override
	public int updataMyInfo(MemberVO memVO) throws RemoteException{
		return dao.updataMyInfo(memVO);
	}

	@Override
	public MemberVO getMyInfoList(String mem_id) throws RemoteException{
		return dao.getMyInfoList(mem_id);
	}

	
	@Override
	public List<ArticleInterestMemVO> getMyArticle(String mem_id) throws RemoteException{
		return dao.getMyArticle(mem_id);
	}

	@Override
	public int deleteMySec(MemberVO memVO) throws RemoteException {
		return dao.deleteMySec(memVO);
	}
	@Override
	public List<Com_QuestionVO> getMyQuestion(String mem_id) throws RemoteException {
		return dao.getMyQuestion(mem_id);
	}
	
	@Override
	public Map<Com_AnswerVO, String> getMyAnswer(String com_que_writeID)throws RemoteException{
		return dao.getMyAnswer(com_que_writeID);
	}
	

}
