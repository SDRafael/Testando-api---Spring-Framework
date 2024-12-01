package br.com.alura.screenmatch.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
// integrando ao banco de dados e dando um nome
@Entity
@Table(name = "series")

public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // quando criada uma entidade para o bd, o JPA transforma os atributos da classe em campos do bd

    @Column(unique = true) // O Colum possui varias funcionalidades que permitem personalizar proprieadade de cada campo
    private String titulo;

    private Integer totalTemporadas;

    private Double avaliadoEm;

    private String atoresPrincipais;

    @Enumerated(EnumType.STRING)
    private Categoria genero;

    private String sinopse;

    private String poster;

    // a anotação abaixo permite que o atributo não seja representado no banco
    @OneToMany(mappedBy = "serie")
    private List<Episode> episodios = new ArrayList<>();

    // a JPA exige um construtor padrão para recuperar e representar dados do banco
    public Serie() {}

    public Serie(DataSerie dataSerie) {
        this.titulo = dataSerie.titulo();
        this.totalTemporadas = dataSerie.totalTemporadas();
        this.avaliadoEm = OptionalDouble.of(Double.valueOf(dataSerie.avaliadoEm())).orElse(0);
        this.genero = Categoria.fromString(dataSerie.genero().split(",")[0].trim());
        this.atoresPrincipais = dataSerie.atoresPrincipais();
        this.sinopse = dataSerie.sinopse();
        this.poster = dataSerie.poster();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
