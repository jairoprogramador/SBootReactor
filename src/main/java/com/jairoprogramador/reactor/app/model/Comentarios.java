package com.jairoprogramador.reactor.app.model;

import java.util.ArrayList;
import java.util.List;

public class Comentarios {
    private List<String> comentarios;

    public Comentarios() {
        this.comentarios = new ArrayList<>();
    }

    public void addComentario(String comentario){
        this.comentarios.add(comentario);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Comentarios{");
        sb.append("comentarios=").append(comentarios);
        sb.append('}');
        return sb.toString();
    }
}
