package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.vo.LprodVO;
import kr.or.ddit.prod.vo.ProdVO;

public interface ProdDao {
	
	
	// 데이터 베이스의 조건으로 메소드 만들기 
	/*
	select * from lprod; --왼쪽의 콤보박스용

	select * from prod where prod_lgu='P301'; --오른쪽 콤보박스용

	select * from prod where prod_id='P301000002'; --테이블 뷰용
	*/
	
	
	/*
	 * Lprod 테이블의 전체 내용을  list 에 담아 반환하는 메서드
	 * @return LprodVO객체가 저장된 List
	 * 
	 */
	public List <LprodVO>  getAllLProd();
	
	/*
	 * prodlgu 값을 매개변수로 받아서 해당 상품 분류에 해당하는 상품 목록을 list로 반환하는 메서드 
	 * @param prodlgu 검색할 상품 분류 코드 
	 * @return 검색된 상품 목록 LIST
	 */
	public List <ProdVO>  getAllProd(String prodlgu);
		
	/*
	 * prodId 값을 매개변수로 받아서 해당 상품 분류에 해당하는 상품 목록을 list로 반환하는 메서드 
	 * @param prodid 검색할 상품 분류 코드 
	 * @return 검색된 상품 목록 LIST
	 */
	public List <ProdVO>  tableView(String prodid);
	
}
