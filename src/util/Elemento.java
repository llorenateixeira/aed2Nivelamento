package util;

public class Elemento {
    private String nome;
    private String bairro;
    private int pos;
    private int idade;

    // Construtor com parâmetros
    public Elemento(String nome, String bairro, int pos, int idade) {
        this.nome = nome;
        this.bairro = bairro;
        this.pos = pos;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getBairro() {
        return bairro;
    }

    public int getPos() {
        return pos;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Elemento{" +
                "nome='" + nome + '\'' +
                ", bairro='" + bairro + '\'' +
                ", pos=" + pos +
                ", idade=" + idade +
                '}';
    }
}

