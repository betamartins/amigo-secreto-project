package com.betamartins.amigosecretoproject.model.participante.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroParticipantesDto(
        @NotNull @NotBlank String nome,
        @Email @NotBlank @NotNull String email
) {
}
