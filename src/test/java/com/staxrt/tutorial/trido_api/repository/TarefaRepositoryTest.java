package com.staxrt.tutorial.trido_api.repository;

import com.staxrt.tutorial.trido_api.Application;
import com.staxrt.tutorial.trido_api.model.Equilibrio;
import com.staxrt.tutorial.trido_api.model.StatusTarefa;
import com.staxrt.tutorial.trido_api.model.Tarefa;
import com.staxrt.tutorial.trido_api.model.Triade;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TarefaRepositoryTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private StatusTarefaRepository statusTarefaRepository;
    @LocalServerPort
    private int port;
    private String getRootUrl() {
        return "http://localhost:" + port;
    }
    @Test
    public void contextLoads() {
    }
    @Test
    public void testGetAllTarefas() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/tarefas",
                HttpMethod.GET, entity, String.class);
        Assert.assertNotNull(response.getBody());
    }
    @Test
    public void testGetTarefaById() {
        Tarefa tarefa = restTemplate.getForObject(getRootUrl() + "/tarefa/1", Tarefa.class);
        System.out.println(tarefa.getNome());
        Assert.assertNotNull(tarefa);
    }
    @Test
    public void testCreateTarefa() throws Exception {
        Equilibrio equilibrio = new Equilibrio();
        equilibrio.setEmocional(true);
        equilibrio.setEspiritual(false);
        equilibrio.setFisico(false);
        equilibrio.setMental(false);
        long id = 620633353565738785L;
        Triade triade = new Triade();
        triade.setCircunstancial(false);
        triade.setImportante(false);
        triade.setUrgente(true);
        StatusTarefa statusTarefa = statusTarefaRepository.findById(id).orElseThrow(Exception::new);
        Tarefa tarefa = new Tarefa();
        tarefa.setTriade(triade);
        tarefa.setStatusTarefa(statusTarefa);
        tarefa.setEquilibrio(equilibrio);
        tarefa.setCreatedAt(new Date());
        tarefa.setCreatedAt(new Date());
        tarefa.setNome("tarefa");
        tarefa.setDuracao(new Date());
        ResponseEntity<Tarefa> postResponse = restTemplate.postForEntity(getRootUrl() + "/tarefas", tarefa, Tarefa.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

}
