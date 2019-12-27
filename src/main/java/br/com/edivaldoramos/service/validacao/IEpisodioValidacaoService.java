package br.com.edivaldoramos.service.validacao;

import br.com.edivaldoramos.model.Episodio;
import br.com.edivaldoramos.utils.exceptions.ParametroInvalidoException;
import java.util.List;

public interface IEpisodioValidacaoService {

  void validarEpisodios(List<Episodio> episodios);

  void validarIdsIntegrantes(List<Long> idsIntegrantes) throws ParametroInvalidoException;

}
