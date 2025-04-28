package questao01;

import util.Elemento;
import util.Nodo;

public class ListaEncadeadaDupla<T> extends EstruturaDeDados<T> {

    private Nodo<T> inicio;
    private Nodo<T> fim;

    public ListaEncadeadaDupla() {
        inicio = null;
        fim = null;
    }

    @Override
    public void inserir(T dado) {
        if (dado == null) {
            System.out.println("Não é possível inserir um dado nulo.");
            return;
        }

        Nodo<T> novoNodo = new Nodo<>(dado, null, null);

        if (inicio == null) {
            inicio = novoNodo;
            fim = novoNodo;
        } else {
            fim.setDir(novoNodo);
            novoNodo.setEsq(fim);
            fim = novoNodo;
        }
    }

    @Override
    public void imprimir() {
        if (inicio == null) {
            System.out.println("Lista vazia");
            return;
        }

        Nodo<T> atual = inicio;
        while (atual != null) {
            if (atual.getDado() != null) {
                System.out.println(atual.getDado().toString());
            } else {
                System.out.println("Dado nulo encontrado");
            }
            atual = atual.getDir(); // move para o prox nodo
        }
    }

    @Override
    public void buscar(int pos) {
        if (inicio == null) {
            System.out.println("Lista vazia");
            return;
        }

        Nodo<T> atual = inicio;
        while (atual != null) {
            // verifica se o dado do nodo não é nulo antes de comparar
            if (atual.getDado() != null && ((Elemento) atual.getDado()).getPos() == pos) {
                System.out.println("Elemento encontrado: " + atual.getDado());
                return;
            }
            atual = atual.getDir();
        }
        System.out.println("Elemento não encontrado");
    }

    @Override
    public void remover(int pos) {
        if (inicio == null) {
            System.out.println("Lista vazia");
            return;
        }

        Nodo<T> atual = inicio;
        while (atual != null) {
            if (atual.getDado() != null && ((Elemento) atual.getDado()).getPos() == pos) {
                if (atual.getEsq() != null) {
                    atual.getEsq().setDir(atual.getDir());
                } else {
                    inicio = atual.getDir();
                }

                // atualiza o ponteiro da direita se o nodo não for o último
                if (atual.getDir() != null) {
                    atual.getDir().setEsq(atual.getEsq());
                } else {
                    fim = atual.getEsq();
                }

                System.out.println("Elemento removido: " + atual.getDado());
                return;
            }
            atual = atual.getDir();
        }
        System.out.println("Elemento não encontrado para remoção.");
    }
}
