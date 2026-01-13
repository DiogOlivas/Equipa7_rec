package com.upt.lp.Equipa7.DTO;

import java.util.List;
import com.upt.lp.Equipa7.entity.User;

public class CategoryDTO {
    private Long id;
    private User user;
    private String name;
    private String desc;
    private double budget;
    private List<Long> transactionIds;

    public CategoryDTO() {}

    public CategoryDTO(Long id, User user, String name, String desc, double budget, List<Long> transactionIds) {
        this.id = id;
        this.setUser(user);
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
    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public String getDescricao() {
        return desc;
    }

    public void setDescricao(String descricao) {
        this.desc = descricao;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public List<Long> getTransactions() {
        return transactionIds;
    }

    public void setGastos(List<Long> transactionIds) {
        this.transactionIds = transactionIds;
    }
}