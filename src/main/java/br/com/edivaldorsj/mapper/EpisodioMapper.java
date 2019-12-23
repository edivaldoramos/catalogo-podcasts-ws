package br.com.edivaldorsj.mapper;

import br.com.edivaldorsj.model.Episodio;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EpisodioMapper {

  void atualizar(@Param("episodio") Episodio episodio);

  void deletar(@Param("episodio") Long id);

  void inserir(@Param("episodio") Episodio episodio);

  Episodio recuperarPorId(@Param("id") Long id);

  List<Episodio> recuperarTodos();

  List<Episodio> recuperarEpisodiosPorCombinacaoDeIntegrantes(@Param("idsIntegrantes") List<Long> idsIntegrantes);

}
