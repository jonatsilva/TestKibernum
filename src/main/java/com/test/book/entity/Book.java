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
@Table(name = "books")
public class Book implements Serializable {

	private static final long serialVersionUID = -1423171328352980364L;

	@Id
	@Hidden
	@GeneratedValue
	@Column(name = "ID", unique = true, length = Integer.MAX_VALUE)
	private Long id;
	@NotNull
	@Size(min = 0, max = 60)
	@Column(name = "TITLE")
	private String title;
	@NotNull
	@Size(min = 0, max = 100)
	@Column(name = "AUTHOR")
	private String author;
	@NotNull
	@Size(min = 0, max = 30)
	@Column(name = "SKU", unique = true)
	private String sku;
	@NotNull
	@Column(name = "PRICE")
	private int price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
