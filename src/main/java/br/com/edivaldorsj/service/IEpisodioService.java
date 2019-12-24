package br.com.edivaldorsj.service;

import br.com.edivaldorsj.model.Episodio;
import br.com.edivaldorsj.utils.exceptions.ParametroInvalidoException;
import java.util.List;

public interface IEpisodioService {

  List<Episodio> buscarEpisodiosPorCombinacaoDeIntegrantes(List<Long> idsIntegrantes) throws ParametroInvalidoException;

}
