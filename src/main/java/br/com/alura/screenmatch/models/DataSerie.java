package br.com.alura.screenmatch.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// Esse record não está sendo instanciado explicitamente pois o jackson faz isso sozinho
@JsonIgnoreProperties(ignoreUnknown = true)
public record DataSerie(@JsonAlias("Title") String titulo,
                        @JsonAlias("totalSeasons") Integer totalTemporadas,
                        @JsonAlias("imdbRating") Double avaliadoEm,
                        @JsonAlias("Actors") String atoresPrincipais,
                        @JsonAlias("Genre") String genero,
                        @JsonAlias("Plot") String sinopse,
                        @JsonAlias("Poster") String poster) {
}
