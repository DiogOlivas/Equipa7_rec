package com.upt.lp.Equipa7.DTO;

import jakarta.validation.constraints.NotBlank;

public record ChangePasswordDTO (
		@NotBlank String oldPassword,
		@NotBlank String newPassword
		) {}


