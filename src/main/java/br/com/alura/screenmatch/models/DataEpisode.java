package br.com.alura.screenmatch.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataEpisode(@JsonAlias("Title") String nome,
                          @JsonAlias("Episode") Integer episodio,
                          @JsonAlias("imdbRating") String avaliacao,
                          @JsonAlias("Released") String dataDeLancamento) {
}
