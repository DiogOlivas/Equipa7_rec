package com.upt.lp.Equipa7.DTO;

import java.util.List;

public class CategoryDTO {
    private Long id;
    private Long userId;
    private String name;
    private String desc;
    private double budget;
    private List<Long> transactionIds;

    public CategoryDTO() {}

    public CategoryDTO(Long id, Long userId, String name, String desc, double budget, List<Long> transactionIds) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.desc = desc;
        this.budget = budget;
        this.transactionIds = transactionIds;
    }

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getUserId() { 
    	return userId; 
   }
    
    public void setUserId(Long userId) { 
    	this.userId = userId; 
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public List<Long> getTransactionIds() {
        return transactionIds;
    }

    public void setTransactionIds(List<Long> transactionIds) {
        this.transactionIds = transactionIds;
    }

    public void setGastos(List<Long> transactionIds) {
        this.transactionIds = transactionIds;
    }
}