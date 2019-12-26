package br.com.edivaldorsj.service;

import br.com.edivaldorsj.mapper.PodcastMapper;
import br.com.edivaldorsj.model.Podcast;
import br.com.edivaldorsj.service.validacao.IPodcastValidacaoService;
import br.com.edivaldorsj.service.validacao.PodcastValidacaoService;
import br.com.edivaldorsj.utils.exceptions.ParametroInvalidoException;
import br.com.edivaldorsj.utils.exceptions.RecursoNaoEncontradoException;
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
  void deveInvocarUmaUnicaVezRecuperarTodosDoMapper() {
    podcastService.recuperarTodos();
    verify(podcastMapper, times(1)).recuperarTodos();
    verifyNoMoreInteractions(podcastMapper);
  }

  @Test
  void deveLancarRecursoNaoEncontradoExceptionQuandoABuscaPorIdNaoPossuirResultados() {
    when(podcastMapper.recuperarPorId(1L)).thenReturn(null);

    RecursoNaoEncontradoException exception = assertThrows(RecursoNaoEncontradoException.class,
        () -> podcastService.recuperarPorId(1L));

    assertEquals("Nenhum resultado para o id passado por parametro.", exception.getMessage());
  }

  @Test
  void deveLancarRecursoNaoEncontradoExceptionQuandoABuscaPorNomeNaoPossuirResultados() {
    when(podcastMapper.recuperarPorNome("podcast")).thenReturn(null);

    RecursoNaoEncontradoException exception = assertThrows(RecursoNaoEncontradoException.class,
        () -> podcastService.recuperarPorNome("podcast"));

    assertEquals("Nenhum resultado para o nome passado por parametro.", exception.getMessage());
  }

  @Test
  void deveSeguirOrdemChamadasMetodosDuranteBuscaPorId() throws ParametroInvalidoException {
    Long id = 1L;
    Podcast podcast = new Podcast();

    when(podcastMapper.recuperarPorId(id)).thenReturn(podcast);

    podcastService.recuperarPorId(id);

    InOrder ordemChamadas = inOrder(validacaoService, podcastMapper);
    ordemChamadas.verify(validacaoService).validarIdPodcast(id);
    ordemChamadas.verify(podcastMapper).recuperarPorId(id);

    verifyNoMoreInteractions(validacaoService);
    verifyNoMoreInteractions(podcastMapper);
  }

  @Test
  void deveSeguirOrdemChamadasMetodosDuranteBuscaPorNome() throws ParametroInvalidoException {
    String nome = "podcast";
    Podcast podcast = new Podcast();

    when(podcastMapper.recuperarPorNome(nome)).thenReturn(podcast);
    podcastService.recuperarPorNome(nome);

    InOrder ordemChamadas = inOrder(validacaoService, podcastMapper);
    ordemChamadas.verify(validacaoService).validarNomePodcast(nome);
    ordemChamadas.verify(podcastMapper).recuperarPorNome(nome);

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