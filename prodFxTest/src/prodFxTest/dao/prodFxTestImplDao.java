package prodFxTest.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import prodFxTest.vo.LprodVO;
import prodFxTest.vo.prodVO;
import sun.security.jca.GetInstance;
import util.BuildSqlMapClient;

public class prodFxTestImplDao implements prodFxTestDao{
	
	
	private SqlMapClient smc;
	
	private static prodFxTestImplDao dao;
	
	public prodFxTestImplDao() {
		smc = BuildSqlMapClient.getSqlMapClient();
	}
	
	public static prodFxTestImplDao getInstance() {
		if(dao == null) dao = new prodFxTestImplDao();
		
		return dao;
			
	}
	
	
	//  lprod 박스
	@Override
	public List<LprodVO> getAllLprod() {
		List<LprodVO> 	lprodList = null;
		
		try {
			lprodList = smc.queryForList("prod.getAllLprod");
		} catch (SQLException e) {
			lprodList = null;
			e.printStackTrace();
		}
		return lprodList;
	}
	
	// lprod에서 선택하면  tableview에   prod 정보를 뿌려주는거 
	@Override
	public List<prodVO> tableView(String prod_id) {
		List<prodVO> prodListId = null;
		try {
			prodListId = smc.queryForList("prod.tableView",prod_id);
		} catch (SQLException e) {
			prodListId = null;
			e.printStackTrace();
		}
		return prodListId;
	}
	
	// prod 리스트에서 하나를 선택하면 
	@Override
	public List<prodVO> getSelectProd(String prod_lgu) {
		List<prodVO> selectProd = null;
		try {
			selectProd = smc.queryForList("prod.getSelectProd",prod_lgu);
		} catch (SQLException e) {
			selectProd = null;
			e.printStackTrace();
		}
		return null;
	}
	
}
