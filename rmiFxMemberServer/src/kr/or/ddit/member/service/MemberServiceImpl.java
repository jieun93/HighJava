package kr.or.ddit.member.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Map;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;


public class MemberServiceImpl extends UnicastRemoteObject implements IMemberService {
	private IMemberDao dao; //DAO 객체가 저장 될 변수 선언
	
	private static MemberServiceImpl service;
	
	//생성자
	//public MemberServiceImpl() {
	private MemberServiceImpl() throws RemoteException {
		//dao = new MemberDaoImpl(); // DAO 객체 생성
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance(){
		try {
			if(service == null) service = new MemberServiceImpl();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return service;
	}

	@Override
	public int insertMember(MemberVO memVO) throws RemoteException  {
		
		return dao.insertMember(memVO);
	}

	@Override
	public int deleteMember(String memId) throws RemoteException  {
		return dao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memVO) throws RemoteException  {
		return dao.updateMember(memVO);
	}
	
	@Override
	public int getMemberCount(String memId) throws RemoteException  {
		return dao.getMemberCount(memId);
	}
	
	
	// 모든 멤버들을 가져오는 메서드
	@Override
	public List<MemberVO> getAllMember()  throws RemoteException {
		return dao.getAllMember();
	}

	@Override
	public int updateMember(Map<String, String> paramMap) throws RemoteException {
		return dao.updateMember(paramMap);
	}

	@Override
	public List<MemberVO> getSearchMember(Map<String, String> searchMap) throws RemoteException  {
		// TODO Auto-generated method stub
		return dao.getSearchMember(searchMap);
	}

	
	@Override
	public int getAllMemberCount() throws RemoteException  {
		return dao.getAllMemberCount();
	}
	
	@Override
	public List<MemberVO> getPagingMemberList(Map<String, Integer> pageMap)throws RemoteException  {
		return dao.getPagingMemberList(pageMap);
	}
	
	
	
	
	
}
