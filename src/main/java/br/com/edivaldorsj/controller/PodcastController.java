package br.com.edivaldorsj.controller;

import br.com.edivaldorsj.model.Podcast;
import br.com.edivaldorsj.service.IPodcastService;
import br.com.edivaldorsj.utils.exceptions.IdInvalidoException;
import java.util.List;
import javax.xml.bind.ValidationException;
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
  public ResponseEntity<Podcast> recuperarPodcast(@RequestParam("nome") String nome) {
    Podcast podcast = podcastService.recuperarPorNome(nome);
    return ResponseEntity.ok(podcast);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Podcast> recuperarPodcastPorId(@PathVariable("id") Long id) throws IdInvalidoException {
    return ResponseEntity.ok(podcastService.recuperarPorId(id));
  }

  @GetMapping
  public ResponseEntity<List<Podcast>> recuperarTodosPodcasts() {
    return ResponseEntity.ok(podcastService.recuperarTodos());
  }

}
