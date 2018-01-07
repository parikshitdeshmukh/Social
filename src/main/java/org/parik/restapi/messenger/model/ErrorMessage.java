package org.parik.restapi.messenger.model;

public class ErrorMessage {

	private String messaage;
	private int errorCode;
	private String documentation;
	
	public ErrorMessage() {
		
	}
		
	public ErrorMessage(String messaage, int errorCode, String documentation) {
		super();
		this.messaage = messaage;
		this.errorCode = errorCode;
		this.documentation = documentation;
	}
	
	public String getMessaage() {
		return messaage;
	}
	public void setMessaage(String messaage) {
		this.messaage = messaage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
	
	
	
}
