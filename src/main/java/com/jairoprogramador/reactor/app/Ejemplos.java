package com.jairoprogramador.reactor.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Ejemplos {
    private static final Logger log = LoggerFactory.getLogger(Ejemplos.class);
    public void ejemplo01(){
        Flux<String> nombres = Flux.just("Andres", "Daniel", "Pedro", "Miguel", "Jose", "")
                .doOnNext( element -> {
                    if(element.isEmpty()){
                        throw new RuntimeException("Nombre no puede ser vacio");
                    }
                    System.out.println(element);
                });

        nombres.subscribe(
                log::info,
                error -> {
                    log.error(error.getMessage());
                },
                new Runnable() {
                    @Override
                    public void run() {
                        log.info("Ha finalizado la ejecucion con exito");
                    }
                });
    }
}
