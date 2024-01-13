package com.betamartins.amigosecretoproject.service.sorteio;

import com.betamartins.amigosecretoproject.model.endereco.Endereco;
import com.betamartins.amigosecretoproject.model.evento.Evento;
import com.betamartins.amigosecretoproject.model.evento.dto.CadastroEventoDto;
import com.betamartins.amigosecretoproject.model.participante.Participante;
import com.betamartins.amigosecretoproject.service.email.EmailService;
import com.betamartins.amigosecretoproject.util.ResponseTextController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

@Service
public class SorteioService {

    @Autowired
    private EmailService emailService;

    public ResponseTextController sortear(CadastroEventoDto dto) {
        Evento evento = new Evento(dto);
        evento.adicionarParticipantes(dto.listaParticipantes());
        Collections.shuffle(evento.getParticipantes());
        int index = 1;
        for (Participante participante : evento.getParticipantes()) {
            if (index == evento.getParticipantes().size()) {
                participante.setAmigoSorteado(evento.getParticipantes().get(0).getName());

            } else {
                participante.setAmigoSorteado(evento.getParticipantes().get(index).getName());
            }
            index++;
        }
        this.enviarEmail(evento);
        return new ResponseTextController("O evento foi criado com sucesso e foi enviado os e-mails com o nome sorteado para cada participante.");
    }

    private void enviarEmail(Evento evento) {

        evento.getParticipantes().forEach(
            (participante) -> {
                var text = this.getMensagemEmail(evento.getTitle(), evento.getData(), evento.getEndereco().getEnderecoFormatado(), participante);
                this.emailService.sendEmail(participante.getEmail(), evento.getTitle(), text);
            }
        );

    }

    private String getMensagemEmail(String eventTitle, LocalDateTime data, String endereco, Participante participante){
        StringBuilder sb = new StringBuilder();
        sb.append("-----------------------------------------").append("\n");
        sb.append(eventTitle).append("\n\n");
        sb.append("Data do evento: ").append(data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))).append("\n");
        sb.append("Local do evento: ").append(endereco).append("\n\n");
        sb.append(participante.getName()).append(" sorteou como amigo secreto: ").append(participante.getAmigoSorteado()).append("\n\n");
        sb.append("-----------------------------------------").append("\n");
        return sb.toString();
    }

}
