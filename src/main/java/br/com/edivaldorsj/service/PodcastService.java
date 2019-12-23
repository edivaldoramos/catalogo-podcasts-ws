package br.com.edivaldorsj.service;

import br.com.edivaldorsj.mapper.PodcastMapper;
import br.com.edivaldorsj.model.Podcast;
import br.com.edivaldorsj.utils.exceptions.ParametroInvalidoException;
import br.com.edivaldorsj.utils.exceptions.RecursoNaoEncontradoException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PodcastService implements IPodcastService {

  private final PodcastMapper podcastMapper;

  @Override
  public Podcast recuperarPorId(Long id) throws ParametroInvalidoException {
    if (id == null || id.equals(0L)) {
      throw new ParametroInvalidoException("Id do podcast passado por parametro é inválido");
    }
    Podcast podcast = podcastMapper.recuperarPorId(id);
    return Optional.ofNullable(podcast).orElseThrow(() -> new RecursoNaoEncontradoException("Nenhum resultado para o ID passado por parametro."));
  }

  @Override
  public Podcast recuperarPorNome(String nome) throws ParametroInvalidoException {
    if (nome.isEmpty()) {
      throw new ParametroInvalidoException("Nome inválido");
    }
    Podcast podcast = podcastMapper.recuperarPorNome(nome);
    return Optional.ofNullable(podcast).orElseThrow(() -> new RecursoNaoEncontradoException("Nenhum resultado para o NOME passado por parametro."));
  }

  @Override
  public List<Podcast> recuperarTodos() {
    return podcastMapper.recuperarTodos();
  }

}
