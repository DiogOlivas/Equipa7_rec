package com.upt.lp.Equipa7.DTO;

import jakarta.validation.constraints.NotBlank;

public record LoginUserDTO (
	@NotBlank String username,
	@NotBlank String password
) {}
	

