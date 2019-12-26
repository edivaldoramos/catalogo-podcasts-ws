package br.com.edivaldorsj.controller;

import br.com.edivaldorsj.service.IPodcastService;
import br.com.edivaldorsj.service.PodcastService;
import br.com.edivaldorsj.utils.exceptions.ParametroInvalidoException;
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
  void deveInvocarMetodoRecuperarPorIdDaClasseDeServicoUmaUnicaVezDuranteABusca() throws ParametroInvalidoException {
    Long id = 1L;
    podcastController.buscarPodcastPorId(id);
    verify(podcastService, times(1)).recuperarPorId(id);
    verifyNoMoreInteractions(podcastService);
  }

  @Test
  void deveInvocarMetodoRecuperarPorNomeDaClasseDeServicoUmaUnicaVezDuranteABusca() throws ParametroInvalidoException {
    String nome = "podcast";
    podcastController.buscarPodcastPorNome(nome);
    verify(podcastService, times(1)).recuperarPorNome(nome);
    verifyNoMoreInteractions(podcastService);
  }

  @Test
  void deveInvocarMetodoRecuperarTodosDaClasseDeServicoUmaUnicaVezDuranteABusca() throws ParametroInvalidoException {
    podcastController.buscarTodosPodcasts();
    verify(podcastService, times(1)).recuperarTodos();
    verifyNoMoreInteractions(podcastService);
  }

  @BeforeEach
  void setUp() {
    podcastService = mock(PodcastService.class);
    podcastController = new PodcastController(podcastService);
  }
}