create table podcast
(
    id bigserial not null constraint podcast_pk primary key,
    nome varchar not null,
    data_criacao timestamp not null,
    descricao varchar
);
alter table podcast owner to postgres;

create table if not exists episodio
(
    id bigserial not null constraint episodio_pk primary key,
    podcast_id bigint not null constraint episodio_fk references podcast,
    sequencia integer not null,
    titulo varchar not null,
    tema varchar not null,
    data_publicacao timestamp not null,
    duracao integer not null,
    descricao varchar
);
alter table episodio owner to postgres;

create table if not exists integrante
(
    id bigserial not null constraint integrante_pk primary key,
    nome varchar not null,
    apelido varchar not null,
    sexo char not null
);
alter table integrante owner to postgres;

create table participacao
(
    episodio_id bigint not null constraint participacao_episodio_id_fk references episodio,
    integrante_id bigint not null constraint participacao_integrante_id_fk references integrante,
    constraint participacao_pk primary key (episodio_id, integrante_id)
);
alter table participacao owner to postgres;