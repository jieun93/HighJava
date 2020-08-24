package prodFxTest.vo;

public class prodVO {
	
	// 변수 선언 DB에  있는 거 
	private String  PROD_ID;
	private String PROD_NAME;
	private String PROD_LGU;
	private String PROD_BUYER;
	private String	PROD_COST;
	private String	PROD_PRICE;
	private String 	PROD_SALE;
	
	
	// 기본생성자 만들기
	public prodVO() {}


	public prodVO(String pROD_ID, String pROD_NAME, String pROD_LGU, String pROD_BUYER, String pROD_COST,
			String pROD_PRICE, String pROD_SALE) {
		super();
		this.PROD_ID = pROD_ID;
		this.PROD_NAME = pROD_NAME;
		this.PROD_LGU = pROD_LGU;
		this.PROD_BUYER = pROD_BUYER;
		this.PROD_COST = pROD_COST;
		this.PROD_PRICE = pROD_PRICE;
		this.PROD_SALE = pROD_SALE;
	}


	// getter setter 만들기
	public String getPROD_ID() {
		return PROD_ID;
	}


	public void setPROD_ID(String pROD_ID) {
		PROD_ID = pROD_ID;
	}


	public String getPROD_NAME() {
		return PROD_NAME;
	}


	public void setPROD_NAME(String pROD_NAME) {
		PROD_NAME = pROD_NAME;
	}


	public String getPROD_LGU() {
		return PROD_LGU;
	}


	public void setPROD_LGU(String pROD_LGU) {
		PROD_LGU = pROD_LGU;
	}


	public String getPROD_BUYER() {
		return PROD_BUYER;
	}


	public void setPROD_BUYER(String pROD_BUYER) {
		PROD_BUYER = pROD_BUYER;
	}


	public String getPROD_COST() {
		return PROD_COST;
	}


	public void setPROD_COST(String pROD_COST) {
		PROD_COST = pROD_COST;
	}


	public String getPROD_PRICE() {
		return PROD_PRICE;
	}


	public void setPROD_PRICE(String pROD_PRICE) {
		PROD_PRICE = pROD_PRICE;
	}


	public String getPROD_SALE() {
		return PROD_SALE;
	}


	public void setPROD_SALE(String pROD_SALE) {
		PROD_SALE = pROD_SALE;
	}



	
	
	
	
}
