package br.com.edivaldoramos.service;

import br.com.edivaldoramos.model.Podcast;
import br.com.edivaldoramos.utils.exceptions.ParametroInvalidoException;
import java.util.List;

public interface IPodcastService {

  Podcast recuperarPorId(Long id) throws ParametroInvalidoException;

  Podcast recuperarPorNome(String nome) throws ParametroInvalidoException;

  List<Podcast> recuperarTodos();

}
