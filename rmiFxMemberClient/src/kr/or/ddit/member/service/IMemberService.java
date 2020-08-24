package kr.or.ddit.member.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.member.vo.MemberVO;



/**
 * Service객체는 DAO에 작성된 메서드를 원하는 작업에 맞게 호출하여 결과를 받아오고,
 * 받아온 자료를 Controller 에게 보내주는 역할을 수행한다.
 * 
 * 보통 DAO의 메서드와 같은 구조로 되어있다. 
 * 
 * @author PC-20
 *
 */
public interface IMemberService extends Remote{

	
	/**
	 * MemberVO에 담겨진 자료를 DB에 insert하는 메서드
	 * @param memVO DB에 insert할 자료가 저장된 MemberVO객체
	 * @return DB작업 성공 : 1, 실패  : 0
	 */
	public int insertMember(MemberVO memVO) throws RemoteException;
	
	
	/**
	 * 회원ID를 매개변수로 받아서 해당 회원 정보를 삭제하는 메서드
	 * @param memId 삭제할 회원ID
	 * @return 작업 성공 : 1, 실패 : 0
	 */
	public int deleteMember(String memId) throws RemoteException;
	
	/**
	 * 하나의 MemberVO자료를 이용하여 회원 정보를 update 하는 메서드
	 * 
	 * @param memVO 수정할 정보가 저장된 MemberVO 객체
	 * @return 작업성공 : 1, 실패 :0;
	 */
	public int updateMember(MemberVO memVO) throws RemoteException;
	
	/**
	 * Map의 정보를 이용하여 회원 정보를 수정하는 메서드
	 * 
	 * @param paramMap 수정할 정보가 저당된 Map 객체
	 * @return
	 */
	public int updateMember(Map<String,String> paramMap) throws RemoteException;
	
	
	/**
	 * 회원 ID를 매개변수로 받아서  해당 회원의 인원수를 반환하는 메서드 
	 * @param memId 검색할 회원 ID
	 * @return 검색된 회원 수
	 */
	public int getMemberCount(String memId) throws RemoteException;
	 
	/**
	 * 전체 회원정보를 DB에서 가져와 각각의 장보는 MemberVO에 담고 , 이 MemberVO 객체를 List에 넣어서 반환하는 메서드 
	 * @return 전체 회원 정보(MemberVO 객체)가 저장된  List 객체  
	 */
	public List<MemberVO> getAllMember() throws RemoteException;
	
	/**
	 * 
	 * @param searchMap
	 * @return
	 */

	public List<MemberVO> getSearchMember(Map<String, String> searchMap) throws RemoteException;
	
	/**
	 * 전체 레코드수를 반환하는 메서드 
	 * @return 전체 레코드 수 
	 */
	public int getAllMemberCount() throws RemoteException;
	
	
	/**
	 * MAP 
	 * @param pageMap
	 * @return
	 */
	public List<MemberVO> getPagingMemberList(Map<String, Integer> pageMap) throws RemoteException;
	
	
}
