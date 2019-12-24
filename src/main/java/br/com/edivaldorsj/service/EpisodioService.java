package br.com.edivaldorsj.service;

import br.com.edivaldorsj.mapper.EpisodioMapper;
import br.com.edivaldorsj.model.Episodio;
import br.com.edivaldorsj.service.validacao.IEpisodioValidacaoService;
import br.com.edivaldorsj.utils.exceptions.ParametroInvalidoException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EpisodioService implements IEpisodioService {

  private final EpisodioMapper episodioMapper;
  private final IEpisodioValidacaoService validacaoService;

  @Override
  public List<Episodio> buscarEpisodiosPorCombinacaoDeIntegrantes(List<Long> idsIntegrantes) throws ParametroInvalidoException {
    validacaoService.validarIdsIntegrantes(idsIntegrantes);

    List<Episodio> episodios = episodioMapper.buscarEpisodiosPorCombinacaoDeIntegrantes(idsIntegrantes);

    validacaoService.validarEpisodios(episodios);

    return episodios;
  }

}
