package br.com.edivaldorsj.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Podcast {

  private Long           id;
  private LocalDate      dataCriacao;
  private String         descricao;
  private List<Episodio> episodios;
  private String         nome;

  public Podcast() {
    episodios = new ArrayList<>();
  }

}
