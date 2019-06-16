package com.staxrt.tutorial.trido_api.controller;

import com.staxrt.tutorial.trido_api.exception.ResourceNotFoundException;
import com.staxrt.tutorial.trido_api.model.Meta;
import com.staxrt.tutorial.trido_api.repository.MetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MetaController {

    @Autowired
    private MetaRepository metaRepository;

    @GetMapping("/metas")
    public List<Meta> getAllMetas() {
        return metaRepository.findAll();
    }

    @GetMapping("/metas/{id}")
    public ResponseEntity<Meta> getMetaById(@PathVariable(value = "id") Long papelId) throws Exception {
        Meta meta =
                metaRepository.findById(papelId)
                        .orElseThrow(Exception::new);
        return ResponseEntity.ok().body(meta);
    }

    @PostMapping("/metas")
    public Meta createMeta(@Valid @RequestBody Meta meta) {
        return metaRepository.save(meta);
    }

    @PutMapping("/metas/{id}")
    public ResponseEntity<Meta> updateMeta(
            @PathVariable(value = "id") Long metaId, @Valid @RequestBody Meta metaDetails)
            throws ResourceNotFoundException {
        Meta meta = metaRepository
                .findById(metaId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + metaId));
        meta.setNome(metaDetails.getNome());
        final Meta updatedUser = metaRepository.save(meta);
        return ResponseEntity.ok(updatedUser);
    }

    @CrossOrigin()
    @DeleteMapping("/metas/{id}")
    public Map<String, Boolean> deleteMeta(@PathVariable(value = "id") Long metaId) throws Exception {
        Meta meta =
                metaRepository
                        .findById(metaId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + metaId));

        Map<String, Boolean> response = new HashMap<>();
        metaRepository.delete(meta);
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
