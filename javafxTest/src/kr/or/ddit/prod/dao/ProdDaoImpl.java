package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.prod.vo.LprodVO;
import kr.or.ddit.prod.vo.ProdVO;
import kr.or.ddit.util.BuildSqlMapClient;
import sun.security.jca.GetInstance;

public class ProdDaoImpl implements ProdDao {
	// 싱글톤 만들기 
	private static ProdDaoImpl dao;
	
	private SqlMapClient smc;
	
	// 생성자 
	private ProdDaoImpl() {
		
		smc = BuildSqlMapClient.getSqlMapClient();
		
	}
	
	public static ProdDaoImpl getInstance() {
		if(dao==null) dao= new ProdDaoImpl();
		
		return dao;
	}


	@Override
	public List<LprodVO> getAllLProd() {
		
		List<LprodVO> lprodList = null;
		
		try {
			// xml에서 squel namespace 하고 id
			lprodList = smc.queryForList("prod.getAllLProd");
		} catch (SQLException e) {
			lprodList = null;
			e.printStackTrace();
		}
		return lprodList;
	}


	@Override
	public List<ProdVO> getAllProd(String prod_lgu) {
		List<ProdVO> prodListLgu = null;
		try {
			prodListLgu = smc.queryForList("prod.getAllProd",prod_lgu);
		} catch (SQLException e) {
			prodListLgu = null;
			e.printStackTrace();
		}
			return prodListLgu;
	}


	@Override
	public List<ProdVO> tableView(String prod_id) {
		List <ProdVO>   prodListId = null;
		try {
			prodListId = smc.queryForList("prod.tableView",prod_id);
			
		} catch (SQLException e) {
			prodListId = null;
			e.printStackTrace();
		}
		return prodListId;
	}


	
	
	
	
}
