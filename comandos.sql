create database todolist;

use todolist;

create table tarefa(
	id int primary key,
    descricao varchar(36000),
    status_tarefa boolean default(false)
);