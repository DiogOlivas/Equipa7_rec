package com.upt.lp.Equipa7.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ChangePasswordDTO {
    @NotBlank
    private String oldPassword;
    @NotBlank
    private String newPassword;
    @NotNull
    private Long userId;

    public ChangePasswordDTO() {}
    public ChangePasswordDTO(String oldPassword, String newPassword, Long userId) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.userId = userId;
    }
    public String getOldPassword() { return oldPassword; }
    public void setOldPassword(String oldPassword) { this.oldPassword = oldPassword; }
    public String getNewPassword() { return newPassword; }
    public void setNewPassword(String newPassword) { this.newPassword = newPassword; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
