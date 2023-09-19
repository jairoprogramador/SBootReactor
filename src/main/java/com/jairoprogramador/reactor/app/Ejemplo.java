package com.jairoprogramador.reactor.app;

import com.jairoprogramador.reactor.app.model.Comentarios;
import com.jairoprogramador.reactor.app.model.Usuario;
import com.jairoprogramador.reactor.app.model.UsuarioComentario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class Ejemplo {

    private static final Logger log = LoggerFactory.getLogger(Ejemplo.class);
    public void execute(){
        Mono<Usuario> usuarioMono = Mono.fromCallable(()-> new Usuario("Daniel", "Valle"));
        Mono<Comentarios> comentariosMono = Mono.fromCallable(()->
            {
                Comentarios comentarios = new Comentarios();
                comentarios.addComentario("Hola");
                comentarios.addComentario("como estas");
                return comentarios;
            }
        );

        usuarioMono
                .flatMap(usuario -> comentariosMono.map( comentarios -> new UsuarioComentario(usuario,comentarios)))
                .subscribe(System.out::println);
    }
}
