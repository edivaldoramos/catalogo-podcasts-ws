package br.com.edivaldorsj.service.validacao;

import br.com.edivaldorsj.model.Episodio;
import br.com.edivaldorsj.model.Podcast;
import br.com.edivaldorsj.utils.exceptions.ParametroInvalidoException;
import br.com.edivaldorsj.utils.exceptions.RecursoNaoEncontradoException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EpisodioValidacaoServiceTest {

  private IEpisodioValidacaoService validacaoService;

  @Test
  void deveLancarParametroInvalidoExceptionQuandoListaDeEpisodiosEstiverNula() {
    List<Episodio> episodios = null;

    RecursoNaoEncontradoException exception = assertThrows(RecursoNaoEncontradoException.class,
        () -> validacaoService.validarEpisodios(episodios));

    assertEquals("Nenhum episodio encontrado para os integrantes passados por parametro.", exception.getMessage());
  }

  @Test
  void deveLancarParametroInvalidoExceptionQuandoListaDeEpisodiosEstiverVazia() {
    List<Episodio> episodios = new ArrayList<>();

    RecursoNaoEncontradoException exception = assertThrows(RecursoNaoEncontradoException.class,
        () -> validacaoService.validarEpisodios(episodios));

    assertEquals("Nenhum episodio encontrado para os integrantes passados por parametro.", exception.getMessage());
  }

  @Test
  void deveLancarParametroInvalidoExceptionQuandoListaDeIdsEstiverNula() {
    List<Long> ids = null;

    ParametroInvalidoException exception = assertThrows(ParametroInvalidoException.class,
        () -> validacaoService.validarIdsIntegrantes(ids));

    assertEquals("Os ids dos integrantes passados por parametro são inválidos.", exception.getMessage());
  }

  @Test
  void deveLancarParametroInvalidoExceptionQuandoListaDeIdsEstiverVazia() {
    List<Long> ids = new ArrayList<>();

    ParametroInvalidoException exception = assertThrows(ParametroInvalidoException.class,
        () -> validacaoService.validarIdsIntegrantes(ids));

    assertEquals("Os ids dos integrantes passados por parametro são inválidos.", exception.getMessage());
  }

  @Test
  void naoDeveLancarExcecaoQuandoListaPossuirValoresValidos() {
    List<Long> ids = Collections.singletonList(1L);
    assertDoesNotThrow(() -> validacaoService.validarIdsIntegrantes(ids));
  }

  @Test
  void naoDeveLancarExcecaoQuandoIdPodcastForMaiorQueZero() {
    List<Episodio> episodios = Arrays.asList(new Episodio());
    assertDoesNotThrow(() -> validacaoService.validarEpisodios(episodios));
  }

  @BeforeEach
  void setUp() {
    validacaoService = new EpisodioValidacaoService();
  }
}