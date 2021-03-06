package kr.or.ddit.dao.adminmypage;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.vo.MemberInfoVO;
import util.BuildSqlMapClient;


public class memberInfoDaoImpl implements ImemberInfodao {
	
	
	private SqlMapClient smc;
	
	private static memberInfoDaoImpl dao;
	
	public memberInfoDaoImpl() {
		smc = BuildSqlMapClient.getSqlMapClient();
		
	}
	
	public static memberInfoDaoImpl getInstance() {
		if(dao == null) dao = new memberInfoDaoImpl();
		
		return dao;
	}
	
	// 회원 id 검색
	@Override
	public List<MemberInfoVO> getSearchMember(String mem_id) {
		List<MemberInfoVO> memList = null;
		try {
			memList = smc.queryForList("memberList.getSearchMember",mem_id);
		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		}
		return memList;
	}

	@Override
	public int updateMember(MemberInfoVO memVO) {
		int cnt = 0;
		try {
			cnt = smc.update("memberList.updateMember",memVO);
			if(cnt>0) {
				System.out.println("update 작업성공!!");
			}else {
				System.out.println("update  작업실패...");
			}
		} catch (Exception e) {
			memVO = null;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int insertMember(MemberInfoVO memVO) {
		int cnt = 0;
		try {
			Object obj = smc.insert("memberList.insertMember",memVO);
			if(obj == null) {
				cnt = 1;
			System.out.println("insert 작업성공!!!!!");
			}else {
				cnt = 0;
				System.out.println("insert 작업실패...");
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
			cnt = smc.delete("memberList.deleteMember",memId);
			if(cnt>0) {
				System.out.println("delete 작업 성공 !!");
			}else {
				System.out.println("delete 작업 실패 ...");
			}
			
		} catch (Exception e) {
			memId = null;
			e.printStackTrace();
		}
		return 0;
	}

	
	// 테이블 뷰에 정보 나오는거 
	@Override
	public List<MemberInfoVO> tableview(String mem_id) {

		return null;
	}
	
	
	//테이블뷰 선택 후 회원정보 수정 버튼 누르면 정보 가져오는 거
	@Override
	public List<MemberInfoVO> getMymember (){
		List<MemberInfoVO> myInfo = null;
		try {
			myInfo = smc.queryForList("memberList.getMymember");
		} catch (SQLException e) {
			myInfo = null;
			e.printStackTrace();
		}
		return myInfo;
		
	}
	
	


}
