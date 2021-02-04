Frontend do curso FullStack Java, Spring e Angular 9

1 - Instalar o cli do angular com o comando: npm i -g @angular/cli@9.1.1
2 - Criar o projeto com o comando: ng new clientes-app 


OBS: 
Para criar um component bastar executar o comando: ng g c <nome-do-component>
Mas como não criamos o projeto em sua versão --minimal ele vai criar alguns arquivos de testes e se você não quiser os arquivos de teste basta executar
o comando para criar component assim: ng g c <nome-do-component> --skipTests=true


OBS: 
Para criar um module basta executar o comando: ng g m <nome-do-module>


Adicionando o template do projeto

1 - No arquivo style.css adicionar o css global da aplicação
2 - No arquivo index.html adicionar o CDN do Fontawesome
3 - Instalar o jQuery com o comando: npm install --save jquery
4 - Intalar o Framework Bootstrap 4.3.1 com o comando: npm install --save bootstrap@4.3.1
5 - No arquivo angular.json colocar as referências do Bootstrap e jQuery


Navbar

1 - Criar o module template com o comando: ng g m template
2 - Criar o component navbar dentro do diretorio template com o comando: ng g c template/navbar --skipTests=true
3 - Fazer o exports do Navbar em template.module
4 - Importar o template module no app.module


Sidebar

1 - Criar o componente sidebar dentro diretorio template com o comando: ng g c template/sidebar --skipTests=true
2 - Fazer o exports do sidebar em template.module
3 - Em app.module importar o AfterViewInit para o sistema ler o script do sidebar toggle após toda a aplicação ser carregada


Conteudo

1 - Criar o component home no diretorio app com o comando: ng g c home
2 - Criar o modulo de cliente com o comando: ng g m clientes --routing
3 - Adicionar a importação do module cliente em app.module.ts e em clientes.module fazer o seu exports
4 - Gerar o component de clientes com o comando: ng g c clientes/clientes-form --skipTests=true
5 - Definir rota para o component home em app-routing.module.ts


Trabalhando com Links

1 - Certifique-se que em app.component.html tenha o router-outlet
2 - Em app-routing.module.ts crie a rota para a home
3 - Em clientes-routing.module.ts crie a rota para clientes form
4 - Em template.module.ts adicionar a importação de RouterModule
5 - Adicione os routerLinks nos seus devidos links do sidebar


Form de cadastro de clientes

1 - Dentro do diretório do module cliente criar o arquivo cliente.ts e nele colocar a classe Cliente
2 - Importar a classe cliente no clientes-form.component.ts
3 - Criar o form em clientes-form.component.html
4 - Em clientes.module.ts importar o modulo de formulário do angular
5 - Preparar o form para submit e programar o event submit do form


Serviços

1 - Criar o service de clientes com o comando: ng g s clientes
2 - Em app.module.ts importar o service de clientes e adicionalo em providers
3 - Em clientes-form.component.ts importar o clientes.service
4 - Em app.module.ts importar o modulo http do angular
5 - Importar também o HttpClient do angular no cliente.service.ts
6 - Programar em clientes-form.component.ts as ações de salvar no db


Listagem de clientes

1 - Criar o componente com o comando: ng g c clientes/clientesLista
2 - Adiconar ao exports do clientes.module.ts o component cliente lista
3 - Progrmar em clientes-lista.component.ts e clientes.service
4 - Programar o front da listagem em clientes-list-components.html

Alterar cliente

1 - Crie a rota clientes-form/:id 
2 - Adicione o ActivatedRoute em clientes-form.components.ts
3 - Em clientes-form.components.ts programar no ngOnInit a verificação de parametros na url



Cadastro e consulta de serviços prestados

1 - Criar o modulo com o comando: ng g m --routing servicoPrestado
2 - Criar o componente com o comando: ng g c --skipTests=true servico-prestado/servicoPrestadoForm
3 - Criar o componente com o comando: ng g c --skipTests=true servico-prestado/servicoPrestadoLista
4 - Criar o exports dos components criado dentro do module de servico prestado
5 - Dentro de servico prestado module colocar os imports de form e router
6 - Dentro de app.module adicionar o novo module de serviço prestado
7 - Criar o service com o comando ng g s servicoPrestado --skipTests=true
8 - Adicionar o service de servio-prestado em providers de app.module



Login 

1 - Gerar o component de login: ng g c login --skipTests=true
2 - Em app.module.ts importar o form do angular

OBS: Para separar o login do template crie o componente: ng g c layout --skipTests=true
após criar o novo component layout, recortar tudo que estiver em app.component.html para o layout.component.html
e manter em app.component.html e em layout.component.html o <router-outler></router-outler>
mover de todo o jquery de app.component.ts para o layout.component.ts e no component de rotas do app definir a rota filha 
children em LayoutComponent. Agora nos outros components de rotas, todas as rodas deverão ser filhas de LayoutComponent e atenção na refatoração das urls's

3 - Gerar o component de serviço para o login com o comando: ng g s auth --skipTests=true
4 - Registar o AuthSerivice em providers do app.module.ts
5 - Criar a classe de usuarios dentro do modulo de login


Autenticação

1 - Em environments colocar o clientId e o clientSecret que foi definido no backend da API 
2 - Em environments adicionar o obterTokenUrl que a requisição feita para o oauth para gerar o token, 
por exemplo em localhost no postman: http://localhost:8080/oauth/token
3 - Em auth.service.ts adicionar o tokenUrl que é a concatenação da url base da api mais a requisição do oauth
4 - Em auth.service.ts fazer o método tentarLogar() com os parametros de requisição do token JWT
5 - Em login.component.ts fazer o método onSubmit()


Salvando o token JWT em Local Storage

1 - Em login.component.ts no método onSubmit programar os novos recursos para salvar o token em local storage
2 - Criar o interceptor para enviar o token nas requisições http com o comando: ng g interceptor token --skipTests=true
3 - Programar em token.intercptor.ts para pegar o token de local storage e enviar nas requisições
4 - Em app.module.ts adicionar em providers o interceptor dessa forma: 
{
  provide: HTTP_INTERCEPTORS,
  useClass: TokenInterceptor,
  multi: true
}



Protegendo as URL's do sistema com o guard

1 - Gerar o guard com o nome auth e com o comando: ng g guard auth --skipTests=true
OBS: Ao fazer o comando ng g guard auth --skipTests=true ele vai ter perguntar o tipo de guard, selecione CanActivate
2 - Programar em auth.guard.ts
3 - Programar em auth.service.ts o método isAuthenticated
4 - Em app-routing.module.ts implementar o guard
5 - Instalar a biblioteca do angular-jwt com o comando: npm install --save @auth0/angular-jwt
6 - Trabalhar com a biblioteca auth do angular em auth.service.ts



Detalhes finais

1 - Ajustando rotas e adicionando o guard
2 - Em auth.service.ts criar o método de encerrar a sessão
3 - Em auth.service.ts criar o método para pegar os dados do susuario autenticado
4 - Em sidebar.component.ts pegar o nome do usuario logado para enviar ao front