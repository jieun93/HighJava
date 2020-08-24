package kr.or.ddit.zip.vo;

public class ZipVO {
	private String ZIPCODE;
	private String SIDO;
	private String GUGUN;
	private String DONG;
	private String RI;
	private String BLDG;
	private String 	BUNJI;
	private int SEQ;
	
	
	public  ZipVO() {}


	public ZipVO(String zIPCODE, String sIDO, String gUGUN, String dONG, String rI, String bLDG, String bUNJI,
			int sEQ) {
		super();
		this.ZIPCODE = zIPCODE;
		this.SIDO = sIDO;
		this.GUGUN = gUGUN;
		this.DONG = dONG;
		this.RI = rI;
		this.BLDG = bLDG;
		this.BUNJI = bUNJI;
		this.SEQ = sEQ;
	}
	

	public String getZIPCODE() {
		return ZIPCODE;
	}


	public void setZIPCODE(String zIPCODE) {
		ZIPCODE = zIPCODE;
	}


	public String getSIDO() {
		return SIDO;
	}


	public void setSIDO(String sIDO) {
		SIDO = sIDO;
	}


	public String getGUGUN() {
		return GUGUN;
	}


	public void setGUGUN(String gUGUN) {
		GUGUN = gUGUN;
	}


	public String getDONG() {
		return DONG;
	}


	public void setDONG(String dONG) {
		DONG = dONG;
	}


	public String getRI() {
		return RI;
	}


	public void setRI(String rI) {
		RI = rI;
	}


	public String getBLDG() {
		return BLDG;
	}


	public void setBLDG(String bLDG) {
		BLDG = bLDG;
	}


	public String getBUNJI() {
		return BUNJI;
	}


	public void setBUNJI(String bUNJI) {
		BUNJI = bUNJI;
	}


	public int getSEQ() {
		return SEQ;
	}


	public void setSEQ(int sEQ) {
		SEQ = sEQ;
	}

	


	
}
