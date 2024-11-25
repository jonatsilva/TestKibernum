package com.test.book.entity;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = -657207681248892144L;

	@Id
	@GeneratedValue
	@Hidden
	@Column(name = "ID", unique = true, length = Integer.MAX_VALUE)
	private Long id;
	@NotNull
	@Size(min = 0, max = 80)
	@Column(name = "NAME")
	private String name;
	@Size(min = 0, max = 80)
	@Column(name = "SURNAME")
	private String surname;
	@NotNull
	@Size(min = 0, max = 60)
	@Column(name = "MAIL", unique = true)
	private String mail;
	@NotNull
	@Column(name = "RUN", unique = true)
	private int run;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getRun() {
		return run;
	}

	public void setRun(int run) {
		this.run = run;
	}

}
