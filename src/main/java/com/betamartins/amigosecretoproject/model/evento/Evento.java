package com.betamartins.amigosecretoproject.model.evento;

import com.betamartins.amigosecretoproject.model.endereco.Endereco;
import com.betamartins.amigosecretoproject.model.evento.dto.CadastroEventoDto;
import com.betamartins.amigosecretoproject.model.participante.Participante;
import com.betamartins.amigosecretoproject.model.participante.dto.CadastroParticipantesDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Evento {

    private String title;
    private LocalDateTime data;
    private Endereco endereco;
    private List<Participante> participantes = new ArrayList<>();

    public Evento(CadastroEventoDto dto){
        this.title = dto.title();
        this.data = dto.data();
        this.endereco = new Endereco(dto.endereco());
    }

    public void adicionarParticipantes(List<CadastroParticipantesDto> participantesDtoList){
        participantesDtoList.forEach(
                (participanteDto) -> {
                    Participante participante = new Participante(participanteDto);
                    participantes.add(participante);
                }
        );
    }

}
