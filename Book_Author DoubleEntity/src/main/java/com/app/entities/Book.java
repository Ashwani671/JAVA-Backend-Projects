package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name="book")
public class Book extends BaseEntity {
	
	@Column(name="name",length=20)
	private String name;
	@Column(length=20,nullable = false)
	private double price;
	@Column(nullable = false,length=20)
	private int quantity;
	@Enumerated(EnumType.STRING)
	private Genre type; 
	
	@ManyToOne
	private Author author;

}
