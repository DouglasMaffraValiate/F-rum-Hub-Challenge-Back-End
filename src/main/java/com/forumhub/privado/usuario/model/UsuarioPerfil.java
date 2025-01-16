package com.forumhub.privado.usuario.model;

public enum UsuarioPerfil {
    UNKNOWN("", ""),
    ADMINISTRADOR("Administrador", "Administrator"),
    USUARIO("Usuário", "User"),
    MODERADOR("Moderador", "Moderator");

    private final String DESC_PTBR;
    private final String DESC_EN;

    UsuarioPerfil(String DESC_PTBR, String DESC_EN) {
        this.DESC_PTBR = DESC_PTBR;
        this.DESC_EN = DESC_EN;
    }

    public static UsuarioPerfil fromString(String text){
        if (text == null || text.isEmpty())return UNKNOWN;
        for (UsuarioPerfil usuarioPerfil : UsuarioPerfil.values()){
            if(usuarioPerfil.DESC_PTBR.equalsIgnoreCase(text) || usuarioPerfil.DESC_EN.equalsIgnoreCase(text)){
                return usuarioPerfil;
            }
        }
        throw new IllegalArgumentException("NENHUM TIPO DE USUARIO ENCONTRADO! INSIRA UM VALOR VÁLIDO.");
    }
}
