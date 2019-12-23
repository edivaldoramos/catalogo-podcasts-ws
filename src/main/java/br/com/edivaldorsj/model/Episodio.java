package br.com.edivaldorsj.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class Episodio {

  private Long             id;
  private List<Integrante> integrantes;
  private LocalDate        dataPublicacao;
  private String           descricao;
  private Integer          duracao;
  private Podcast          podcast;
  private Long             sequencia;
  private String           tema;
  private String           titulo;

  public Episodio(){
    integrantes = new ArrayList<>();
  }

}
