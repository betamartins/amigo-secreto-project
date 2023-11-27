package com.betamartins.amigosecretoproject.model.endereco.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank @NotNull @Pattern(regexp = "\\d{8}") String cep,
        @NotBlank @NotNull String logradouro,
        @NotBlank @NotNull String numero,
        @NotBlank @NotNull String bairro,
        @NotBlank @NotNull String cidade,
        @NotBlank @NotNull String uf
) {
}
