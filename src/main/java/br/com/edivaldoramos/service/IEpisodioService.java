package br.com.edivaldoramos.service;

import br.com.edivaldoramos.model.Episodio;
import br.com.edivaldoramos.utils.exceptions.ParametroInvalidoException;
import java.util.List;

public interface IEpisodioService {

  List<Episodio> buscarEpisodiosPorIntegrantes(List<Long> idsIntegrantes) throws ParametroInvalidoException;

  Episodio buscarEpisodiosPorId(Long id);

  List<Episodio> buscarEpisodiosPorTema(String tema);

  List<Episodio> buscarTodos();

}
