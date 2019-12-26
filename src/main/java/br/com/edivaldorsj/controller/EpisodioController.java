package br.com.edivaldorsj.controller;

import br.com.edivaldorsj.model.Episodio;
import br.com.edivaldorsj.service.IEpisodioService;
import br.com.edivaldorsj.utils.exceptions.ParametroInvalidoException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/episodios")
@RequiredArgsConstructor
public class EpisodioController {

  private final IEpisodioService episodioService;

  @GetMapping
  public ResponseEntity<List<Episodio>> buscarEpisodiosPorIntegrantes(@RequestParam("idIntegrante") List<Long> idsIntegrantes) throws ParametroInvalidoException {
    return ResponseEntity.ok(episodioService.buscarEpisodiosPorIntegrantes(idsIntegrantes));
  }

}
