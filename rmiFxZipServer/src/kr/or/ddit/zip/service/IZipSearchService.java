package kr.or.ddit.zip.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.zip.vo.ZipVO;

public interface IZipSearchService extends Remote{
	/**
	 * 검색할 '동'값을 매개변수로 받아서 검색하여 결과를 List로 반환하는 메서드
	 * @param dong 검색할 동
	 * @return
	 */
	public List<ZipVO> getZipSearchDong(String dong) throws RemoteException;
	
	/**
	 * 검색할 '우편번호'값을 매개변수로 받아서 검색하여 결과를 List로 반환하는 메서드
	 * @param code 검색할 우편번호
	 * @return
	 */
	public List<ZipVO> getZipSearchCode(String code) throws RemoteException;
}
