package kr.or.ddit.service.adminmypage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import kr.or.ddit.dao.adminmypage.ImemberInfodao;
import kr.or.ddit.dao.adminmypage.memberInfoDaoImpl;
import kr.or.ddit.vo.MemberInfoVO;


public class memberInfoServiceImpl extends UnicastRemoteObject implements ImemberInfoService {

	private static memberInfoServiceImpl service;
	
	private ImemberInfodao dao;
	
	public memberInfoServiceImpl()  throws RemoteException{
		dao = memberInfoDaoImpl.getInstance();
	}
	
	public static ImemberInfoService getinstance() {
			try {
				if(service == null)
				service = new memberInfoServiceImpl();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
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

	
}
