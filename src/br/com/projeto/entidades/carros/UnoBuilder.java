package br.com.projeto.entidades.carros;

import br.com.projeto.entidades.ModeloDoCarro;
import br.com.projeto.entidades.Veiculo;
import br.com.projeto.interfaces.builder.IBuilder;

public class UnoBuilder extends Veiculo implements IBuilder {

    @Override
    public Veiculo criarCarro() {
        return  new Veiculo(3l,"Uno", ModeloDoCarro.HATCH, "Fiat", true);
    }
}
