package com.betamartins.amigosecretoproject.model.endereco;

import com.betamartins.amigosecretoproject.model.endereco.dto.DadosEndereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Endereco {

    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dadosEndereco){
        this.cep = dadosEndereco.cep();
        this.logradouro = dadosEndereco.logradouro();
        this.numero = dadosEndereco.numero();
        this.bairro = dadosEndereco.bairro();
        this.cidade = dadosEndereco.cidade();
        this.uf = dadosEndereco.uf();
    }

    public String getEnderecoFormatado(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getLogradouro()).append(", ")
                .append(this.getNumero()).append(" - ")
                .append(this.getBairro()).append(" - ")
                .append(this.getCidade()).append("/")
                .append(this.getUf());

        return sb.toString();
    }

}
