package mymember.vo;

public class Com_QuestionVO {
	private String COM_QUE_NO;
	private String COM_QUE_TITLE;
	private String COM_QUE_WRITEID;
	private String COM_QUE_WRITEDAY;
	private String	CAT_A_NO;
	private String	COM_QUE_CONTENT;
	
	public Com_QuestionVO() {}

	public Com_QuestionVO(String cOM_QUE_NO, String cOM_QUE_TITLE, String cOM_QUE_WRITEID, String cOM_QUE_WRITEDAY,
			String cAT_A_NO, String cOM_QUE_CONTENT) {
		super();
		this.COM_QUE_NO = cOM_QUE_NO;
		this.COM_QUE_TITLE = cOM_QUE_TITLE;
		this.COM_QUE_WRITEID = cOM_QUE_WRITEID;
		this.COM_QUE_WRITEDAY = cOM_QUE_WRITEDAY;
		this.CAT_A_NO = cAT_A_NO;
		this.COM_QUE_CONTENT = cOM_QUE_CONTENT;
	}

	public String getCOM_QUE_NO() {
		return COM_QUE_NO;
	}

	public void setCOM_QUE_NO(String cOM_QUE_NO) {
		COM_QUE_NO = cOM_QUE_NO;
	}

	public String getCOM_QUE_TITLE() {
		return COM_QUE_TITLE;
	}

	public void setCOM_QUE_TITLE(String cOM_QUE_TITLE) {
		COM_QUE_TITLE = cOM_QUE_TITLE;
	}

	public String getCOM_QUE_WRITEID() {
		return COM_QUE_WRITEID;
	}

	public void setCOM_QUE_WRITEID(String cOM_QUE_WRITEID) {
		COM_QUE_WRITEID = cOM_QUE_WRITEID;
	}

	public String getCOM_QUE_WRITEDAY() {
		return COM_QUE_WRITEDAY;
	}

	public void setCOM_QUE_WRITEDAY(String cOM_QUE_WRITEDAY) {
		COM_QUE_WRITEDAY = cOM_QUE_WRITEDAY;
	}

	public String getCAT_A_NO() {
		return CAT_A_NO;
	}

	public void setCAT_A_NO(String cAT_A_NO) {
		CAT_A_NO = cAT_A_NO;
	}

	public String getCOM_QUE_CONTENT() {
		return COM_QUE_CONTENT;
	}

	public void setCOM_QUE_CONTENT(String cOM_QUE_CONTENT) {
		COM_QUE_CONTENT = cOM_QUE_CONTENT;
	}
	
	
	
}
