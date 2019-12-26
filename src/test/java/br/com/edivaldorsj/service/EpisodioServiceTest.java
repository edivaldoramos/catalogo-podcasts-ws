package br.com.edivaldorsj.service;

import br.com.edivaldorsj.mapper.EpisodioMapper;
import br.com.edivaldorsj.service.validacao.EpisodioValidacaoService;
import br.com.edivaldorsj.service.validacao.IEpisodioValidacaoService;
import br.com.edivaldorsj.utils.exceptions.ParametroInvalidoException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class EpisodioServiceTest {

  private EpisodioMapper            episodioMapper;
  private IEpisodioService          episodioService;
  private IEpisodioValidacaoService validacaoService;

  @Test
  void deveInvocarMetodoDeEpisodioMapperUmaUnicaVez() throws ParametroInvalidoException {
    List<Long> ids = Arrays.asList(1L, 2L);
    episodioService.buscarEpisodiosPorIntegrantes(ids);
    verify(episodioMapper, times(1)).buscarEpisodiosPorIntegrantes(ids);
  }

  @Test
  void deveSeguirOrdemDefinidaDosMetodosDuranteAcaoDeBusca() throws ParametroInvalidoException {
    List<Long> ids = Arrays.asList(1L, 2L);

    episodioService.buscarEpisodiosPorIntegrantes(ids);

    InOrder ordemChamadas = inOrder(episodioMapper, validacaoService);
    ordemChamadas.verify(validacaoService).validarIdsIntegrantes(ids);
    ordemChamadas.verify(episodioMapper).buscarEpisodiosPorIntegrantes(ids);
    ordemChamadas.verify(validacaoService).validarEpisodios(anyList());

    verifyNoMoreInteractions(episodioMapper);
    verifyNoMoreInteractions(validacaoService);
  }

  @BeforeEach
  void setUp() {
    episodioMapper = mock(EpisodioMapper.class);
    validacaoService = mock(EpisodioValidacaoService.class);
    episodioService = new EpisodioService(episodioMapper, validacaoService);
  }

}