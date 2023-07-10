package com.app.dto;

import java.time.LocalDate;

import com.app.entities.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRespDTO {
	 /*	ID (unique identifier for each Course, auto generated, starts from 1)
•	Name
•	Category (Enum, example: JAVA-BEGINER, JAVA-ADVANCED)
•	Start Date
•	End Date
•	Fee
•	Update Date Time
*/
	private String courseName;
	private Category coursecategory;
	private LocalDate startDate;
	private LocalDate endDate;
	private double fees;
}
