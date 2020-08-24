package kr.or.ddit.vo;

import java.io.Serializable;

public class Com_AnswerVO implements Serializable{
	private String COM_ANS_NO;
	private String COM_ANS_TITLE;
	private String COM_ANS_WRITEID;
	private String COM_ANS_WRITEDAY;
	private String COM_ANS_CONTENT;
	
	
	public Com_AnswerVO() {}


	public Com_AnswerVO(String cOM_ANS_NO, String cOM_ANS_TITLE, String cOM_ANS_WRITEID, String cOM_ANS_WRITEDAY,
			String cOM_ANS_CONTENT) {
		super();
		this.COM_ANS_NO = cOM_ANS_NO;
		this.COM_ANS_TITLE = cOM_ANS_TITLE;
		this.COM_ANS_WRITEID = cOM_ANS_WRITEID;
		this.COM_ANS_WRITEDAY = cOM_ANS_WRITEDAY;
		this.COM_ANS_CONTENT = cOM_ANS_CONTENT;
	}


	public String getCOM_ANS_NO() {
		return COM_ANS_NO;
	}


	public void setCOM_ANS_NO(String cOM_ANS_NO) {
		COM_ANS_NO = cOM_ANS_NO;
	}


	public String getCOM_ANS_TITLE() {
		return COM_ANS_TITLE;
	}


	public void setCOM_ANS_TITLE(String cOM_ANS_TITLE) {
		COM_ANS_TITLE = cOM_ANS_TITLE;
	}


	public String getCOM_ANS_WRITEID() {
		return COM_ANS_WRITEID;
	}


	public void setCOM_ANS_WRITEID(String cOM_ANS_WRITEID) {
		COM_ANS_WRITEID = cOM_ANS_WRITEID;
	}


	public String getCOM_ANS_WRITEDAY() {
		return COM_ANS_WRITEDAY;
	}


	public void setCOM_ANS_WRITEDAY(String cOM_ANS_WRITEDAY) {
		COM_ANS_WRITEDAY = cOM_ANS_WRITEDAY;
	}


	public String getCOM_ANS_CONTENT() {
		return COM_ANS_CONTENT;
	}


	public void setCOM_ANS_CONTENT(String cOM_ANS_CONTENT) {
		COM_ANS_CONTENT = cOM_ANS_CONTENT;
	}
	
	
	
	
}
