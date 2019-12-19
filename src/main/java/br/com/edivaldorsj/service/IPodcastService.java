package br.com.edivaldorsj.service;

import br.com.edivaldorsj.model.Podcast;
import br.com.edivaldorsj.utils.exceptions.IdInvalidoException;
import java.util.List;

public interface IPodcastService {

  Podcast recuperarPorId(Long id) throws IdInvalidoException;

  Podcast recuperarPorNome(String nome);

  List<Podcast> recuperarTodos();

}
