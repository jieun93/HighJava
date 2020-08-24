package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.ProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.LprodVO;
import kr.or.ddit.prod.vo.ProdVO;
import sun.security.jca.GetInstance;

public class ProdServiceImpl  implements ProdService{
	// 싱글톤
	private static ProdServiceImpl service;
	
	private ProdDao dao; //  dao 객체가 저장 될 변수 선언

	
	// 생성자 만들기 
	private ProdServiceImpl() {
		dao = ProdDaoImpl.getInstance(); 
	// daoimpl에서 getinstance를 해서 dao에 담아두기
	}
	
	
	public static  ProdServiceImpl getinstance() {
		if(service == null) service = new ProdServiceImpl();
		return service;
		
	}
	
	// dao에서  정보를  다 가져오는거 
	
	@Override
	public List<LprodVO> getAllLProd() {
		return dao.getAllLProd();
	}
	
	
	@Override
	public List<ProdVO> getAllProd(String prod_lgu) {
		return dao.getAllProd(prod_lgu);
	}

	@Override
	public List<ProdVO> tableView(String prod_id) {
		return dao.tableView(prod_id);
	}

}
