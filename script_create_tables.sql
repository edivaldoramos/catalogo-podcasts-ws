create database catalogo_podcast;

create schema catalogo;

create table catalogo.ca01_podcast
(
    ca01_id           bigserial not null
        constraint podcast_pk primary key,
    ca01_nome         varchar   not null,
    ca01_data_criacao date      not null,
    ca01_descricao    varchar
);
alter table catalogo.ca01_podcast
    owner to postgres;

create table if not exists catalogo.ca02_episodio
(
    ca02_id              bigserial not null
        constraint episodio_pk primary key,
    ca02_podcast_id      bigint    not null
        constraint episodio_fk references catalogo.ca01_podcast,
    ca02_sequencia       integer   not null,
    ca02_titulo          varchar   not null,
    ca02_tema            varchar   not null,
    ca02_data_publicacao date      not null,
    ca02_duracao         integer   not null,
    ca02_descricao       varchar
);
alter table catalogo.ca02_episodio
    owner to postgres;

create table if not exists catalogo.ca03_integrante
(
    ca03_id      bigserial not null
        constraint integrante_pk primary key,
    ca03_        varchar   not null,
    ca03_apelido varchar   not null,
    ca03_sexo    char      not null
);
alter table catalogo.ca03_integrante
    owner to postgres;

create table catalogo.ca04_participacao
(
    ca04_episodio_id   bigint not null
        constraint participacao_episodio_id_fk references catalogo.ca02_episodio,
    ca04_integrante_id bigint not null
        constraint participacao_integrante_id_fk references catalogo.ca03_integrante,
    constraint participacao_pk primary key (ca04_episodio_id, ca04_integrante_id)
);
alter table catalogo.ca04_participacao
    owner to postgres;