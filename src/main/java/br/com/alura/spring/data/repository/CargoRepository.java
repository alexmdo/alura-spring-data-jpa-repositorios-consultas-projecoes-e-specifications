package br.com.alura.spring.data.repository;

import br.com.alura.spring.data.orm.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}