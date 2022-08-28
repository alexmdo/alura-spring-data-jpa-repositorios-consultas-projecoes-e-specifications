package br.com.alura.spring.data;

import br.com.alura.spring.data.service.CargoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class AluraSpringDataJpaRepositoriosConsultasProjecoesESpecificationsApplication implements CommandLineRunner {
    private final CargoService cargoService;

    public AluraSpringDataJpaRepositoriosConsultasProjecoesESpecificationsApplication(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AluraSpringDataJpaRepositoriosConsultasProjecoesESpecificationsApplication.class, args);
    }

    @Override
    public void run(String... args) {
        boolean inApp = true;

        Scanner scanner = new Scanner(System.in);
        while (inApp) {
            System.out.println("QUal ação você quer executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Cargo");

            int acao = scanner.nextInt();
            if (acao == 1) {
                cargoService.iniciar(scanner);
            } else {
                inApp = false;
            }
        }

    }
}
