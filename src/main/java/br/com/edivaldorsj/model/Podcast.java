package br.com.edivaldorsj.model;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Podcast {
  private Long      id;
  private LocalDate dataCriacao;
  private String    descricao;
  private String    nome;
}
