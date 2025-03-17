package br.com.mct.gws.util;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // Ignora campos null nas respostas JSON das APIs
public class ApiResponse<T> implements ApiResponseInterface{

	private String status;
	private String message;
	private T data;
	
	public ApiResponse(String status, String message) {
		this.status = status;
		this.message = message;
	}
	public ApiResponse(String status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
