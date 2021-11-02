package br.com.todolistapp.todolist.controller;

import br.com.todolistapp.todolist.model.Tarefa;
import br.com.todolistapp.todolist.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/tarefa"})
public class TarefaController {

    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List findAll(){
        return tarefaService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Tarefa> findById(@PathVariable long id){
        return tarefaService.findById(id);
    }

    @PostMapping
    public Tarefa create(@RequestBody Tarefa tarefa){
        return tarefaService.create(tarefa);
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody Tarefa tarefa){
        return tarefaService.update(id, tarefa);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id){
        return tarefaService.delete(id);
    }

}
