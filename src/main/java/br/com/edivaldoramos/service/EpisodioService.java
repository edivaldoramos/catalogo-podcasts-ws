package br.com.edivaldoramos.service;

import br.com.edivaldoramos.mapper.EpisodioMapper;
import br.com.edivaldoramos.model.Episodio;
import br.com.edivaldoramos.service.validacao.IEpisodioValidacaoService;
import br.com.edivaldoramos.utils.exceptions.ParametroInvalidoException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EpisodioService implements IEpisodioService {

  private final EpisodioMapper            episodioMapper;
  private final IEpisodioValidacaoService validacaoService;

  @Override
  public List<Episodio> buscarEpisodiosPorIntegrantes(List<Long> idsIntegrantes) throws ParametroInvalidoException {
    validacaoService.validarIdsIntegrantes(idsIntegrantes);

    List<Episodio> episodios = episodioMapper.buscarEpisodiosPorIntegrantes(idsIntegrantes);

    validacaoService.validarEpisodios(episodios);

    return episodios;
  }

  @Override
  public Episodio buscarEpisodiosPorId(Long id) {
    return episodioMapper.buscarPorId(id);
  }

  @Override
  public List<Episodio> buscarEpisodiosPorTema(String tema) {
    return episodioMapper.buscarPorTema(tema);
  }

  @Override
  public List<Episodio> buscarTodos() {
    return episodioMapper.buscarTodos();
  }

}
