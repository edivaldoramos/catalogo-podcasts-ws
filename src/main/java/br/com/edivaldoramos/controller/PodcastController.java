package br.com.edivaldoramos.controller;

import br.com.edivaldoramos.model.Podcast;
import br.com.edivaldoramos.service.IPodcastService;
import br.com.edivaldoramos.utils.exceptions.ParametroInvalidoException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/podcasts")
@RequiredArgsConstructor
public class PodcastController {

  private final IPodcastService podcastService;

  @GetMapping(params = "nome")
  public ResponseEntity<Podcast> buscarPodcastPorNome(@RequestParam("nome") String nome) throws ParametroInvalidoException {
    return ResponseEntity.ok(podcastService.recuperarPorNome(nome));
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Podcast> buscarPodcastPorId(@PathVariable("id") Long id) throws ParametroInvalidoException {
    return ResponseEntity.ok(podcastService.recuperarPorId(id));
  }

  @GetMapping
  public ResponseEntity<List<Podcast>> buscarTodosPodcasts() {
    return ResponseEntity.ok(podcastService.recuperarTodos());
  }

}
