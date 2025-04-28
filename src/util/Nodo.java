package util;

public class Nodo<T> {
    private T dado;
    private Nodo<T> dir;
    private Nodo<T> esq;
    private int tamanhoSubArvore;


    public Nodo(T dado, Nodo<T> dir, Nodo<T> esq, int tamanhoSubArvore) {
        this.dado = dado;
        this.dir = dir;
        this.esq = esq;
        this.tamanhoSubArvore = tamanhoSubArvore;
    }


    public Nodo(T dado, Nodo<T> dir, Nodo<T> esq) {
        this(dado, dir, esq, 0);
    }


    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }


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
