package br.com.edivaldorsj.service.validacao;

import br.com.edivaldorsj.utils.exceptions.ParametroInvalidoException;
import org.springframework.stereotype.Service;

@Service
public class PodcastValidacaoService implements IPodcastValidacaoService {

  @Override
  public void validarNomePodcast(String nome) throws ParametroInvalidoException {
    if (nome == null || nome.isEmpty()) {
      throw new ParametroInvalidoException("Nome do podcast passado por parametro é inválido.");
    }
  }

  @Override
  public void validarIdPodcast(Long id) throws ParametroInvalidoException {
    if (id == null || id <= 0L) {
      throw new ParametroInvalidoException("Id do podcast passado por parametro é inválido.");
    }
  }

}
