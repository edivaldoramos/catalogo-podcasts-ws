package br.com.edivaldoramos.controller;

import br.com.edivaldoramos.model.Episodio;
import br.com.edivaldoramos.service.IEpisodioService;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/episodios")
@RequiredArgsConstructor
public class EpisodioController {

  private final IEpisodioService episodioService;

  @GetMapping("/{id}")
  public ResponseEntity<Episodio> buscarPorId(@PathVariable("id") Long id) {
    return ResponseEntity.ok(episodioService.buscarEpisodiosPorId(id));
  }

  @GetMapping(params = "tema")
  public ResponseEntity<List<Episodio>> buscarPorTema(@RequestParam("tema") String tema) {
    return ResponseEntity.ok(episodioService.buscarEpisodiosPorTema(tema));
  }

  @GetMapping("/")
  public ResponseEntity<List<Episodio>> buscarTodos() {
    return ResponseEntity.ok(episodioService.buscarTodos());
  }

}
