package br.com.edivaldorsj.controller;

import br.com.edivaldorsj.model.Podcast;
import br.com.edivaldorsj.service.IPodcastService;
import br.com.edivaldorsj.utils.exceptions.ParametroInvalidoException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/podcasts", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
public class PodcastController {

  private final IPodcastService podcastService;

  @GetMapping(params = "nome")
  public ResponseEntity<Podcast> buscarPodcast(@RequestParam("nome") String nome) throws ParametroInvalidoException {
    Podcast podcast = podcastService.recuperarPorNome(nome);
    return ResponseEntity.ok(podcast);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Podcast> buscarPodcastPorId(@PathVariable("id") Long id) throws ParametroInvalidoException {
    Podcast podcast = podcastService.recuperarPorId(id);
    return ResponseEntity.ok(podcast);
  }

  @GetMapping
  public ResponseEntity<List<Podcast>> buscarTodosPodcasts() {
    List<Podcast> podcasts = podcastService.recuperarTodos();
    return ResponseEntity.ok(podcasts);
  }

}
