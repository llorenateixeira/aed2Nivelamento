package questao01;

import util.Elemento;
import util.Nodo;

public class PilhaDinamica<T extends Elemento> extends EstruturaDeDados<T> {

    private Nodo<T> topo;

    public PilhaDinamica() {
        topo = null;
    }

    @Override
    public void inserir(T dado) {
        // Inserir o dado no topo da pilha
        Nodo<T> novoNodo = new Nodo<>(dado, topo, null);
        topo = novoNodo;  // Atualiza o topo para o novo nodo
    }

    @Override
    public void buscar(int pos) {
        Nodo<T> atual = topo;
        // Busca o dado pela posição no topo da pilha
        while (atual != null) {
            if (atual.getDado().getPos() == pos) {
                System.out.println("Dado Buscado: " + atual.getDado().toString());
                return;
            }
            atual = atual.getDir();  // Move para o próximo nodo
        }
        System.out.println("Dado não encontrado na pilha.");
    }
    @Override
    public void remover(int pos) {
        if (topo == null) {
            System.out.println("Pilha vazia! Não há nada para remover.");
            return;
        }

        Nodo<T> atual = topo;
        Nodo<T> anterior = null;

        // Remover os elementos do topo até a posição fornecida
        while (atual != null) {
            T dadoRemovido = atual.getDado();

            // Remover o dado
            if (atual.getDado().getPos() == pos) {
                if (anterior != null) {
                    anterior.setDir(null);  // Desvincula o elemento anterior do topo removido
                } else {
                    topo = null;  // Se for o topo, limpa a pilha
                }

                System.out.println("Dado Removido: " + dadoRemovido);
                return;
            }

            anterior = atual;
            atual = atual.getDir();  // Avança para o próximo nodo
        }

        System.out.println("Dado não encontrado na pilha.");
    }

    @Override
    public void imprimir() {
        if (topo == null) {
            System.out.println("Pilha Vazia!");
            return;
        }

        System.out.println("Pilha (do topo para o fundo): ");
        imprimirRecursivo(topo);
    }

    private void imprimirRecursivo(Nodo<T> atual) {
        if (atual == null) {
            return;
        }
        imprimirRecursivo(atual.getDir());
        System.out.println(atual.getDado().toString());
    }
}
