package br.com.projeto.interfaces.generico;

import br.com.projeto.interfaces.Persistence;

import java.util.Collection;

public interface IGenericoDao<T extends Persistence>{
    Boolean cadastrarT(T entidade);
    T buscarT(Long codigo);
    Boolean excluirT(Long codigo);
    Collection<T> buscarTodosOsTs();
}
