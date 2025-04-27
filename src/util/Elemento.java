package util;

public class Elemento {
    private int numero;
    private String nome;
    private String bairro;
    private int pos;
    private int idade;

    // Construtor para Elemento com todos os campos
    public Elemento(String nome, String bairro, int pos, int idade) {
        this.nome = nome;
        this.bairro = bairro;
        this.pos = pos;
        this.idade = idade;
    }

    // Construtor para Elemento com número
    public Elemento(int numero) {
        this.numero = numero;
    }

    // Getters
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

    public int getNumero() {
        return numero;
    }

    // toString para imprimir os dados do Elemento
    @Override
    public String toString() {
        return Integer.toString(numero);  // Apenas imprimindo o número (ou "pos" se você quiser customizar)
    }
}
