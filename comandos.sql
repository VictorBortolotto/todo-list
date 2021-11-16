create database todolist;

use todolist;

create table tarefa(
	id int primary key,
    descricao varchar(16000),
    status boolean default(false)
);