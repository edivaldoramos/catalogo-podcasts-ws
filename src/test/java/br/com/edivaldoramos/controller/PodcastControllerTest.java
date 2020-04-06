package br.com.edivaldoramos.controller;

import br.com.edivaldoramos.service.IPodcastService;
import br.com.edivaldoramos.service.PodcastService;
import br.com.edivaldoramos.utils.exceptions.ParametroInvalidoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class PodcastControllerTest {

  private PodcastController podcastController;
  private IPodcastService   podcastService;

  @Test
  void deveInvocarBuscarPodcastPorIdUmaUnicaVez() throws ParametroInvalidoException {
    Long id = 1L;
    podcastController.buscarPodcastPorId(id);
    verify(podcastService, times(1)).buscarPorId(id);
    verifyNoMoreInteractions(podcastService);
  }

  @Test
  void deveInvocarBuscarPodcastPorNomeUmaUnicaVez() throws ParametroInvalidoException {
    String nome = "podcast";
    podcastController.buscarPodcastPorNome(nome);
    verify(podcastService, times(1)).buscarPorNome(nome);
    verifyNoMoreInteractions(podcastService);
  }

  @Test
  void deveInvocarBuscarTodosPodcastsUmaUnicaVez() {
    podcastController.buscarTodosPodcasts();
    verify(podcastService, times(1)).buscarTodos();
    verifyNoMoreInteractions(podcastService);
  }

  @BeforeEach
  void setUp() {
    podcastService = mock(PodcastService.class);
    podcastController = new PodcastController(podcastService);
  }
}