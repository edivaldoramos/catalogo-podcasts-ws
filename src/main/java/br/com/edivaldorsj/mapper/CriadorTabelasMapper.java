package br.com.edivaldorsj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CriadorTabelasMapper {

  void criarTodasAsTabelas();

  void povoarTabelas();

}
