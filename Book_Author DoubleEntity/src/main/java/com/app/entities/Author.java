package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="author")
@JsonIgnoreType
public class Author extends BaseEntity{
	@Column(name="auth_name",length=20)
	private String authName;
	@Column(length=20,nullable = false)
	private int age;
	@Column(name="address",length=20)
	private String address;
	@Column(unique = true, length=30)
	private String email;
	
	@OneToMany(mappedBy = "author",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	 private List<Book> bookList=new ArrayList<>();
	
	
	

}
