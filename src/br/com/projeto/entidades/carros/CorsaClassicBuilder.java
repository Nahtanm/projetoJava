package br.com.projeto.entidades.carros;

import br.com.projeto.entidades.ModeloDoCarro;
import br.com.projeto.entidades.Veiculo;
import br.com.projeto.interfaces.builder.IBuilder;

public class CorsaClassicBuilder  extends Veiculo implements IBuilder {

    @Override
    public Veiculo criarCarro() {
        return new Veiculo(4l,"Corsa Classic", ModeloDoCarro.SEDAN, "GW", true);
    }
}

