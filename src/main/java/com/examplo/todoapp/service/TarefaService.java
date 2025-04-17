package com.examplo.todoapp.service;

import com.examplo.todoapp.model.Tarefa;
import com.examplo.todoapp.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
	private final TarefaRepository tarefaRepository;
	
	public TarefaService(TarefaRepository tarefaRepository) {
		this.tarefaRepository = tarefaRepository;
	}
	
	public List<Tarefa> listarTodas() {
		return tarefaRepository.findAll();
	}
	
	public List<Tarefa> listarPorStatus(boolean concluida) {
		return tarefaRepository.findByConcluida(concluida);
	}
	
	public Tarefa salvar(Tarefa tarefa) {
		return tarefaRepository.save(tarefa);
	}
	
	public Optional<Tarefa> buscarPorId(Long id) {
		return tarefaRepository.findById(id);
	}
	
	public void deletar(Long id) {
		tarefaRepository.deleteById(id);
	}
}
