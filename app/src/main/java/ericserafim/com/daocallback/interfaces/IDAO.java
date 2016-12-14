package ericserafim.com.daocallback.interfaces;

public interface IDAO<E> {

    void incluir(E obj, IProcessoOuvinte processoOuvinte);
    void incluir(E obj);

    void alterar(E obj, IProcessoOuvinte processoOuvinte);
    void alterar(E obj);

    void excluir(E obj, IProcessoOuvinte processoOuvinte);
    void excluir(E obj);

}
