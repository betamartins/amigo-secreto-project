package com.betamartins.amigosecretoproject.model.participante;

import com.betamartins.amigosecretoproject.model.participante.dto.CadastroParticipantesDto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "email")
@Getter
@ToString
public class Participante {

    private String name;
    private String email;
    @Setter
    private String amigoSorteado;

    public Participante(CadastroParticipantesDto dto){
        this.name = dto.nome();
        this.email = dto.email();
    }

}
