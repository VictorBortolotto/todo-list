package br.com.todolistapp.todolist.controller;

import br.com.todolistapp.todolist.model.TarefaModel;
import br.com.todolistapp.todolist.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TarefaController {

    private TarefaService tarefaService;

    @Autowired
    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping(path = "/tarefa/feito", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TarefaModel> findAllDone(){
        return tarefaService.findAllDone(true);
    }

    @GetMapping(path = "/tarefa/pendente", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TarefaModel> findAllPending(){
        return tarefaService.findAllPending(false);
    }

    @PatchMapping(path = "/tarefa/{id}/update-to-done")
    public ResponseEntity<TarefaModel> updateToDone(@PathVariable long id, TarefaModel tarefa){
        return tarefaService.updateToDone(id, tarefa);
    }

    @PatchMapping(path = "/tarefa/{id}/update-to-pending")
    public ResponseEntity<TarefaModel> updateToPending(@PathVariable long id, TarefaModel tarefa){
        return tarefaService.updateToPending(id, tarefa);
    }

    @PostMapping(path = "/tarefa", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TarefaModel save(@RequestBody TarefaModel tarefaModel){
        return tarefaService.create(tarefaModel);
    }

}
