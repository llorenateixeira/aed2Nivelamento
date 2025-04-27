package questao01;

import util.Elemento;
import util.Nodo;

public class ArvoreBinaria <T extends Elemento >  extends EstruturaDeDados<T> {

    private Nodo<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    @Override
    public void inserir(T dado) {
        raiz = inserirRecursivamente(raiz, dado);
    }

    private Nodo<T> inserirRecursivamente(Nodo<T> nodo, T dado) {
        if (nodo == null) {
            return new Nodo<>(dado, null, null, 1);  // Cria um novo nodo se a posição for vazia
        }

        if (dado.getPos() < nodo.getDado().getPos()) {
            nodo.setEsq(inserirRecursivamente(nodo.getEsq(), dado));  // Inserir na subárvore esquerda
        } else if (dado.getPos() > nodo.getDado().getPos()) {
            nodo.setDir(inserirRecursivamente(nodo.getDir(), dado));  // Inserir na subárvore direita
        }

        // Atualiza o tamanho da subárvore
        nodo.setTamanhoSubArvore(1 + tamanhoSubArvore(nodo.getDir()) + tamanhoSubArvore(nodo.getEsq()));
        return nodo;
    }

    // Buscar um elemento pela chave
    @Override
    public void buscar(int chave) {
        buscarArvore(chave);
    }

    private void buscarArvore(int chave) {
        buscarRecursivamente(raiz, chave);
    }

    private Nodo<T> buscarRecursivamente(Nodo<T> nodo, int chave) {
        if (nodo == null) {
            return null;
        }

        if (chave == nodo.getDado().getPos()) {
            System.out.println("Dado Encontrado: " + nodo.getDado());
            return nodo;
        }

        return chave < nodo.getDado().getPos() ?
                buscarRecursivamente(nodo.getEsq(), chave) : buscarRecursivamente(nodo.getDir(), chave);
    }

    // Remover um elemento pela chave
    @Override
    public void remover(int pos) {
        raiz = removerRecursivamente(raiz, pos);
    }

    private Nodo<T> removerRecursivamente(Nodo<T> nodo, int pos) {
        if (nodo == null) {
            return null;
        }

        if (pos < nodo.getDado().getPos()) {
            nodo.setEsq(removerRecursivamente(nodo.getEsq(), pos));
        } else if (pos > nodo.getDado().getPos()) {
            nodo.setDir(removerRecursivamente(nodo.getDir(), pos));
        } else {
            if (nodo.getEsq() == null) {
                return nodo.getDir();
            } else if (nodo.getDir() == null) {
                return nodo.getEsq();
            } else {
                Nodo<T> sucessor = encontrarMenorValor(nodo.getDir());
                nodo.setDado(sucessor.getDado());
                nodo.setDir(removerRecursivamente(nodo.getDir(), sucessor.getDado().getPos()));
            }
        }

        nodo.setTamanhoSubArvore(1 + tamanhoSubArvore(nodo.getDir()) + tamanhoSubArvore(nodo.getEsq()));
        return nodo;
    }

    private Nodo<T> encontrarMenorValor(Nodo<T> nodo) {
        if (nodo.getEsq() == null) {
            return nodo;
        } else {
            return encontrarMenorValor(nodo.getEsq());
        }
    }

    // Imprimir a árvore em ordem
    @Override
    public void imprimir() {
        emOrdemRecursivamente(raiz);
    }

    private void emOrdemRecursivamente(Nodo<T> nodo) {
        if (nodo != null) {
            emOrdemRecursivamente(nodo.getEsq());
            System.out.println(nodo.getDado().toString());
            emOrdemRecursivamente(nodo.getDir());
        }
    }

    private int tamanhoSubArvore(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        } else {
            return nodo.getTamanhoSubArvore();
        }
    }
}
