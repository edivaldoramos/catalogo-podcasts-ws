package br.com.edivaldorsj.service.validacao;

import br.com.edivaldorsj.model.Episodio;
import br.com.edivaldorsj.utils.exceptions.ParametroInvalidoException;
import java.util.List;

public interface IEpisodioValidacaoService {

  void validarEpisodios(List<Episodio> episodios);

  void validarIdsIntegrantes(List<Long> idsIntegrantes) throws ParametroInvalidoException;

}
