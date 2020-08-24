package memberInfo.service;

import java.util.List;

import memberInfo.dao.ImemberInfodao;
import memberInfo.dao.memberInfoDaoImpl;
import memberInfo.vo.MemberInfoVO;

public class memberInfoServiceImpl implements ImemberInfoService {

	private static memberInfoServiceImpl service;
	
	private ImemberInfodao dao;
	
	public memberInfoServiceImpl() {
		dao = memberInfoDaoImpl.getInstance();
	}
	
	public static ImemberInfoService getinstance() {
		if(service == null) service = new memberInfoServiceImpl();
		return service;
	}

	@Override
	public List <MemberInfoVO> getSearchMember(String mem_id) {
		return dao.getSearchMember(mem_id);
	}

	@Override
	public int updateMember(MemberInfoVO memVO) {
		return dao.updateMember(memVO);
	}

	@Override
	public int insertMember(MemberInfoVO memVO) {

		return dao.insertMember(memVO);
	}

	@Override
	public int deleteMember(String memId) {
		return dao.deleteMember(memId);
	}

	@Override
	public List<MemberInfoVO> tableview(String mem_id) {
		return dao.tableview(mem_id);
	}

	@Override
	public List<MemberInfoVO> getMymember() {
		return dao.getMymember();
	}

	/*
	 * @Override public int insertMemID(memberInfoVO memVO) { return
	 * dao.insertMemID(memVO); }
	 */
}
