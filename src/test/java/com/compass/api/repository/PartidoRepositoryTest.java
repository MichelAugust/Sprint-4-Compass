package com.compass.api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class PartidoRepositoryTest {
    @Autowired
    private PartidoRepository partidoRepository;
    @Test
    void test(){

    }

}