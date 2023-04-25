package com.dailycodebuffer.reactiveprogramming.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoService {
    public Flux<String> fruitsFlux() {
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana")).log();
    }

    public Mono<String> fruitMono() {
        return Mono.just("Mango").log();
    }

    public static void main(String[] args) {
        FluxAndMonoService fluxAndMonoService = new FluxAndMonoService();

        fluxAndMonoService.fruitsFlux().subscribe(System.out::println);

        fluxAndMonoService.fruitMono().subscribe(fruit -> System.out.println("Mono: fruit = " + fruit));
    }
}
