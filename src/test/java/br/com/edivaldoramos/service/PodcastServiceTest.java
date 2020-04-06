package br.com.edivaldoramos.service;

import br.com.edivaldoramos.mapper.PodcastMapper;
import br.com.edivaldoramos.model.Podcast;
import br.com.edivaldoramos.service.validacao.IPodcastValidacaoService;
import br.com.edivaldoramos.service.validacao.PodcastValidacaoService;
import br.com.edivaldoramos.utils.exceptions.ParametroInvalidoException;
import br.com.edivaldoramos.utils.exceptions.RecursoNaoEncontradoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class PodcastServiceTest {

  private PodcastMapper            podcastMapper;
  private IPodcastService          podcastService;
  private IPodcastValidacaoService validacaoService;

  @Test
  void deveInvocarRecuperarTodosUmaUnicaVez() {
    podcastService.buscarTodos();
    verify(podcastMapper, times(1)).buscarTodos();
    verifyNoMoreInteractions(podcastMapper);
  }

  @Test
  void deveLancarRecursoNaoEncontradoExceptionQuandoABuscaPorIdNaoPossuirResultados() {
    when(podcastMapper.buscarPorId(1L)).thenReturn(null);

    RecursoNaoEncontradoException exception = assertThrows(RecursoNaoEncontradoException.class,
        () -> podcastService.buscarPorId(1L));

    assertEquals("Nenhum resultado para o id passado por parametro.", exception.getMessage());
  }

  @Test
  void deveLancarRecursoNaoEncontradoExceptionQuandoABuscaPorNomeNaoPossuirResultados() {
    when(podcastMapper.buscarPorNome("podcast")).thenReturn(null);

    RecursoNaoEncontradoException exception = assertThrows(RecursoNaoEncontradoException.class,
        () -> podcastService.buscarPorNome("podcast"));

    assertEquals("Nenhum resultado para o nome passado por parametro.", exception.getMessage());
  }

  @Test
  void deveSeguirOrdemChamadasMetodosDuranteBuscaPorId() throws ParametroInvalidoException {
    Long id = 1L;
    Podcast podcast = new Podcast();

    when(podcastMapper.buscarPorId(id)).thenReturn(podcast);

    podcastService.buscarPorId(id);

    InOrder ordemChamadas = inOrder(validacaoService, podcastMapper);
    ordemChamadas.verify(validacaoService).validarIdPodcast(id);
    ordemChamadas.verify(podcastMapper).buscarPorId(id);

    verifyNoMoreInteractions(validacaoService);
    verifyNoMoreInteractions(podcastMapper);
  }

  @Test
  void deveSeguirOrdemChamadasMetodosDuranteBuscaPorNome() throws ParametroInvalidoException {
    String nome = "podcast";
    Podcast podcast = new Podcast();

    when(podcastMapper.buscarPorNome(nome)).thenReturn(podcast);
    podcastService.buscarPorNome(nome);

    InOrder ordemChamadas = inOrder(validacaoService, podcastMapper);
    ordemChamadas.verify(validacaoService).validarNomePodcast(nome);
    ordemChamadas.verify(podcastMapper).buscarPorNome(nome);

    verifyNoMoreInteractions(validacaoService);
    verifyNoMoreInteractions(podcastMapper);
  }

  @BeforeEach
  void setUp() {
    podcastMapper = mock(PodcastMapper.class);
    validacaoService = mock(PodcastValidacaoService.class);
    podcastService = new PodcastService(podcastMapper, validacaoService);
  }

}