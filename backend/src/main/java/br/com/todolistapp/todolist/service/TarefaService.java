package br.com.todolistapp.todolist.service;

import br.com.todolistapp.todolist.model.Tarefa;
import br.com.todolistapp.todolist.repository.TarefaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class TarefaService {

    private TarefaRepository repository;

    public List<Tarefa> findAll(){
        return repository.findAll();
    }

    public ResponseEntity findById(long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    public Tarefa create(Tarefa tarefa){
        return repository.save(tarefa);
    }

    public ResponseEntity update(long id, Tarefa tarefa) {
        return repository.findById(id).map(record -> {
            record.setDescricao(tarefa.getDescricao());
            record.setStatusTarefa(tarefa.getStatusTarefa());
            Tarefa updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity <?> delete (long id){
        return repository.findById(id).map(record -> {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
