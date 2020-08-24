package memberInfo.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import memberInfo.vo.memberInfoVO;
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
	
	// 검색
	@Override
	public List<memberInfoVO> getAllmember() {
		List<memberInfoVO> memList = null;
		try {
			memList = smc.queryForList("memberList.getAllmember");
		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		}
		return memList;
	}

	@Override
	public int updateMember(memberInfoVO memVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertMember(memberInfoVO memVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String memId) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 테이블 뷰에 정보 나오는거 
	@Override
	public List<memberInfoVO> tableview(String mem_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
