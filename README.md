## Podcast Web Service

Projeto de uma API RESTFul.

Stack do projeto:
  - Escrito em Java 8;
  - Spring Boot com suas facilidades;
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

Execute o comando `docker-compose up` no diretório raiz do projeto. <br/><br/>Durante a inicialização dos containers, será executao um [script]() para criar o banco de dados, além de criar e povoar as tabelas necessárias para o funcionamento da aplicação.   

#### Endpoints

- Buscar podcasts: 
  - `http://localhost:8089/podcasts/`
  - `http://localhost:8089/podcasts/1`
  - `http://localhost:8089/podcasts?nome=Nerdcast`

- Buscar episodios:
  - `http://localhost:8089/episodios/1`
  - `http://localhost:8089/episodios/`
  - `http://localhost:8089/episodios?tema=Quadrinhos`




