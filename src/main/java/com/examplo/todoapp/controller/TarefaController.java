package com.examplo.todoapp.controller;

import com.examplo.todoapp.model.Tarefa;
import com.examplo.todoapp.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {
	
	private final TarefaService tarefaService;
	
	public TarefaController(TarefaService tarefaService) {
		this.tarefaService = tarefaService;
	}
	
	@GetMapping
	public List<Tarefa> listarTodas() {
		return tarefaService.listarTodas();
	}
	
	@GetMapping("/status")
	public List<Tarefa> listarPorStatus(@RequestParam boolean concluida) {
		return tarefaService.listarPorStatus(concluida);
	}
	
	@PostMapping
	public Tarefa criar(@RequestBody Tarefa tarefa) {
		return tarefaService.salvar(tarefa);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada) {
		return tarefaService.buscarPorId(id)
				.map(tarefa -> {
					tarefa.setTitulo(tarefaAtualizada.getTitulo());
					tarefa.setDescricao(tarefaAtualizada.getDescricao());
					tarefa.setData(tarefaAtualizada.getData());
					tarefa.setConcluida(tarefaAtualizada.isConcluida());
					return ResponseEntity.ok(tarefaService.salvar(tarefa));
				}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		tarefaService.deletar(id);
		return ResponseEntity.noContent().build();
	}
}
