package br.com.edivaldorsj.service.validacao;

import br.com.edivaldorsj.model.Episodio;
import br.com.edivaldorsj.utils.exceptions.ParametroInvalidoException;
import br.com.edivaldorsj.utils.exceptions.RecursoNaoEncontradoException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EpisodioValidacaoService implements IEpisodioValidacaoService {

  @Override
  public void validarEpisodios(List<Episodio> episodios) {
    if (episodios == null || episodios.isEmpty()) {
      throw new RecursoNaoEncontradoException("Nenhum episodio encontrado para os integrantes passados por parametro.");
    }
  }

  @Override
  public void validarIdsIntegrantes(List<Long> idsIntegrantes) throws ParametroInvalidoException {
    if (idsIntegrantes == null || idsIntegrantes.isEmpty()) {
      throw new ParametroInvalidoException("Os ids dos integrantes passados por parametro são inválidos.");
    }
  }

}
