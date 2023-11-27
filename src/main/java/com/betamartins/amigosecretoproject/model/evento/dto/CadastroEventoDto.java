package com.betamartins.amigosecretoproject.model.evento.dto;

import com.betamartins.amigosecretoproject.model.endereco.dto.DadosEndereco;
import com.betamartins.amigosecretoproject.model.participante.dto.CadastroParticipantesDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record CadastroEventoDto(
        @NotNull @NotBlank String title,
        @Future @NotNull LocalDateTime data,
        @NotNull @Valid DadosEndereco endereco,
        @NotEmpty List<@Valid CadastroParticipantesDto> listaParticipantes
) {
}
