package br.com.edivaldoramos.service;

import br.com.edivaldoramos.model.Podcast;
import br.com.edivaldoramos.utils.exceptions.ParametroInvalidoException;
import java.util.List;

public interface IPodcastService {

  Podcast buscarPorId(Long id) throws ParametroInvalidoException;

  Podcast buscarPorNome(String nome) throws ParametroInvalidoException;

  List<Podcast> buscarTodos();

}
