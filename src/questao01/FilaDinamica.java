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
        System.out.println("Dado não encontrado na fila");
    }
    @Override
    public void remover(int pos) {
        if (inicio == null) {
            System.out.println("Fila vazia! Não há nada para remover");
            return;
        }

        Nodo<T> atual = inicio;
        int contador = 0;


        while (atual != null && atual.getDado().getPos() != pos) {
            T dadoRemovido = atual.getDado();


            if (atual == inicio) {
                inicio = inicio.getDir();  // avança o início da fila
                if (inicio == null) {
                    fim = null;
                } else {
                    inicio.setEsq(null);  // desvincula o ponteiro anterior do novo primeiro item
                }
            } else {
                Nodo<T> anterior = atual.getEsq();
                Nodo<T> proximo = atual.getDir();
                if (anterior != null) {
                    anterior.setDir(proximo);
                }
                if (proximo != null) {
                    proximo.setEsq(anterior);
                }
                if (proximo == null) {
                    fim = anterior;  // atualiza o ponteiro fim
                }
            }

            System.out.println("Dado Removido: " + dadoRemovido);
            atual = atual.getDir();
        }

        // se encontrar o elemento com a posição igual ao fornecido removemos ele também
        if (atual != null && atual.getDado().getPos() == pos) {
            T dadoRemovido = atual.getDado();


            if (atual == inicio) {
                inicio = inicio.getDir();
                if (inicio == null) {
                    fim = null;
                } else {
                    inicio.setEsq(null);
                }
            } else {
                Nodo<T> anterior = atual.getEsq();
                Nodo<T> proximo = atual.getDir();
                if (anterior != null) {
                    anterior.setDir(proximo);  // atualiza o próximo do anterior
                }
                if (proximo != null) {
                    proximo.setEsq(anterior);  // atualiza o anterior do próximo
                }
                if (proximo == null) {
                    fim = anterior;
                }
            }

            System.out.println("Dado Removido: " + dadoRemovido);  // imprime o dado removido
        } else {
            System.out.println("Elemento com a posição " + pos + " não encontrado");
        }
    }

    @Override
    public void imprimir() {
        if (inicio == null) {
            System.out.println("Fila Vazia");
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
