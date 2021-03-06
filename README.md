## Podcast Web Service de demonstração

Projeto de demonstração de uma API RESTFul.

Stack do projeto:
  - Escrito em Java 8;
  - Spring Boot com suas facilidades;
  - Interceptação de exceções com @ControllerAdvice
  - Lombok para evitar o boilerplate do java;
  - Framework MyBatis para criação de consultas customizadas e persistência os dados;
  - Banco de dados PostgreSQL;
  - Testes unitários com JUnit 5 e Mockito;
  - Testes server-side com MockMVC;
  - Conteinerização de aplicação com Docker;
  - Orquestração de containers com Docker Compose. 

#### Visão Geral

A aplicação tem como objetivo disponibilizar endpoints para consulta de informações sobre podcasts, seus integrantes e episódios. 

#### Inicialização da aplicação e sua base de dados

Execute o comando `docker-compose up` no diretório raiz do projeto. <br/><br/>Durante a inicialização dos containers, um [script](https://github.com/edivaldoramos/podcast-ws/blob/master/scripts/init.sql) será executado, efetuando assim, a criação do banco de dados e suas tabelas, bem como o povoamento das tabelas com dados necessários para o funcionamento da aplicação.  

#### Endpoints de teste da API

- Buscar podcasts: 
  - `http://localhost:8089/podcasts/`
  - `http://localhost:8089/podcasts/1`
  - `http://localhost:8089/podcasts?nome=Nerdcast`

- Buscar episodios:
  - `http://localhost:8089/episodios/1`
  - `http://localhost:8089/episodios/`
  - `http://localhost:8089/episodios?tema=Quadrinhos`

#### Próximos passos

Aumentar cobertura de testes unitários
