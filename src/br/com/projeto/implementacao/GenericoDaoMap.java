package br.com.projeto.implementacao;

import br.com.projeto.interfaces.Persistence;
import br.com.projeto.interfaces.generico.IGenericoDao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class GenericoDaoMap<T extends Persistence> implements IGenericoDao<T> {

    private Map<Class<T>, Map<Long, T>> classMap;
    private Map<Long, T> inMap;

    public GenericoDaoMap() {
        if (this.classMap == null) {
            this.classMap = new HashMap<>();
            this.inMap = this.classMap.get(getNomeClasse());
            if(this.inMap == null){
                this.inMap = new HashMap<>();
                this.classMap.put(getNomeClasse(),this.inMap);
            }
        }
    }

    public abstract Class getNomeClasse();

    @Override
    public Boolean cadastrarT(T entidade) {
        this.inMap = this.classMap.get(getNomeClasse());
        if(this.inMap.containsKey(entidade.getCodigo())){
            return false;
        }
        this.inMap.put(entidade.getCodigo(), entidade);
        this.classMap.put(getNomeClasse(),this.inMap);
        return true;
    }

    @Override
    public T buscarT(Long codigo) {
        this.inMap = this.classMap.get(getNomeClasse());
        T entidade = this.inMap.get(codigo);
        return entidade;
    }

    @Override
    public Boolean excluirT(Long codigo) {
        this.inMap = this.classMap.get(getNomeClasse());
        return this.inMap.remove(codigo, this.inMap.get(codigo));
    }

    @Override
    public Collection<T> buscarTodosOsTs() {
        return this.inMap.values();
    }
}
