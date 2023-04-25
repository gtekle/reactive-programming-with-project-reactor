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
    void fruitsFluxFilter() {
        var fruitsFlux = fluxAndMonoService.fruitsFluxFilter(5);

        StepVerifier.create(fruitsFlux)
                .expectNext("Orange", "Banana")
                .verifyComplete();
    }

    @Test
    void fruitsFluxFilterAndMap() {
        var fruitsFlux = fluxAndMonoService.fruitsFluxFilterAndMap(5);

        StepVerifier.create(fruitsFlux)
                .expectNext("ORANGE", "BANANA")
                .verifyComplete();
    }

    @Test
    void fruitsFluxFlatMap() {
        var fruitsFlux = fluxAndMonoService.fruitsFluxFlatMap();

        StepVerifier.create(fruitsFlux)
                .expectNextCount(17)
                .verifyComplete();
    }

    @Test
    void fruitsFluxFlatMapAsync() {
        var fruitsFlux = fluxAndMonoService.fruitsFluxFlatMapAsync();

        StepVerifier.create(fruitsFlux)
                .expectNextCount(17)
                .verifyComplete();
    }

    @Test
    void fruitMono() {
        var fruitMono = fluxAndMonoService.fruitMono();

        StepVerifier.create(fruitMono)
                .expectNext("Mango")
                .verifyComplete();
    }

    @Test
    void fruitMonoFlatMap() {
        var fruitMono = fluxAndMonoService.fruitMonoFlatMap();

        StepVerifier.create(fruitMono)
                .expectNextCount(1)
                .verifyComplete();
    }
}