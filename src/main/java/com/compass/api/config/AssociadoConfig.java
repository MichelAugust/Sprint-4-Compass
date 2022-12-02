package com.compass.api.config;

import com.compass.api.domain.Associado;
import com.compass.api.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static com.compass.api.enums.CargoPolitico.PREFEITO;
import static com.compass.api.enums.Sexo.MASCULINO;

@Configuration
@Profile("test")
public class AssociadoConfig implements CommandLineRunner {

    @Autowired
    private AssociadoRepository associadoRepository;

    @Override
    public void run(String... args) throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        Associado a1 = new Associado(null, "Fulano", PREFEITO, LocalDateTime.parse
                ("01/01/2000 12:00", formatter), MASCULINO);

        associadoRepository.saveAll(Arrays.asList(a1));

    }

}