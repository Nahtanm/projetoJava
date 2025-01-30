package br.com.projeto.interfaces.builder;

import br.com.projeto.entidades.ModeloDoCarro;
import br.com.projeto.entidades.Veiculo;

public interface IBuilderGenerico<T extends IBuilder> {

    Veiculo veiculo = new Veiculo();

    default Veiculo builder(){
        return veiculo;
    }

}
