package Mymember.vo;

public class InterestVO {
	private String int_no;
	private String mem_id;
	private String a_art_no;
	
	public InterestVO() {}

	public InterestVO(String int_no, String mem_id, String a_art_no) {
		super();
		this.int_no = int_no;
		this.mem_id = mem_id;
		this.a_art_no = a_art_no;
	}

	public String getInt_no() {
		return int_no;
	}

	public void setInt_no(String int_no) {
		this.int_no = int_no;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getA_art_no() {
		return a_art_no;
	}

	public void setA_art_no(String a_art_no) {
		this.a_art_no = a_art_no;
	}
	
	
}
