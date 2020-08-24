package kr.or.ddit.zip.dao;

import java.util.List;

import kr.or.ddit.zip.vo.ZipVO;

public interface IzipDao {

	/**
	 * 검색할 ' 동 ' 값을 매개변수로 받아서 검색하여  결과를 list로 반환하는 메서드
	 * @param dong
	 * @return
	 */
	
	
	// 콤보값 가져오는거 
	public List<ZipVO> getZipSearchDong(String dong);
	
	/**
	 * 검색할 '우편번호'값을 매개변수로 받아서 검색하여 결과를 list로 반환하는 메서드 
	 * @param code
	 * @return
	 */
	public List<ZipVO> getZipSearchCode (String  code);
}
