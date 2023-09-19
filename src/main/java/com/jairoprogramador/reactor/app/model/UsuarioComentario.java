package com.jairoprogramador.reactor.app.model;

public class UsuarioComentario {
    private Usuario usuario;
    private Comentarios comentarios;

    public UsuarioComentario(Usuario usuario, Comentarios comentarios) {
        this.usuario = usuario;
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UsuarioComentario{");
        sb.append("usuario=").append(usuario);
        sb.append(", comentarios=").append(comentarios);
        sb.append('}');
        return sb.toString();
    }
}
