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
        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Andres", "Valle"),
                new Usuario("Daniel", "Jimenez"),
                new Usuario("Pedro", "Saavedra"),
                new Usuario("Miguel", "Montes"),
                new Usuario("Jose", "Chang"),
                new Usuario("Daniel Juan", "Ortiz"),
                new Usuario("Pedro Yonatan", "Torres"));

        Flux.fromIterable(usuarios)
                .map(usuario -> usuario.toString())
                .flatMap(nombre -> {
                    if(nombre.contains("Daniel")){
                        return Mono.just(nombre);
                    }
                    return Mono.empty();
                })
                .subscribe(usuario -> log.info(usuario.toString())
                );
    }
}
