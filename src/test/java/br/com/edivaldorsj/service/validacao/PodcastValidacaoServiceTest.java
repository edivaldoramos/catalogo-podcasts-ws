package br.com.edivaldorsj.service.validacao;

import br.com.edivaldorsj.utils.exceptions.ParametroInvalidoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PodcastValidacaoServiceTest {

  private IPodcastValidacaoService validacaoService;

  @Test
  void deveLancarParametroInvalidoExceptionQuandoIdPodcastForNulo() {
    Long id = null;

    ParametroInvalidoException exception = assertThrows(ParametroInvalidoException.class,
        () -> validacaoService.validarIdPodcast(id));

    assertEquals("Id do podcast passado por parametro é inválido.", exception.getMessage());
  }

  @Test
  void deveLancarParametroInvalidoExceptionQuandoIdPodcastForZeroOuMenorQueZero() {
    Long id = -1L;

    ParametroInvalidoException exception = assertThrows(ParametroInvalidoException.class,
        () -> validacaoService.validarIdPodcast(id));

    assertEquals("Id do podcast passado por parametro é inválido.", exception.getMessage());
  }

  @Test
  void deveLancarParametroInvalidoExceptionQuandoNomeForVazio() {
    String nome = "";

    ParametroInvalidoException exception = assertThrows(ParametroInvalidoException.class,
        () -> validacaoService.validarNomePodcast(nome));

    assertEquals("Nome do podcast passado por parametro é inválido.", exception.getMessage());
  }

  @Test
  void deveLancarParametroInvalidoExceptionQuandoNomePodcastForNulo() {
    String nome = null;

    ParametroInvalidoException exception = assertThrows(ParametroInvalidoException.class,
        () -> validacaoService.validarNomePodcast(nome));

    assertEquals("Nome do podcast passado por parametro é inválido.", exception.getMessage());
  }

  @Test
  void naoDeveLancarExcecaoQuandoNomePodcastForValido() {
    String nome = "podcast";
    assertDoesNotThrow(() -> validacaoService.validarNomePodcast(nome));
  }

  @Test
  void naoDeveLancarExcecaoQuandoIdPodcastForMaiorQueZero() {
    Long id = 1L;
    assertDoesNotThrow(() -> validacaoService.validarIdPodcast(id));
  }

  @BeforeEach
  void setUp() {
    validacaoService = new PodcastValidacaoService();
  }
}