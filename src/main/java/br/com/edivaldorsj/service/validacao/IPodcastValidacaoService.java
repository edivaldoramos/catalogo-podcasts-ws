package br.com.edivaldorsj.service.validacao;

import br.com.edivaldorsj.utils.exceptions.ParametroInvalidoException;

public interface IPodcastValidacaoService {

  void validarIdPodcast(Long id) throws ParametroInvalidoException;

  void validarNomePodcast(String nome) throws ParametroInvalidoException;

}
