package br.com.edivaldoramos.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CriadorTabelasMapper {

  void criarTabelas();

  void povoarTabelas();

}
