package com.upt.lp.Equipa7.entity;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate date;
	
	private Category category;
	
	private String description;
	
	private int value;
	
	private String paymentMethod;
	
	public Transaction () {}

	public Transaction(Long id, LocalDate date, Category category, String description, int value,
				String paymentMethod) {
			super();
			this.id = id;
			this.date = date;
			this.category = category;
			this.description = description;
			this.value = value;
			this.paymentMethod = paymentMethod;
		}

	////Getters and setters///////////
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
}
