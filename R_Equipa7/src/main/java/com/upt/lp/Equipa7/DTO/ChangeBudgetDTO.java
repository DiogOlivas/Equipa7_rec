package com.upt.lp.Equipa7.DTO;

import jakarta.validation.constraints.NotNull;

public class ChangeBudgetDTO {
    @NotNull
    private Double newBudget;
    @NotNull
    private Long userId;

    public ChangeBudgetDTO() {}
    public ChangeBudgetDTO(Double newBudget, Long userId) {
        this.newBudget = newBudget;
        this.userId = userId;
    }
    public Double getNewBudget() { return newBudget; }
    public void setNewBudget(Double newBudget) { this.newBudget = newBudget; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
