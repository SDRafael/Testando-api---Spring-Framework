package br.com.alura.screenmatch.repository;

import br.com.alura.screenmatch.models.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

// para o jparepository, sempre é lançado a entidade e a chave primaria que está sendo trabalhada
public interface SerieRepository extends JpaRepository<Serie, Long> {
}
