package br.com.todolistapp.todolist.model;

import javax.persistence.*;

@Entity
public class Tarefa {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descricaoTarefa")
    private String descricao;


    @Column(name = "statusTarefa")
    private boolean statusTarefa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getStatusTarefa() {
        return statusTarefa;
    }

    public void setStatusTarefa(boolean statusTarefa) {
        this.statusTarefa = statusTarefa;
    }


}
