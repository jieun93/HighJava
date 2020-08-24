package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.vo.LprodVO;
import kr.or.ddit.prod.vo.ProdVO;

public interface ProdService {


	// 데이터 베이스의 조건으로 메소드 만들기 
	/*
	select * from lprod; --왼쪽의 콤보박스용

	select * from prod where prod_lgu='P301'; --오른쪽 콤보박스용

	select * from prod where prod_id='P301000002'; --테이블 뷰용
	*/

	public List <LprodVO>  getAllLProd();

	public List <ProdVO>  getAllProd(String prodlgu);
		
	public List <ProdVO>  tableView(String prodid);	
	
}
