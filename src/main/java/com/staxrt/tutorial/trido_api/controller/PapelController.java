package com.staxrt.tutorial.trido_api.controller;

import com.staxrt.tutorial.trido_api.exception.ResourceNotFoundException;
import com.staxrt.tutorial.trido_api.model.Papel;
import com.staxrt.tutorial.trido_api.repository.PapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class PapelController {

    @Autowired
    private PapelRepository papelRepository;

    @GetMapping("/papeis")
    public List<Papel> getAllPapeis() {
        return papelRepository.findAll();
    }

    @GetMapping("/papeis/{id}")
    public ResponseEntity<Papel> getPapelById(@PathVariable(value = "id") Long papelId) throws Exception {
        Papel papel =
                papelRepository.findById(papelId)
                        .orElseThrow(Exception::new);
        return ResponseEntity.ok().body(papel);
    }

    @PostMapping("/papeis")
    public Papel createPapel(@Valid @RequestBody Papel papel) {
        return papelRepository.save(papel);
    }

    @PutMapping("/papeis/{id}")
    public ResponseEntity<Papel> updatePapel(
            @PathVariable(value = "id") Long papelId, @Valid @RequestBody Papel papelDetails)
            throws ResourceNotFoundException {
        Papel papel = papelRepository
                .findById(papelId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + papelId));
        papel.setNome(papelDetails.getNome());
        final Papel updatedUser = papelRepository.save(papel);
        return ResponseEntity.ok(updatedUser);
    }

    @CrossOrigin()
    @DeleteMapping("/papeis/{id}")
    public Map<String, Boolean> deletePapel(@PathVariable(value = "id") Long papelId) throws Exception {
        Papel papel =
                papelRepository
                        .findById(papelId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + papelId));

        Map<String, Boolean> response = new HashMap<>();
        papelRepository.delete(papel);
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
