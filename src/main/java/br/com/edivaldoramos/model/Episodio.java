package br.com.edivaldoramos.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Episodio {

  private Long             id;
  private LocalDate        dataPublicacao;
  private String           descricao;
  private Integer          duracao;
  private List<Integrante> integrantes;
  private Podcast          podcast;
  private Long             sequencia;
  private String           tema;
  private String           titulo;

  public Episodio() {
    integrantes = new ArrayList<>();
  }

}
