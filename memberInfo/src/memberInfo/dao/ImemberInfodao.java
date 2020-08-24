package memberInfo.dao;

import java.util.List;

import memberInfo.vo.memberInfoVO;

public interface ImemberInfodao {
	
	// 검색 버튼을 누르면 정보가 다 나오는거
	public List <memberInfoVO> getAllmember();
	
	// 회원 수정
	public int  updateMember (memberInfoVO memVO);
	
	// 블랙리스트
	public int insertMember(memberInfoVO memVO);
	
	// 삭제
	public int deleteMember(String memId);
	
	// 테이블에 정보 쀼려주는거 
	public List <memberInfoVO> tableview(String mem_id);
	
	
	
}
