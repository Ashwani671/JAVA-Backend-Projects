package com.app.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

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
@ToString
@Table(name="course")
public class Course extends BaseEntity{
	
	/*
	 * *•	ID (unique identifier for each Course, auto generated, starts from 1)
•	Name
•	Category (Enum, example: JAVA-BEGINER, JAVA-ADVANCED)
•	Start Date
•	End Date
•	Fee
•	Update Date Time


	 */
	
	@Column(name="course_name",length=20)
	@NotBlank(message="name cannot be blank")
	private String courseName;
	@Enumerated(EnumType.STRING)
	private Category coursecategory;
	@NotNull
	private LocalDate startDate;
	@NotNull
	private LocalDate endDate;
	@NotNull
	private double fees;
	//@NotBlank(message = "enddate cant be before startdate")
	private LocalDateTime updateDateTime;
	@Column(name="email",unique = true)
	private String email;
	@Column(length=20,nullable = false)
	private String password;
	
	
	

}
