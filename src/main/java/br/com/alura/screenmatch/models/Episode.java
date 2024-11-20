package br.com.alura.screenmatch.models;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episode {

    private Integer temporada;
    private String nome;
    private Integer episodio;
    private Double avaliacao;
    private LocalDate dataDeLancamento;

    public Episode(String numerotemporada, DataEpisode dataEpisode) {
        this.temporada = Integer.valueOf(numerotemporada);
        this.nome = dataEpisode.nome();
        this.episodio = dataEpisode.episodio();
        try {
            this.avaliacao = Double.valueOf(dataEpisode.avaliacao());

        }catch (NumberFormatException ex) {
            this.avaliacao = 0.0;
        }
        try {
            this.dataDeLancamento = LocalDate.parse(dataEpisode.dataDeLancamento());

        }catch (DateTimeParseException dt) {
            this.dataDeLancamento = null;
        }


    }


    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getEpisodio() {
        return episodio;
    }

    public void setEpisodio(Integer episodio) {
        this.episodio = episodio;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public LocalDate getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(LocalDate dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    @Override
    public String toString() {
        return "temporada=" + temporada +
                ", nome='" + nome + '\'' +
                ", episodio=" + episodio +
                ", avaliacao=" + avaliacao +
                ", dataDeLancamento=" + dataDeLancamento;
    }
}
