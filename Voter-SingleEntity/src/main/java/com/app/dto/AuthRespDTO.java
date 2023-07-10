package com.app.dto;

import java.time.LocalDate;

import com.app.entities.Gender;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRespDTO {
	private String voterName;
	private String city;
	private Integer age;
	private Gender gender;
	private LocalDate dob;
	private boolean  votingStatus ;
		
	}
	
	
	
	
	
	


