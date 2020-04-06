create database podcasts;

\c podcasts

create table if not exists podcast
(
    pd_id           bigserial not null
        constraint podcast_pk primary key,
    pd_nome         varchar   not null,
    pd_data_criacao date      not null,
    pd_descricao    varchar
);

create unique index podcast_pd_nome_uindex on podcast (pd_nome);

create table if not exists episodio
(
    ep_id              bigserial not null
        constraint episodio_pk primary key,
    ep_podcast_id      bigint    not null
        constraint episodio_fk references podcast,
    ep_sequencia       integer   not null,
    ep_titulo          varchar   not null,
    ep_tema            varchar   not null,
    ep_data_publicacao date      not null,
    ep_duracao         integer   not null,
    ep_descricao       varchar
);
create unique index episodio_ep_sequencia_uindex
    on episodio (ep_sequencia);

create unique index episodio_ep_titulo_uindex
    on episodio (ep_titulo);

create table if not exists integrante
(
    in_id      bigserial not null
        constraint integrante_pk primary key,
    in_nome    varchar   not null,
    in_apelido varchar   not null,
    in_sexo    char      not null
);
create unique index integrante_in_nome_uindex
    on integrante (in_nome);

create table if not exists participacao
(
    pa_episodio_id   bigint not null
        constraint participacao_episodio_id_fk references episodio,
    pa_integrante_id bigint not null
        constraint participacao_integrante_id_fk references integrante,
    constraint participacao_pk primary key (pa_episodio_id, pa_integrante_id)
);

insert into podcast (pd_nome, pd_data_criacao, pd_descricao)
values ('Nerdcast', '2006-04-02', 'Onde o mundo pop vira piada');
insert into episodio (ep_podcast_id, ep_sequencia, ep_titulo, ep_tema,
                                ep_data_publicacao, ep_duracao, ep_descricao)
values (1, 1, 'Super-Homem: Herói americano ou do mundo?', 'Quadrinhos', '2006-04-02', 13,
        'Em nosso primeiro programa, 4 nerds (Alottoni, Carlos Voltor, Guinnyn Nightshade e Lady Lark) falam sobre o ícone Super-Homem. Parece que Brian Singer quer acabar com o mito de que Kal-el é um herói tipicamente americano (Quem não se lembra do “Verdade, justiça e meio de vida americano”?), e mostrar neste filme que Super pertence ao mundo. Sem fronteiras, sem bandeiras.');
insert into episodio (ep_podcast_id, ep_sequencia, ep_titulo, ep_tema,
                                ep_data_publicacao, ep_duracao, ep_descricao)
values (1, 2, 'Batman Continues: Quem serão os vilões? ', 'Quadrinhos', '2006-04-02', 11,
        'Hoje, os nerds Alottoni, Carlos Voltor, Lady Lark e Guinnyn Nightshade continuam seu papo sem pé nem cabeça sobre os possíveis vilões da continuação de Batman Begins. Quem é o próximo a entrar na roleta de boatos? E quem não vai entrar nunca, mas ficaria ao menos engraçado caracterizado de bat-inimigo?');
insert into episodio (ep_podcast_id, ep_sequencia, ep_titulo, ep_tema,
                                ep_data_publicacao, ep_duracao, ep_descricao)
values (1, 3, 'Quadrinhos: A volta de Jason Todd (?!)', 'Quadrinhos', '2006-04-02', 21,
        'Pois é, para os mal informados, Jason Todd (O segundo Robin, assassinado(?) pelo Coringa) entrou para o Hall da Fama da ‘volta dos que não foram’!');

insert into integrante (in_nome, in_apelido, in_sexo)
values ('Alexandre Ottoni', 'Jovem Nerd', 'M');
insert into integrante (in_nome, in_apelido, in_sexo)
values ('Deive Pazos', 'Azagual', 'M');
insert into integrante (in_nome, in_apelido, in_sexo)
values ('Fernando Russel', 'Tucano', 'M');
insert into integrante (in_nome, in_apelido, in_sexo)
values ('Andreia Duboc', 'Portuguesa', 'F');
insert into integrante (in_nome, in_apelido, in_sexo)
values ('Agatha Ottoni', 'Sra. Jovem Nerd', 'F');
insert into integrante (in_nome, in_apelido, in_sexo)
values ('Frederico Carstens', 'Sr. K', 'M');
insert into integrante (in_nome, in_apelido, in_sexo)
values ('João Paulo Miguel', 'JP', 'M');
insert into integrante (in_nome, in_apelido, in_sexo)
values ('Tiago La''Marca', 'Rex', 'M');
insert into integrante (in_nome, in_apelido, in_sexo)
values ('Eduardo Spohr', 'Eduardo Spohr', 'M');
insert into integrante (in_nome, in_apelido, in_sexo)
values ('Gustavo Mafra', 'Guga Mafra', 'M');
insert into integrante (in_nome, in_apelido, in_sexo)
values ('Affonso Solano', 'Affonso Solano', 'M');
insert into integrante (in_nome, in_apelido, in_sexo)
values ('Diogo Braga', 'Didi Braguinha', 'M');
insert into integrante (in_nome, in_apelido, in_sexo)
values ('Roberto Duque Estrada', 'Beto Estrada', 'M');
insert into integrante (in_nome, in_apelido, in_sexo)
values ('Leila Germano', 'Leila Germano', 'F');
insert into integrante (in_nome, in_apelido, in_sexo)
values ('Lierson Mattenhauer JR', 'Lierson', 'M');
insert into integrante (in_nome, in_apelido, in_sexo)
values ('Filipe Figueiredo', 'Filipe Figueiredo', 'M');
insert into integrante (in_nome, in_apelido, in_sexo)
values ('Atila Iamarino', 'Atila Iamarino', 'M');
insert into integrante (in_nome, in_apelido, in_sexo)
values ('Carlos Voltor', 'Carlos Voltor', 'M');

insert into participacao (pa_episodio_id, pa_integrante_id)
values (1, 1);
insert into participacao (pa_episodio_id, pa_integrante_id)
values (1, 18);
insert into participacao (pa_episodio_id, pa_integrante_id)
values (2, 1);
insert into participacao (pa_episodio_id, pa_integrante_id)
values (2, 2);
insert into participacao (pa_episodio_id, pa_integrante_id)
values (3, 1);
insert into participacao (pa_episodio_id, pa_integrante_id)
values (3, 2);
insert into participacao (pa_episodio_id, pa_integrante_id)
values (2, 18);
insert into participacao (pa_episodio_id, pa_integrante_id)
values (3, 18);