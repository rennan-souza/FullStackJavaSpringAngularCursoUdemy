Minhas anotações da criação da API de Clientes

Projeto do curso Full Stack Java Spring Boot e Angular 9

Montando a estrutura base do backend

1 - Criar o projeto com o nome clientes e adiconar as dependências no pom.xml
2 - Criar o pacote model e dentro dele colocar a classe Cliente e a classe ServicoPrestado
3 - Criar o pacote repository e dentro dele colocar a interface ClienteRepository e ServicoPrestadoRepository
4 - Criar o método prePersist no model de cliente para registrar a data de criação do cadastro
5 - Criar o pacote rest e dentro dele colocar a classe ClienteController
6 - Dentro da classe ClienteController colocar os métodos de salvar, acharPorId, deletar e atualizar
7 - Na classe Cliente do pacote model colocar as anotações do Java Validation e Hibernate Validator @NotEmpty e no cpf @NotNull @CPF
8 - Criar o pacote config e colocar a classe InternacionalizacaoConfig
9 - Criar no resources o messages.properties
10 - No pacote rest criar a classe ApplicationControllerAdvice
11 - Criar dentro do pacote rest o pacote exception e programar a classe ApiErrors


Liberado o CORS

1 - Dentro do pacote config criar a classe WebConfig
2 - Programar a liberação do CORS para todas as URL's


Login e Autenticação

1 - Criar dentro do pacote model a classe de Usuario
2 - Criar dentro do pacote repository a interface UsuarioRepository
3 - Dentro do pacote rest criar o UsuarioController
4 - Adcionar ao pom.xml as dependências do spring security, spring security oauth2 e jwt
5 - Dentro do pacote config adicinar a classe SecurityConfig
6 - Dentro do pacote config adicinar a classe ResourceServerConfig 
7 - Dentro do pacote config adicinar a classe AuthorizationServerConfig 
8 - Criar o pacote service com a classe UsuarioService
9 - Criar o pacote exception com a classe UsuarioCadastradoException



OBS:
Caso você esteja utilizando o spring versão 2.3.X ou superior, será necessário adicionar a dependência:

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

Além disso, deverá adicionar as seguintes configurações no arquivo application.properties:

server.error.include-message=always
server.error.include-binding-errors=always