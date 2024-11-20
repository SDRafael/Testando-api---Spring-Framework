package br.com.alura.screenmatch.models;

import java.util.OptionalDouble;

public class Serie {
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliadoEm;
    private String atoresPrincipais;
    private Categoria genero;
    private String sinopse;
    private String poster;

    public Serie(DataSerie dataSerie) {
        this.titulo = dataSerie.titulo();
        this.totalTemporadas = dataSerie.totalTemporadas();
        this.avaliadoEm = OptionalDouble.of(Double.valueOf(dataSerie.avaliadoEm())).orElse(0);
        this.genero = Categoria.fromString(dataSerie.genero().split(",")[0].trim());
        this.atoresPrincipais = dataSerie.atoresPrincipais();
        this.sinopse = dataSerie.sinopse();
        this.poster = dataSerie.poster();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public Double getAvaliadoEm() {
        return avaliadoEm;
    }

    public void setAvaliadoEm(Double avaliadoEm) {
        this.avaliadoEm = avaliadoEm;
    }

    public String getAtoresPrincipais() {
        return atoresPrincipais;
    }

    public void setAtoresPrincipais(String atoresPrincipais) {
        this.atoresPrincipais = atoresPrincipais;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return  "genero=" + genero + '\''+
                 ", titulo='" + titulo + '\'' +
                ", totalTemporadas=" + totalTemporadas +
                ", avaliadoEm=" + avaliadoEm +
                ", atoresPrincipais='" + atoresPrincipais + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", poster='" + poster;
    }
}
