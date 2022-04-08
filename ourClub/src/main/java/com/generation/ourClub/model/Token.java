package com.generation.ourClub.model;

public class Token {
	private String accessToken;

	public Token(String accessToken) {
		
		this.accessToken = accessToken;
	}//constructor

	public String getAccessToken() {
		return accessToken;
	}//getAccesToken

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}//seetAccesToken 


}
