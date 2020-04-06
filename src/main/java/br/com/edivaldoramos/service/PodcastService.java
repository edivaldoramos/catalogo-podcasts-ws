package br.com.edivaldoramos.service;

import br.com.edivaldoramos.mapper.PodcastMapper;
import br.com.edivaldoramos.model.Podcast;
import br.com.edivaldoramos.service.validacao.IPodcastValidacaoService;
import br.com.edivaldoramos.utils.exceptions.ParametroInvalidoException;
import br.com.edivaldoramos.utils.exceptions.RecursoNaoEncontradoException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PodcastService implements IPodcastService {

  private final PodcastMapper            podcastMapper;
  private final IPodcastValidacaoService validacaoService;

  @Override
  public Podcast buscarPorId(Long id) throws ParametroInvalidoException {
    validacaoService.validarIdPodcast(id);

    return Optional.ofNullable(podcastMapper.buscarPorId(id))
        .orElseThrow(() -> new RecursoNaoEncontradoException("Nenhum resultado para o id passado por parametro."));
  }

  @Override
  public Podcast buscarPorNome(String nome) throws ParametroInvalidoException {
    validacaoService.validarNomePodcast(nome);

    return Optional.ofNullable(podcastMapper.buscarPorNome(nome))
        .orElseThrow(() -> new RecursoNaoEncontradoException("Nenhum resultado para o nome passado por parametro."));
  }

  @Override
  public List<Podcast> buscarTodos() {
    return podcastMapper.buscarTodos();
  }

}
