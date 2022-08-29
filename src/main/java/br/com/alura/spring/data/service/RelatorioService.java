package br.com.alura.spring.data.service;

import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Service
public class RelatorioService {

    private final FuncionarioRepository funcionarioRepository;

    public RelatorioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void iniciar(Scanner scanner) {
        boolean inRelatorio = true;

        while (inRelatorio) {
            System.out.println("Qual ação do relatório deseja executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Busca de funcionário pelo nome");
            System.out.println("2 - Busca de funcionário pelo nome, salario maior e data da contratação");
            System.out.println("3 - Busca de funcionário pela data da contratação");

            int acao = scanner.nextInt();

            switch (acao) {
                case 1 -> buscarFuncionarioPeloNome(scanner);
                case 2 -> buscarFuncionarioNomeSalarioMaiorData(scanner);
                case 3 -> buscarFuncionarioDataContratacao(scanner);
                default -> inRelatorio = false;
            }
        }
    }

    private void buscarFuncionarioPeloNome(Scanner scanner) {
        System.out.println("Qual nome deseja pesquisar?");
        String nome = scanner.next();

        funcionarioRepository.findByNome(nome).forEach(System.out::println);
    }

    private void buscarFuncionarioNomeSalarioMaiorData(Scanner scanner) {
        System.out.println("Qual nome deseja pesquisar?");
        String nome = scanner.next();

        System.out.println("Qual salário deseja pesquisar?");
        BigDecimal salario = BigDecimal.valueOf(scanner.nextDouble());

        System.out.println("Qual data deseja pesquisar?");
        LocalDate dataContratacao = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        funcionarioRepository
                .findByNomeSalarioMaiorDataContratacao(nome, salario, dataContratacao)
                .forEach(System.out::println);
    }

    private void buscarFuncionarioDataContratacao(Scanner scanner) {
        System.out.println("Qual data de contratação deseja pesquisar?");
        LocalDate dataContratacao = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        funcionarioRepository.findByDataContratacaoMaior(dataContratacao).forEach(System.out::println);
    }


}
