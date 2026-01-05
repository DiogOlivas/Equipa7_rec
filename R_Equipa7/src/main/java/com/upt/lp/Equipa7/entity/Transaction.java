package com.upt.lp.Equipa7.entity;
import java.time.LocalDate;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate date;

	private String description;
	
	private double value;
	
	private String paymentMethod;

	@ManyToOne private User user;

	@ManyToOne private Category category;

	//
	
	public Transaction () {}

	public Transaction(Long id, LocalDate date, Category category, String description, double value,
				String paymentMethod) {
			super();
			this.id = id;
			this.date = date;
			this.category = category;
			this.description = description;
			this.value = value;
			this.paymentMethod = paymentMethod;
			this.user = user;
			
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
}

