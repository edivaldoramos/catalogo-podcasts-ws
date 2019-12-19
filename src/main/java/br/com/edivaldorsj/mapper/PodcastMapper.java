package br.com.edivaldorsj.mapper;

import br.com.edivaldorsj.model.Podcast;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PodcastMapper {

  void atualizar(@Param("podcast") Podcast podcast);

  void deletar(@Param("id") Long id);

  void inserir(@Param("podcast") Podcast podcast);

  Podcast recuperarPorId(@Param("id") Long id);

  Podcast recuperarPorNome(@Param("nome") String nome);

  List<Podcast> recuperarTodos();

}
