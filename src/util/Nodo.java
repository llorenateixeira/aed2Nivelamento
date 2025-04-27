package util;

public class Nodo<T> {
    private T dado;           // Armazena o dado do tipo T
    private Nodo<T> dir;      // Referência para o próximo Nodo (direita)
    private Nodo<T> esq;      // Referência para o Nodo anterior (esquerda)
    private int tamanhoSubArvore;

    // Construtor do Nodo com dado, direções e tamanho da subárvore
    public Nodo(T dado, Nodo<T> dir, Nodo<T> esq, int tamanhoSubArvore) {
        this.dado = dado;
        this.dir = dir;
        this.esq = esq;
        this.tamanhoSubArvore = tamanhoSubArvore;
    }

    // Construtor simplificado
    public Nodo(T dado, Nodo<T> dir, Nodo<T> esq) {
        this(dado, dir, esq, 0);
    }

    // Getter e Setter para 'dado'
    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    // Getters e Setters para os nós da árvore
    public Nodo<T> getDir() {
        return dir;
    }

    public void setDir(Nodo<T> dir) {
        this.dir = dir;
    }

    public Nodo<T> getEsq() {
        return esq;
    }

    public void setEsq(Nodo<T> esq) {
        this.esq = esq;
    }

    public int getTamanhoSubArvore() {
        return tamanhoSubArvore;
    }

    public void setTamanhoSubArvore(int tamanhoSubArvore) {
        this.tamanhoSubArvore = tamanhoSubArvore;
    }
}
