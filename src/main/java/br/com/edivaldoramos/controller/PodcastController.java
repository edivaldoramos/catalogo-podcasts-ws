package br.com.edivaldoramos.controller;

import br.com.edivaldoramos.model.Podcast;
import br.com.edivaldoramos.service.IPodcastService;
import br.com.edivaldoramos.utils.exceptions.ParametroInvalidoException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/podcasts")
@RequiredArgsConstructor
@Slf4j
public class PodcastController {

    private final IPodcastService podcastService;

    @GetMapping(params = "nome")
    public ResponseEntity<Podcast> buscarPodcastPorNome(@RequestParam("nome") String nome) throws ParametroInvalidoException {
        return ResponseEntity.ok(podcastService.buscarPorNome(nome));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Podcast> buscarPodcastPorId(@PathVariable("id") Long id) throws ParametroInvalidoException {
        return ResponseEntity.ok(podcastService.buscarPorId(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Podcast>> buscarTodosPodcasts() {
        return ResponseEntity.ok(podcastService.buscarTodos());
    }

}
