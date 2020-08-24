package prodFxTest.vo;

public class LprodVO {
	
	// 변수 선언하기
	private String LPROD_ID;
	private String LPROD_GU; 
	private String LPROD_NM;
	
	
	// 생성자 만들기
	public LprodVO() {}



	public LprodVO(String lPROD_ID, String lPROD_GU, String lPROD_NM) {
		super();
		this.LPROD_ID = lPROD_ID;
		this.LPROD_GU = lPROD_GU;
		this.LPROD_NM = lPROD_NM;
	}


	// getter setter  만들기 
	public String getLPROD_ID() {
		return LPROD_ID;
	}



	public void setLPROD_ID(String lPROD_ID) {
		LPROD_ID = lPROD_ID;
	}



	public String getLPROD_GU() {
		return LPROD_GU;
	}



	public void setLPROD_GU(String lPROD_GU) {
		LPROD_GU = lPROD_GU;
	}



	public String getLPROD_NM() {
		return LPROD_NM;
	}



	public void setLPROD_NM(String lPROD_NM) {
		LPROD_NM = lPROD_NM;
	};
	
	
	
	
	
}
	
	
