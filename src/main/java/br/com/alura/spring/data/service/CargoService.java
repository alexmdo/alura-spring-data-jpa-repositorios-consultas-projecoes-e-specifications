package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CargoService {

    private final CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void iniciar(Scanner scanner) {
        boolean inCargo = true;

        while (inCargo) {
            System.out.println("Qual ação do cargo deseja executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Deletar");

            int acao = scanner.nextInt();

            switch (acao) {
                case 1 -> salvar(scanner);
                case 2 -> atualizar(scanner);
                case 3 -> visualizar();
                case 4 -> deletar(scanner);
                default -> inCargo = false;
            }
        }
    }

    private void deletar(Scanner scanner) {
        System.out.println("Qual ID de cargo deseja excluir?");
        Long id = scanner.nextLong();
        cargoRepository.deleteById(id);
        System.out.println("Cargo excluido com sucesso!");
    }

    private void visualizar() {
        System.out.println("Segue a lista de cargos cadastrados!");
        List<Cargo> cargos = cargoRepository.findAll();
        cargos.forEach(System.out::println);
    }

    private void salvar(Scanner scanner) {
        System.out.println("Descrição do cargo");
        String descricao = scanner.next();
        Cargo cargo = new Cargo(descricao);
        cargoRepository.save(cargo);
        System.out.println("Cargo salvo com sucesso!");
    }

    public void atualizar(Scanner scanner) {
        System.out.println("Qual ID de cargo deseja alterar?");
        Long id = scanner.nextLong();
        Optional<Cargo> cargoOpt = cargoRepository.findById(id);
        if (cargoOpt.isPresent()) {
            Cargo cargo = cargoOpt.get();
            System.out.println("Cargo retornado da pesquisa: " + cargo);
            System.out.println("Digite a nova descrição");
            String descricao = scanner.next();
            cargo.setDescricao(descricao);
            cargoRepository.save(cargo);
            System.out.println("Cargo atualizado com sucesso!");
        }
    }

}
