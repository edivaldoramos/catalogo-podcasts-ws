package br.com.edivaldoramos.mapper;

import br.com.edivaldoramos.model.Podcast;
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

  Podcast buscarPorId(@Param("id") Long id);

  Podcast buscarPorNome(@Param("nome") String nome);

  List<Podcast> buscarTodos();

}
