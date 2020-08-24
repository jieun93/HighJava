package kr.or.ddit.student.service;

import java.util.List;

import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoImpl;
import kr.or.ddit.student.vo.StudentVo;

public class StudentServiceImpl implements StudentService {
	private StudentDao dao;
	
	private static StudentServiceImpl service;
	
	private StudentServiceImpl() {
		dao = StudentDaoImpl.getInstance();
	}
	
	public static StudentServiceImpl getInstance() {
		if(service == null) service = new StudentServiceImpl();
		return service;
	}
	
	@Override
	public int insertScore(StudentDao studentVo) {
		return dao.insertScore(studentVo);
	}


	@Override
	public int getNameCount(String sTD_NAME) {
		return dao.getNameCount(sTD_NAME);
	}

	@Override
	public List<StudentVo> getAllStudent() {
		return dao.getAllStudent();
	}

}
