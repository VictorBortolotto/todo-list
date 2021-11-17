package br.com.todolistapp.todolist.repository;

import br.com.todolistapp.todolist.model.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaModel, Long>{
    List<TarefaModel> findAllByStatus(@Param("status") boolean status);
}
