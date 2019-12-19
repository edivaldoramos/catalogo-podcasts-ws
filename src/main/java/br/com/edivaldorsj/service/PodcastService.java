package br.com.edivaldorsj.service;

import br.com.edivaldorsj.mapper.PodcastMapper;
import br.com.edivaldorsj.model.Podcast;
import br.com.edivaldorsj.utils.exceptions.IdInvalidoException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PodcastService implements IPodcastService {

  private final PodcastMapper podcastMapper;

  @Override
  public Podcast recuperarPorId(Long id) throws IdInvalidoException {
    if (id == null || id.equals(0L)) {
      throw new IdInvalidoException("Id inválido");
    }
    return podcastMapper.recuperarPorId(id);
  }

  @Override
  public Podcast recuperarPorNome(String nome) {
    return podcastMapper.recuperarPorNome(nome);
  }

  @Override
  public List<Podcast> recuperarTodos() {
    return podcastMapper.recuperarTodos();
  }

}
