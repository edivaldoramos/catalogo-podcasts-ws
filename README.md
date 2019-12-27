## Catalogo Podcast Web Service

Projeto em construção de uma API RESTFul.

Stack
  - Escrito em Java 8 usando as facilidades do Spring Boot;
  - Lombok na classes java para evitar boilerplate;
  - Framework MyBatis para criar consultas customizadas e persistir os dados;
  - Banco da dados PostgreSQL.

#### Visão Geral

A aplicaçao tem como objetivo disponibilizar endpoints para consulta de informacoes sobre podcasts, seus integrantes e episódios.

#### Instruções

Para criar e povoar as tabelas com informações necessárias para a demonstração do projeto, execute esses metódos de testes [aqui](https://github.com/edivaldorsj/catalogo-podcasts-ws/blob/master/src/test/java/br/com/edivaldorsj/db/CriadorTabelasTest.java) (na ordem em que foram escritos) ou crie manualmente com os comandos contidos nesse [script](https://github.com/edivaldorsj/catalogo-podcasts-ws/blob/master/script_create_tables.sql) sql.  

##### Endpoints: 

- Recuperar por lista de integrantes:
  - `http://localhost:8080/episodios?idIntegrante=1,2`

- Recuperar podcasts: 
  - `http://localhost:8080/podcasts/`
  - `http://localhost:8080/podcasts/1`
  - `http://localhost:8080/podcasts?nome=Nerdcast`


