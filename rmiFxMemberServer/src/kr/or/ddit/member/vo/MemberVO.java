package kr.or.ddit.member.vo;

import java.io.Serializable;
import java.rmi.Remote;

/*
 *  VO ==> DB테이블에 있는 컬럼을 기준으로 데이터를 객체화한 클래스
 * 
 * DB테이블의 '컬럼'이 클래스의 '멤버변수'가 된다.
 * DB테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 수행한다.
 */
public class MemberVO implements Serializable{ 
	private String mem_id;
	private String mem_name;
	private String mem_tel;
	private String mem_addr;
	
	// 기본생성자 만들어 주는거 
	public MemberVO() {}
	

	/*알트 시프트 s*/
	public MemberVO(String mem_id, String mem_name, String mem_tel, String mem_addr) {
		super();
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_tel = mem_tel;
		this.mem_addr = mem_addr;
	}

	
	// 소스에서 getter setter


	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}

}
