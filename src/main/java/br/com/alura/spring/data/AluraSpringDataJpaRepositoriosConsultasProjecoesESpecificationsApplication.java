package br.com.alura.spring.data;

import br.com.alura.spring.data.service.CargoService;
import br.com.alura.spring.data.service.RelatorioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class AluraSpringDataJpaRepositoriosConsultasProjecoesESpecificationsApplication implements CommandLineRunner {
    private final CargoService cargoService;
    private final RelatorioService relatorioService;

    public AluraSpringDataJpaRepositoriosConsultasProjecoesESpecificationsApplication(CargoService cargoService, RelatorioService relatorioService) {
        this.cargoService = cargoService;
        this.relatorioService = relatorioService;
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
            System.out.println("2 - Relatórios");

            int acao = scanner.nextInt();
            switch (acao) {
                case 1 -> cargoService.iniciar(scanner);
                case 2 -> relatorioService.iniciar(scanner);
                default -> inApp = false;
            }
        }

    }
}
