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
    void fruitsFluxConcatMap() {
        var fruitsFlux = fluxAndMonoService.fruitsFluxConcatMap();

        StepVerifier.create(fruitsFlux)
                .expectNextCount(17)
                .verifyComplete();
    }

    @Test
    void fruitsFluxTransform() {
        var fruitsFlux = fluxAndMonoService.fruitsFluxTransform(5);

        StepVerifier.create(fruitsFlux)
                .expectNext("Orange", "Banana")
                .verifyComplete();
    }

    @Test
    void fruitsFluxDefaultIfEmpty() {
        var fruitsFlux = fluxAndMonoService.fruitsFluxDefaultIfEmpty(10);

        StepVerifier.create(fruitsFlux)
                .expectNext("Default Fruit")
                .verifyComplete();
    }

    @Test
    void fruitsFluxTransformSwitchIfEmpty() {
        var fruitsFlux = fluxAndMonoService.fruitsFluxTransformSwitchIfEmpty(8);

        StepVerifier.create(fruitsFlux)
                .expectNext("Pineapple", "Jack Apple")
                .verifyComplete();
    }

    @Test
    void fruitsFluxConcat() {
        var fruitsFlux = fluxAndMonoService.fruitsFluxConcat().log();

        StepVerifier.create(fruitsFlux)
                .expectNext("Mango", "Orange", "Tomato", "Lemon")
                .verifyComplete();
    }

    @Test
    void fruitsFluxConcatWith() {
        var fruitsFlux = fluxAndMonoService.fruitsFluxConcatWith().log();

        StepVerifier.create(fruitsFlux)
                .expectNext("Mango", "Orange", "Tomato", "Lemon")
                .verifyComplete();
    }

    @Test
    void fruitsFluxMerge() {
        var fruitsFlux = fluxAndMonoService.fruitsFluxMerge().log();

        StepVerifier.create(fruitsFlux)
                .expectNext("Mango", "Tomato", "Orange", "Lemon")
                .verifyComplete();
    }

    @Test
    void fruitsFluxMergeWith() {
        var fruitsFlux = fluxAndMonoService.fruitsFluxMergeWith().log();

        StepVerifier.create(fruitsFlux)
                .expectNext("Mango", "Tomato", "Orange", "Lemon")
                .verifyComplete();
    }

    @Test
    void fruitsFluxMergeWithSequential() {
        var fruitsFlux = fluxAndMonoService.fruitsFluxMergeWithSequential().log();

        StepVerifier.create(fruitsFlux)
                .expectNext("Mango", "Orange", "Tomato", "Lemon")
                .verifyComplete();
    }

    @Test
    void fruitsFluxZip() {
        var fruitsFlux = fluxAndMonoService.fruitsFluxZip().log();

        StepVerifier.create(fruitsFlux)
                .expectNext("Mango Tomato", "Orange Lemon")
                .verifyComplete();
    }

    @Test
    void fruitsFluxZipWith() {
        var fruitsFlux = fluxAndMonoService.fruitsFluxZipWith().log();

        StepVerifier.create(fruitsFlux)
                .expectNext("Mango Tomato", "Orange Lemon")
                .verifyComplete();
    }

    @Test
    void fruitsFluxZipTuple() {
        var fruitsFlux = fluxAndMonoService.fruitsFluxZipTuple().log();

        StepVerifier.create(fruitsFlux)
                .expectNext("MangoTomatoPotato", "OrangeLemonBeans")
                .verifyComplete();
    }

    @Test
    void fruitsFluxOnErrorReturn() {
        var fruitsFlux = fluxAndMonoService.fruitsFluxOnErrorReturn().log();

        StepVerifier.create(fruitsFlux)
                .expectNext("Apple", "Mango", "Orange")
                .verifyComplete();
    }

    @Test
    void fruitsFluxOnErrorContinue() {
        var fruitsFlux = fluxAndMonoService.fruitsFluxOnErrorContinue().log();

        StepVerifier.create(fruitsFlux)
                .expectNext("APPLE", "ORANGE")
                .verifyComplete();
    }

    @Test
    void fruitsMonoConcatWith() {
        var fruitsFlux = fluxAndMonoService.fruitsMonoConcatWith().log();

        StepVerifier.create(fruitsFlux)
                .expectNext("Mango", "Tomato")
                .verifyComplete();
    }

    @Test
    void fruitsMonoZipWith() {
        var fruitMono = fluxAndMonoService.fruitsMonoZipWith().log();

        StepVerifier.create(fruitMono)
                .expectNext("MangoTomato")
                .verifyComplete();
    }

    @Test
    void fruitsFluxFilterDoOn() {
        var fruitsFlux = fluxAndMonoService.fruitsFluxFilterDoOn(5);

        StepVerifier.create(fruitsFlux)
                .expectNext("Orange", "Banana")
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

    @Test
    void fruitMonoFlatMapMany() {
        var fruitsFlux = fluxAndMonoService.fruitMonoFlatMapMany();

        StepVerifier.create(fruitsFlux)
                .expectNextCount(5)
                .verifyComplete();
    }
}