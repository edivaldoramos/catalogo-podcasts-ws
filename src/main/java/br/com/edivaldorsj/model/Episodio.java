package br.com.edivaldorsj.model;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Episodio {
  private Long      id;
  private LocalDate dataPublicacao;
  private String    descricao;
  private Integer   duracao;
  private Podcast   podcast;
  private Long      sequencia;
  private String    tema;
  private String    titulo;
  private List<Integrante> convidados;
}
