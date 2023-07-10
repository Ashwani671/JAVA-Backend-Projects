package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "password")
public class Voter extends BaseEntity{
	
	@Column(name="voter_name",length=20)
	private String voterName;
	@Column(name="city",length=30)
	private String city;
	@Column(length=30,unique = true)
	private String email;
	@Column(length=20, nullable = false)
	private String password;
	@Min(18)
	private Integer age;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Past
	@Column(name="date_of_birth",length=20)
	private LocalDate dob;
	private boolean votingStatus ;
		
	}
	
	


