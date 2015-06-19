package org.lee.messenger.model;

public class ErrorMessage {
	private String errorMessage;
	private int errorCode;
	private String doucumentation;
	
	public ErrorMessage(){
		
	}
	public ErrorMessage(String errorMessage, int errorCode,
			String doucumentation) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.doucumentation = doucumentation;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDoucumentation() {
		return doucumentation;
	}
	public void setDoucumentation(String doucumentation) {
		this.doucumentation = doucumentation;
	}
	
	
}
