package com.jairoprogramador.reactor.app;

import com.jairoprogramador.reactor.app.model.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Ejemplo {

    private static final Logger log = LoggerFactory.getLogger(Ejemplo.class);
    public void execute(){
        Flux<String> nombres = Flux.just("Andres", "Daniel", "Pedro", "Miguel", "Jose", "Daniel Juan", "Pedro Yonatan");

        nombres.map(nombre -> new Usuario(nombre.toUpperCase(), null))
                .filter(usuario -> usuario.getNombre().contains("DANIEL"))
                .doOnNext( usuario -> {
                    if(usuario == null || usuario.getNombre().isEmpty()){
                        throw new RuntimeException("Usuario no puede ser null");
                    }
                    System.out.println(usuario);
                }).subscribe();

        nombres.subscribe(
                usuario -> log.info(usuario.toString()),
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
