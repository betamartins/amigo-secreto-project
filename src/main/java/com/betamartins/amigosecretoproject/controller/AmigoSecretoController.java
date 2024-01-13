package com.betamartins.amigosecretoproject.controller;

import com.betamartins.amigosecretoproject.model.evento.dto.CadastroEventoDto;
import com.betamartins.amigosecretoproject.service.sorteio.SorteioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/amigo-secreto")
public class AmigoSecretoController {

    @Autowired
    private SorteioService sorteioService;

    @PostMapping
    public ResponseEntity<?> sortearAmigoSecreto(@RequestBody @Valid CadastroEventoDto dto){

        var response = sorteioService.sortear(dto);

        return ResponseEntity.ok(response);
    }

}
