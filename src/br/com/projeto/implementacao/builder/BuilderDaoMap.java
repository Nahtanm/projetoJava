package br.com.projeto.implementacao.builder;

import br.com.projeto.entidades.ModeloDoCarro;
import br.com.projeto.entidades.Veiculo;
import br.com.projeto.interfaces.builder.IBuilder;
import br.com.projeto.interfaces.builder.IBuilderGenerico;

public abstract class BuilderDaoMap<T extends IBuilder> implements IBuilderGenerico<T> {

    private IBuilder iBuilder;

    public BuilderDaoMap(IBuilder iBuilder){
        this.iBuilder = iBuilder;
    }

    @Override
    public Veiculo builder() {
        return veiculo;
    }
}
