package kr.or.ddit.zip.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.BuildSqlMapClient;
import kr.or.ddit.zip.vo.ZipVO;

public class zipDaoImpl implements IzipDao {

	private SqlMapClient smc;
	
	private static zipDaoImpl dao;
	
	private zipDaoImpl() {
		
		smc = BuildSqlMapClient.getSqlMapClient();
		
	}
	
	public static zipDaoImpl getInstance() {
		if(dao == null ) dao = new zipDaoImpl();
		return dao;
	}

	@Override
	public List<ZipVO> getZipSearchDong(String dong) {
		List<ZipVO> zipList =null;
		try {
			zipList = smc.queryForList("zip.getZipSearchDong", dong);
		} catch (SQLException e) {
			zipList = null;
			e.printStackTrace();
		}
			return zipList;
	}

	@Override
	public List<ZipVO> getZipSearchCode(String code) {
		List<ZipVO> zipCodeList = null;
		try {
			zipCodeList = smc.queryForList("zip.getZipSearchCode",code);
		} catch (SQLException e) {
			zipCodeList = null;
			e.printStackTrace();
		}
		return zipCodeList;
	}    
	
	
	
	
	

}
