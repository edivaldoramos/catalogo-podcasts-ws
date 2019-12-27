package br.com.edivaldoramos.controller;

import br.com.edivaldoramos.service.EpisodioService;
import br.com.edivaldoramos.service.IEpisodioService;
import br.com.edivaldoramos.utils.exceptions.ParametroInvalidoException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class EpisodioControllerTest {

  private IEpisodioService episodioService;
  private EpisodioController episodioController;

  @Test
  void deveInvocarMetodoBuscarEpisodiosPorIntegrantesDaClasseDeServicoUmaUnicaVezDuranteABusca() throws ParametroInvalidoException {
    List<Long> ids = Arrays.asList(1L, 2L);
    episodioController.buscarEpisodiosPorIntegrantes(ids);
    verify(episodioService, times(1)).buscarEpisodiosPorIntegrantes(ids);
    verifyNoMoreInteractions(episodioService);
  }

  @BeforeEach
  void setUp() {
    episodioService = mock(EpisodioService.class);
    episodioController = new EpisodioController(episodioService);
  }

}