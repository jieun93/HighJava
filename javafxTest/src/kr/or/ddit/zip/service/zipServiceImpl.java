package kr.or.ddit.zip.service;

import java.util.List;

import kr.or.ddit.zip.dao.IzipDao;
import kr.or.ddit.zip.dao.zipDaoImpl;
import kr.or.ddit.zip.vo.ZipVO;

public class zipServiceImpl implements IzipService {
	private IzipDao dao;
	
	private static zipServiceImpl service;
	
	// 생성자 만들기
	private zipServiceImpl() {
		dao = zipDaoImpl.getInstance();	
	}
	
	public static zipServiceImpl getInstance() {
		if(service == null) service = new zipServiceImpl();
		return service;
		
	}

	@Override
	public List<ZipVO> getZipSearchDong(String dong) {
		return  dao.getZipSearchDong(dong);
	}

	@Override
	public List<ZipVO> getZipSearchCode(String code) {
		return dao.getZipSearchCode(code);
	}
	

	
	
	
	
}
