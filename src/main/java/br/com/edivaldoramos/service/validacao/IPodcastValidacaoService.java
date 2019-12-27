package br.com.edivaldoramos.service.validacao;

import br.com.edivaldoramos.utils.exceptions.ParametroInvalidoException;

public interface IPodcastValidacaoService {

  void validarIdPodcast(Long id) throws ParametroInvalidoException;

  void validarNomePodcast(String nome) throws ParametroInvalidoException;

}
