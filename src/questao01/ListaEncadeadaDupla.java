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
        // Verifica se dado é nulo
        if (dado == null) {
            System.out.println("Não é possível inserir um dado nulo.");
            return;
        }

        Nodo<T> novoNodo = new Nodo<>(dado, null, null);

        if (inicio == null) {
            // Se a lista estiver vazia, o novo nodo será o início e o fim da lista
            inicio = novoNodo;
            fim = novoNodo;
        } else {
            // Caso contrário, insere o novo nodo no final da lista
            fim.setDir(novoNodo); // O ponteiro "dir" do fim aponta para o novo nodo
            novoNodo.setEsq(fim); // O ponteiro "esq" do novo nodo aponta para o antigo fim
            fim = novoNodo; // O novo nodo se torna o fim da lista
        }
    }

    @Override
    public void imprimir() {
        if (inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }

        Nodo<T> atual = inicio;
        while (atual != null) {
            // Verifica se o dado não é nulo antes de tentar acessar
            if (atual.getDado() != null) {
                System.out.println(atual.getDado().toString());
            } else {
                System.out.println("Dado nulo encontrado.");
            }
            atual = atual.getDir(); // Move para o próximo nodo
        }
    }

    @Override
    public void buscar(int pos) {
        if (inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }

        Nodo<T> atual = inicio;
        while (atual != null) {
            // Verifica se o dado do nodo não é nulo antes de comparar
            if (atual.getDado() != null && ((Elemento) atual.getDado()).getPos() == pos) {
                System.out.println("Elemento encontrado: " + atual.getDado());
                return;
            }
            atual = atual.getDir();
        }
        System.out.println("Elemento não encontrado.");
    }

    @Override
    public void remover(int pos) {
        if (inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }

        Nodo<T> atual = inicio;
        while (atual != null) {
            // Verifica se o dado do nodo não é nulo antes de comparar
            if (atual.getDado() != null && ((Elemento) atual.getDado()).getPos() == pos) {
                // Atualiza o ponteiro da esquerda se o nodo não for o primeiro
                if (atual.getEsq() != null) {
                    atual.getEsq().setDir(atual.getDir());
                } else {
                    inicio = atual.getDir(); // Atualiza o início da lista se for o primeiro nodo
                }

                // Atualiza o ponteiro da direita se o nodo não for o último
                if (atual.getDir() != null) {
                    atual.getDir().setEsq(atual.getEsq());
                } else {
                    fim = atual.getEsq(); // Atualiza o fim da lista se for o último nodo
                }

                System.out.println("Elemento removido: " + atual.getDado());
                return;
            }
            atual = atual.getDir();
        }
        System.out.println("Elemento não encontrado para remoção.");
    }
}
