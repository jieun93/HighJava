package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.vo.MemberVO;



/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성해서 
 * Service에 전달하는 DAO의 interface
 * 
 * @author PC-20
 *
 */

public interface IMemberDao {
	
	
	/**
	 * MemberVO에 담겨진 자료를 DB에 insert하는 메서드
	 * @param memVO DB에 insert할 자료가 저장된 MemberVO객체
	 * @return DB작업 성공 : 1, 실패  : 0
	 */
	public int insertMember(MemberVO memVO);
	
	
	/**
	 * 회원ID를 매개변수로 받아서 해당 회원 정보를 삭제하는 메서드
	 * @param memId 삭제할 회원ID
	 * @return 작업 성공 : 1, 실패 : 0
	 */
	public int deleteMember(String memId);
	
	/**
	 * 하나의 MemberVO자료를 이용하여 회원 정보를 update 하는 메서드
	 * 
	 * @param memVO 수정할 정보가 저장된 MemberVO 객체
	 * @return 작업성공 : 1, 실패 :0;
	 */
	public int updateMember(MemberVO memVO);
	
	/**
	 * Map의 정보를 이용하여 회원 정보를 수정하는 메서드
	 * 
	 * @param paramMap 수정할 정보가 저당된 Map 객체
	 * @return
	 */
	public int updateMember(Map<String,String> paramMap);
	
	/**
	 * 회원 ID를 매개변수로 받아서  해당 회원의 인원수를 반환하는 메서드 
	 * @param memId 검색할 회원 ID
	 * @return 검색된 회원 수
	 */
	public int getMemberCount(String memId);
	 
	/**
	 * 전체 회원정보를 DB에서 가져와 각각의 장보는 MemberVO에 담고 , 이 MemberVO 객체를 List에 넣어서 반환하는 메서드 
	 * @return 전체 회원 정보(MemberVO 객체)가 저장된  List 객체  
	 */
	public List<MemberVO> getAllMember();
	
	/**
	 * 검색할 컬럼명과 검색할 단어가 저장된 Map을 매개변수로 해당 데이터를 검색하여 List로 반환하는 메서드 
	 * @param searchMap 검색할 컬럼명과 검색할 단어가 저장된 Map 객체
	 * @return 검색결과를 List에 담아서  반환한다.
	 */
	public List<MemberVO> getSearchMember(Map<String, String> searchMap);
	
	
}
