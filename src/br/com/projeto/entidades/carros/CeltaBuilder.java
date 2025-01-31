package br.com.projeto.entidades.carros;

import br.com.projeto.entidades.ModeloDoCarro;
import br.com.projeto.entidades.Veiculo;
import br.com.projeto.interfaces.builder.IBuilder;

public class CeltaBuilder extends Veiculo implements IBuilder {

    @Override
    public Veiculo criarCarro() {
        return new Veiculo(2l,"Celta", ModeloDoCarro.HATCH, "GW", true);
    }
}

