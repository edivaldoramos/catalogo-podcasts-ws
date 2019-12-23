package br.com.edivaldorsj.service;

import br.com.edivaldorsj.mapper.EpisodioMapper;
import br.com.edivaldorsj.model.Episodio;
import br.com.edivaldorsj.utils.exceptions.ParametroInvalidoException;
import br.com.edivaldorsj.utils.exceptions.RecursoNaoEncontradoException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EpisodioService implements IEpisodioService {

  private final EpisodioMapper episodioMapper;

  @Override
  public List<Episodio> recuperarEpisodiosPorCombinacaoDeIntegrantes(List<Long> idsIntegrantes) throws ParametroInvalidoException {
    if (idsIntegrantes.isEmpty()) {
      throw new ParametroInvalidoException("Os ids dos integrantes passados por parametro são inválidos");
    }

    List<Episodio> episodios = episodioMapper.recuperarEpisodiosPorCombinacaoDeIntegrantes(idsIntegrantes);

    if (episodios == null || episodios.isEmpty()){
      throw new RecursoNaoEncontradoException("Nenhum episodio encontrado para os integrantes passados por parametro");
    }

    return episodios;
  }

}
