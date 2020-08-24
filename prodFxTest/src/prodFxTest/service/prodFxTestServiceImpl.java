package prodFxTest.service;

import java.util.List;

import prodFxTest.dao.prodFxTestDao;
import prodFxTest.dao.prodFxTestImplDao;
import prodFxTest.vo.LprodVO;
import prodFxTest.vo.prodVO;

public class prodFxTestServiceImpl implements prodFxTestservice {
	
	// 싱글톤 만들기
	private static prodFxTestServiceImpl service;
	
	private prodFxTestDao dao;
	
	// 생성자 만들기
	public prodFxTestServiceImpl() {
		dao=prodFxTestImplDao.getInstance();
	}
	
	public static prodFxTestServiceImpl getinstance() {
		if(service == null) service = new prodFxTestServiceImpl();
		return service;
	}
	
	
	@Override
	public List<LprodVO> getAllLprod() {
		return dao.getAllLprod();
	}

	@Override
	public List<prodVO> tableView(String prod_id) {
		return dao.tableView(prod_id);
	}

	@Override
	public List<prodVO> getSelectProd(String prod_lgu) {
		return dao.getSelectProd(prod_lgu);
	}

}
