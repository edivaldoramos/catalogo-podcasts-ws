package br.com.edivaldoramos.controller;

import br.com.edivaldoramos.mapper.EpisodioMapper;
import br.com.edivaldoramos.model.Episodio;
import br.com.edivaldoramos.service.EpisodioService;
import br.com.edivaldoramos.service.IEpisodioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class EpisodioControllerTest {

    private IEpisodioService episodioService;
    private EpisodioController episodioController;
    private EpisodioMapper episodioMapper;
    private MockMvc mockMvc;

    private Episodio novoEpisodio(Long id, String tema) {
        Episodio episodio = new Episodio();
        episodio.setId(id);
        episodio.setSequencia(2L);
        episodio.setDataPublicacao(LocalDate.of(2020, 1, 1));
        episodio.setTema(tema);
        episodio.setTitulo("Super-Homem: Herói americano ou do mundo?");
        return episodio;
    }

    @Test
    void deveRetornarJsonComDadosDoEpisodioDuranteABuscaPorId() throws Exception {
        Long id = 1L;
        Episodio episodio = novoEpisodio(id, "Quadrinhos");

        when(episodioMapper.buscarPorId(id)).thenReturn(episodio);

        mockMvc.perform(get("/episodios/{id}", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.tema").value("Quadrinhos"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.titulo").value("Super-Homem: Herói americano ou do mundo?"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sequencia").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dataPublicacao").isArray());
    }

    @Test
    void deveRetornarJsonComDadosDoEpisodioDuranteABuscaPorTema() throws Exception {
        String tema = "Quadrinhos";
        Episodio episodio = novoEpisodio(1L, tema);

        when(episodioMapper.buscarPorTema(tema)).thenReturn(Collections.singletonList(episodio));

        mockMvc.perform(get("/episodios", "1")
                .param("tema", "Quadrinhos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].tema").value("Quadrinhos"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].titulo").value("Super-Homem: Herói americano ou do mundo?"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].sequencia").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].dataPublicacao").isArray());
    }

    @BeforeEach
    void setUp() {
        episodioMapper = mock(EpisodioMapper.class);
        episodioService = new EpisodioService(episodioMapper, null);
        episodioController = new EpisodioController(episodioService);
        mockMvc = MockMvcBuilders.standaloneSetup(episodioController).build();
    }

}