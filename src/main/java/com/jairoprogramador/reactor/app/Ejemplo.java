package com.jairoprogramador.reactor.app;

import com.jairoprogramador.reactor.app.model.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class Ejemplo {

    private static final Logger log = LoggerFactory.getLogger(Ejemplo.class);
    public void execute(){
        List<String> nombresList = Arrays.asList("Andres", "Daniel", "Pedro", "Miguel", "Jose", "Daniel Juan", "Pedro Yonatan");

        Flux.fromIterable(nombresList)
                .map(nombre -> new Usuario(nombre.toUpperCase(), null))
                .flatMap(usuario -> {
                    if(usuario.getNombre().contains("DANIEL")){
                        return Mono.just(usuario);
                    }
                    return Mono.empty();
                })
                .subscribe(usuario -> log.info(usuario.toString())
                );
    }
}
