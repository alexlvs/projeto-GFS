class Movie {
    private String nome;
    private String descricao;

    public Movie(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getnome() {
        return nome;
    }

    public String getdescricao() {
        return descricao;
    }
}