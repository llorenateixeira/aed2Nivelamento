package questao01;

import util.Elemento;

public abstract class EstruturaDeDados<T> {

    public abstract void inserir(T dado);
    public abstract void buscar(int pos);
    public abstract void remover(int pos);
    public abstract void imprimir();
}
