# API para sorteio de amigo secreto 

Projeto desenvolvido para realizar sorteio de amigo secreto com base em uma 
lista de participantes (nome/email). Após ser feito o sorteio a API envia um e-mail para cada participante
com o nome sorteado.

## Configurando o projeto
Para executar o projeto a única configuração. necessária são as variáveis de ambiente abaixo.  
_PS:Estas váriaveis de ambiente podem ser inseridas em tempo de execução do projeto._

### Variaveis de ambiente
    MAIL_HOST = Host SMTP do seu provedor de email. Ex: smtp.gmail.com
    MAIL_PORT = Porta para envio do seu provedor de email. Ex: 465
    MAIL_USER = E-mail que será utilizado para envio.
    MAIL_PASSWORD = Senha do e-mail utilizado para o envio.

## Utilizando a API
End-point para sorteio: **POST** **/api/amigo-secreto**  
### Body
```
{
    "title": "Amigo secreto da familia",
    "data": "2023-12-24T20:00",
    "endereco": {
        "logradouro": "rua",
        "bairro": "bairro",
        "cep": "12345678",
        "cidade": "cidade",
        "uf": "UF",
        "numero": "1"
    },
    "listaParticipantes": [
        {
            "nome": "Participante 1",
            "email": "participante1@email.com"
        },
        {
            "nome": "Participante 2",
            "email": "participante2@email.com"
        }
    ]
}
```
    
