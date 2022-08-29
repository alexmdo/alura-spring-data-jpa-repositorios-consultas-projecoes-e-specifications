package br.com.alura.spring.data.repository;

import br.com.alura.spring.data.orm.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findByNome(String nome);

    @Query("SELECT f FROM Funcionario f WHERE f.nome = :nome AND f.salario >= :salario AND f.dataContratacao = :dataContracao")
    List<Funcionario> findByNomeSalarioMaiorDataContratacao(String nome, BigDecimal salario, LocalDate dataContracao);

    @Query(value = "SELECT * FROM funcionario f WHERE f.data_contratacao >= :dataContratacao", nativeQuery = true)
    List<Funcionario> findByDataContratacaoMaior(LocalDate dataContratacao);

}