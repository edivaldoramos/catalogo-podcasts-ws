package br.com.edivaldoramos.service.validacao;

import br.com.edivaldoramos.model.Episodio;
import br.com.edivaldoramos.utils.exceptions.ParametroInvalidoException;
import br.com.edivaldoramos.utils.exceptions.RecursoNaoEncontradoException;
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
