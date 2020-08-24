package basic.mvc.service;

import java.util.List;
import java.util.Map;

import basic.mvc.dao.IMemberDao;
import basic.mvc.dao.MemberDaoImpl;
import basic.mvc.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao; //DAO 객체가 저장 될 변수 선언
	
	private static MemberServiceImpl service;
	
	//생성자
	//public MemberServiceImpl() {
	private MemberServiceImpl() {
		//dao = new MemberDaoImpl(); // DAO 객체 생성
		dao =MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance(){
		if(service == null) service = new MemberServiceImpl();
		return service;
	}

	@Override
	public int insertMember(MemberVO memVO) {
		
		return dao.insertMember(memVO);
	}

	@Override
	public int deleteMember(String memId) {
		return dao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memVO) {
		return dao.updateMember(memVO);
	}
	
	@Override
	public int getMemberCount(String memId) {
		return dao.getMemberCount(memId);
	}

	@Override
	public List<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

	@Override
	public int updateMember(Map<String, String> paramMap) {
		return dao.updateMember(paramMap);
	}

	@Override
	public List<MemberVO> getSearchMember(Map<String, String> searchMap) {
		// TODO Auto-generated method stub
		return dao.getSearchMember(searchMap);
	}

}
