package prodFxTest.dao;

import java.util.List;

import prodFxTest.vo.LprodVO;
import prodFxTest.vo.prodVO;

public interface prodFxTestDao {

	//  Lprod   콤보박스에서 선택하면 lprod 리스트를 보여주는 
	public List <LprodVO> getAllLprod();
	
	// lprod를 선택하면 선택된 prod의 정보를 가져오는거  
	// lprod_gu 랑 prod_lgu가 같은거 
	public List <prodVO> tableView(String prod_id);
	
	
	//  prod의 리스트를 하나 클릭하면 선택된 목록만 화면전환되어 나오는거 
	public  List <prodVO> getSelectProd(String prod_lgu);
	
}
