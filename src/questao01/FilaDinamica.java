package questao01;

import util.Elemento;
import util.Nodo;

public class FilaDinamica<T extends Elemento> extends EstruturaDeDados<T> {

    private Nodo<T> inicio;
    private Nodo<T> fim;

    public FilaDinamica() {
        this.inicio = null;
        this.fim = null;
    }

    @Override
    public void inserir(T dado) {
        Nodo<T> novoNodo = new Nodo<T>(dado, null, null);
        if (fim == null) {
            inicio = novoNodo;
            fim = novoNodo;
        } else {
            fim.setDir(novoNodo);
            fim = novoNodo;
        }
    }

    @Override
    public void buscar(int chave) {
        Nodo<T> atual = inicio;
        while (atual != null) {
            if (atual.getDado().getPos() == chave) {
                System.out.println("Dado Buscado: " + atual.getDado().toString());
                return;
            }
            atual = atual.getDir();
        }
        System.out.println("Dado não encontrado na fila.");
    }
    @Override
    public void remover(int pos) {
        if (inicio == null) {
            System.out.println("Fila vazia! Não há nada para remover.");
            return;
        }

        Nodo<T> atual = inicio;
        int contador = 0;  // Para contar as posições da fila

        // Remover todos os itens até o item com a posição especificada (inclusive o item da posição)
        while (atual != null && atual.getDado().getPos() != pos) {
            T dadoRemovido = atual.getDado();

            // Se estamos removendo o primeiro elemento
            if (atual == inicio) {
                inicio = inicio.getDir();  // Avança o início da fila
                if (inicio == null) {  // Se a fila ficou vazia, também limpa o fim
                    fim = null;
                } else {
                    inicio.setEsq(null);  // Desvincula o ponteiro anterior do novo primeiro item
                }
            } else {
                // Caso contrário, remove o item no meio ou final da fila
                Nodo<T> anterior = atual.getEsq();
                Nodo<T> proximo = atual.getDir();
                if (anterior != null) {
                    anterior.setDir(proximo);  // Atualiza o próximo do anterior
                }
                if (proximo != null) {
                    proximo.setEsq(anterior);  // Atualiza o anterior do próximo
                }
                if (proximo == null) {  // Se for o último item da fila
                    fim = anterior;  // Atualiza o ponteiro fim
                }
            }

            System.out.println("Dado Removido: " + dadoRemovido);  // Imprime o dado removido
            atual = atual.getDir();  // Avança para o próximo nó
        }

        // Se encontramos o elemento com a posição igual ao fornecido, removemos ele também
        if (atual != null && atual.getDado().getPos() == pos) {
            T dadoRemovido = atual.getDado();

            // Se estamos removendo o primeiro elemento
            if (atual == inicio) {
                inicio = inicio.getDir();  // Avança o início da fila
                if (inicio == null) {  // Se a fila ficou vazia, também limpa o fim
                    fim = null;
                } else {
                    inicio.setEsq(null);  // Desvincula o ponteiro anterior do novo primeiro item
                }
            } else {
                // Caso contrário, remove o item no meio ou final da fila
                Nodo<T> anterior = atual.getEsq();
                Nodo<T> proximo = atual.getDir();
                if (anterior != null) {
                    anterior.setDir(proximo);  // Atualiza o próximo do anterior
                }
                if (proximo != null) {
                    proximo.setEsq(anterior);  // Atualiza o anterior do próximo
                }
                if (proximo == null) {  // Se for o último item da fila
                    fim = anterior;  // Atualiza o ponteiro fim
                }
            }

            System.out.println("Dado Removido: " + dadoRemovido);  // Imprime o dado removido
        } else {
            System.out.println("Elemento com a posição " + pos + " não encontrado.");
        }
    }

    @Override
    public void imprimir() {
        if (inicio == null) {
            System.out.println("Fila Vazia!");
            return;
        }
        Nodo<T> atual = inicio;
        System.out.println("Fila: ");
        while (atual != null) {
            System.out.println(atual.getDado().toString());
            atual = atual.getDir();
        }
    }
}
