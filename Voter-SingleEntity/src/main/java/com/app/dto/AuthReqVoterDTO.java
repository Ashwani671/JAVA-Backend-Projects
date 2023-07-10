package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthReqVoterDTO {
	@NotBlank(message = "Email can't be blank")
	@Email(message = "Invalid format")
	private String email;
	@NotBlank(message = "password can't be blank")
	private String password;
	
	

}
