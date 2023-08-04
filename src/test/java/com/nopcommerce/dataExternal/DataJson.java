package com.nopcommerce.dataExternal;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstances;

public class DataJson {
	public static DataJson get() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstances.PROJECT_PATH + "/src/test/resources/dataTest.json"), DataJson.class);
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	
	@JsonProperty("emailAddress")
	private String emailAddress;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("login")
	private Login login;
	static class Login {
		@JsonProperty("firstName")
		private String firstName;
		
		@JsonProperty("lastName")
		private String lastName;
	}
	
	
	
	public String getFirstName() {
		return login.firstName;
	}
	public void setFirstName(String firstName) {
		this.login.firstName = firstName;
	}
	public String getLastName() {
		return login.lastName;
	}
	public void setLastName(String lastName) {
		this.login.lastName = lastName;
	}
	public String getEmail() {
		return emailAddress;
	}
	public void setEmail(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
}
