package br.com.todolistapp.todolist.service;

import br.com.todolistapp.todolist.model.TarefaModel;
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

    public List<TarefaModel> findAllDone(boolean status){
        return tarefaRepository.findAllByStatus(status);
    }

    public List<TarefaModel> findAllPending(boolean status){
        return tarefaRepository.findAllByStatus(status);
    }

    public ResponseEntity<TarefaModel> updateToDone(long id, TarefaModel tarefa){
        return tarefaRepository.findById(id).map(record -> {
            tarefa.setStatus(true);
            record.setStatus(tarefa.getStatus());
            TarefaModel updated = tarefaRepository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<TarefaModel> updateToPending(long id, TarefaModel tarefa){
        return tarefaRepository.findById(id).map(record -> {
            tarefa.setStatus(false);
            record.setStatus(tarefa.getStatus());
            TarefaModel updated = tarefaRepository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    public TarefaModel create(TarefaModel tarefaModel){
        return tarefaRepository.save(tarefaModel);
    }

}