package br.com.alura.spring.data;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraSpringDataJpaRepositoriosConsultasProjecoesESpecificationsApplication implements CommandLineRunner {

    private final CargoRepository cargoRepository;

    public AluraSpringDataJpaRepositoriosConsultasProjecoesESpecificationsApplication(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AluraSpringDataJpaRepositoriosConsultasProjecoesESpecificationsApplication.class, args);
    }

    @Override
    public void run(String... args) {
        cargoRepository.save(new Cargo("DESENVOLVEDOR DE SOFTWARE"));
    }
}
