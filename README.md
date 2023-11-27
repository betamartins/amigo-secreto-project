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

