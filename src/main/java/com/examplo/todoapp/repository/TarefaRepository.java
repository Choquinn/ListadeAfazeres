package com.examplo.todoapp.repository;

import com.examplo.todoapp.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
	List<Tarefa> findByConcluida(boolean concluida);
}
