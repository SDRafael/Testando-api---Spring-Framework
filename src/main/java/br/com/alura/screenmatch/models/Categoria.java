package br.com.alura.screenmatch.models;




public enum Categoria {
    ACAO("Action"),
    COMEDIA("Comedy"),
    ROMANCE("Romance"),
    DRAMA("Drama"),
    CRIME("Crime"),
    DESCONHECIDA("Unknown");

    private String categoriaOmdb;

    Categoria(String categoriaOmdb){
        this.categoriaOmdb = categoriaOmdb;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        return DESCONHECIDA;
    }
}
