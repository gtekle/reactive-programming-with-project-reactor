package com.dailycodebuffer.reactiveprogramming.services;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxAndMonoServiceTest {

    FluxAndMonoService fluxAndMonoService = new FluxAndMonoService();
    @Test
    void fruitsFlux() {
        var fruitsFlux = fluxAndMonoService.fruitsFlux();

        StepVerifier.create(fruitsFlux)
                .expectNext("Mango", "Orange", "Banana")
                .verifyComplete();
    }

    @Test
    void fruitsFluxMap() {
        var fruitsFlux = fluxAndMonoService.fruitsFluxMap();

        StepVerifier.create(fruitsFlux)
                .expectNext("MANGO", "ORANGE", "BANANA")
                .verifyComplete();
    }

    @Test
    void fruitMono() {
        var fruitMono = fluxAndMonoService.fruitMono();

        StepVerifier.create(fruitMono)
                .expectNext("Mango")
                .verifyComplete();
    }
}