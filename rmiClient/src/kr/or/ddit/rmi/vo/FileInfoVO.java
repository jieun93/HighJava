package kr.or.ddit.rmi.vo;

import java.io.Serializable;

public class FileInfoVO  implements Serializable{
	
	private static final long serialVersionUID = 4874967345102088179L;
	
	private String fileName;	// 파일 이름
	private byte[] fileData ;	// 파일 내용
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	
	
}
