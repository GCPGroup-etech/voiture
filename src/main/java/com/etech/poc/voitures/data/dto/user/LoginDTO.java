package com.etech.poc.voitures.data.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author benja
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class LoginDTO {

	public LoginDTO(String token) {
		this.token = token;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
