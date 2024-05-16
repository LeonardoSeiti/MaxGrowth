
create sequence categoria_seq start with 1 increment by 50;
create sequence produto_seq start with 1 increment by 50;
create table categoria (id number(19,0) not null, icon varchar2(255 char), tipo varchar2(255 char), primary key (id));
create table produto (preco float(53), quantidade number(10,0) not null, id number(19,0) not null, descricao varchar2(60 char), nome varchar2(255 char), sabor varchar2(255 char), primary key (id));
