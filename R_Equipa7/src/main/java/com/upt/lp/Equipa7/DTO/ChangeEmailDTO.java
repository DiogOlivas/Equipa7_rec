package com.upt.lp.Equipa7.DTO;

import jakarta.validation.constraints.NotBlank;

public class ChangeEmailDTO {
    @NotBlank
    private String newEmail;
    private Long userId;

    public ChangeEmailDTO() {}

    public ChangeEmailDTO(String newEmail, Long userId) {
        this.newEmail = newEmail;
        this.userId = userId;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
