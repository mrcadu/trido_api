package com.staxrt.tutorial.trido_api.controller;

import com.staxrt.tutorial.trido_api.exception.ResourceNotFoundException;
import com.staxrt.tutorial.trido_api.model.Tarefa;
import com.staxrt.tutorial.trido_api.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping("/tarefas")
    public List<Tarefa> getAllTarefas() {
        return tarefaRepository.findAll();
    }

    @GetMapping("/tarefas/active")
    public List<Tarefa> getTarefasAtivas(){
        return (List<Tarefa>) tarefaRepository.findAllTarefasAtivas();
    }

    @GetMapping("/tarefas/{id}")
    public ResponseEntity<Tarefa> getTarefaById(@PathVariable(value = "id") Long papelId) throws Exception {
        Tarefa tarefa =
                tarefaRepository.findById(papelId)
                        .orElseThrow(Exception::new);
        return ResponseEntity.ok().body(tarefa);
    }

    @PostMapping("/tarefas")
    public Tarefa createTarefa(@Valid @RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @PutMapping("/tarefas/{id}")
    public ResponseEntity<Tarefa> updateTarefa(
            @PathVariable(value = "id") Long tarefaId, @Valid @RequestBody Tarefa tarefaDetails)
            throws ResourceNotFoundException {
        Tarefa tarefa = tarefaRepository
                .findById(tarefaId)
                .orElseThrow(() -> new ResourceNotFoundException("tarefa not found on :: " + tarefaId));
        tarefa.setNome(tarefaDetails.getNome());
        tarefa.setDuracao(tarefaDetails.getDuracao());
        tarefa.setData(tarefaDetails.getData());
        tarefa.setEquilibrio(tarefaDetails.getEquilibrio());
        tarefa.setMetas(tarefaDetails.getMetas());
        tarefa.setPapeis(tarefaDetails.getPapeis());
        tarefa.setStatusTarefa(tarefaDetails.getStatusTarefa());
        tarefa.setTriade(tarefaDetails.getTriade());
        tarefa.setUpdatedAt(tarefaDetails.getUpdatedAt());
        final Tarefa updatedTarefa = tarefaRepository.save(tarefa);
        return ResponseEntity.ok(updatedTarefa);
    }
    @CrossOrigin()
    @DeleteMapping("/tarefas/{id}")
    public Map<String, Boolean> deleteTarefa(@PathVariable(value = "id") Long tarefaId) throws Exception {
        Tarefa tarefa =
                tarefaRepository
                        .findById(tarefaId)
                        .orElseThrow(() -> new ResourceNotFoundException("tarefa not found on :: " + tarefaId));

        Map<String, Boolean> response = new HashMap<>();
        tarefaRepository.delete(tarefa);
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}