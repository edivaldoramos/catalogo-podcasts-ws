package br.com.edivaldorsj.service;

import br.com.edivaldorsj.model.Podcast;
import br.com.edivaldorsj.utils.exceptions.ParametroInvalidoException;
import java.util.List;

public interface IPodcastService {

  Podcast recuperarPorId(Long id) throws ParametroInvalidoException;

  Podcast recuperarPorNome(String nome) throws ParametroInvalidoException;

  List<Podcast> recuperarTodos();

}
