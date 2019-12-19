package br.com.edivaldorsj.mapper;

import br.com.edivaldorsj.model.Integrante;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IntegranteMapper {

  void atualizar(@Param("integrante") Integrante integrante);

  void deletar(@Param("id") Long id);

  void inserir(@Param("integrante") Integrante integrante);

  Integrante recuperarPorId(@Param("id") Long id);

  List<Integrante> recuperarTodos();

}
