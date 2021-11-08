package br.com.todolistapp.todolist.service;

import br.com.todolistapp.todolist.model.Tarefa;
import br.com.todolistapp.todolist.repository.TarefaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;
    }

    public List findAll(){
        return tarefaRepository.findAll();
    }

    public ResponseEntity<Tarefa> findById(long id){
        return tarefaRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    public Tarefa create(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public ResponseEntity update(long id, Tarefa tarefa) {
        return tarefaRepository.findById(id).map(record -> {
            record.setDescricao(tarefa.getDescricao());
            record.setStatusTarefa(tarefa.getStatusTarefa());
            Tarefa updated = tarefaRepository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity <?> delete (long id){
        return tarefaRepository.findById(id).map(record -> {
            tarefaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
