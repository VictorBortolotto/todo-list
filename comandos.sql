create database todolist;

use todolist;

create table tarefa(
	id int primary key,
    descricao varchar(36000),
    status_tarefa boolean default(false)
);

ALTER TABLE `todolist`.`tarefa`
CHANGE COLUMN `id` `id` INT NOT NULL AUTO_INCREMENT ;