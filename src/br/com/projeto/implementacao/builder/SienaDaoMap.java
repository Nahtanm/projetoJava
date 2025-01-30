package br.com.projeto.implementacao.builder;

import br.com.projeto.entidades.ModeloDoCarro;
import br.com.projeto.entidades.Veiculo;
import br.com.projeto.entidades.carros.SienaBuilder;
import br.com.projeto.interfaces.builder.IBuilder;

public class SienaDaoMap implements IBuilder {
    @Override
    public Veiculo criarCarro() {
        return new Veiculo(1l,"Siena", ModeloDoCarro.SEDAN, "Fiat", true);
    }
}
