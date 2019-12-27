package br.com.edivaldoramos.db;

import br.com.edivaldoramos.mapper.CriadorTabelasMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
public class CriadorTabelasTest {

  @Autowired
  private CriadorTabelasMapper mapper;

  @Test
  void criarTodasAsTabelas() {
    mapper.criarTabelas();
  }

  @Test
  void povoarTodasAsTabelas() {
    mapper.povoarTabelas();
  }

}
