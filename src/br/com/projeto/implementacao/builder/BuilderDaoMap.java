package br.com.projeto.implementacao.builder;

import br.com.projeto.entidades.Veiculo;
import br.com.projeto.entidades.carros.*;

public class BuilderDaoMap {

    public Veiculo criarSiena() {
        return new SienaBuilder().criarCarro();
    }

    public Veiculo criarUno() {
        return new UnoBuilder().criarCarro();
    }

    public Veiculo criarSw4() {
        return new Sw4Builder().criarCarro();
    }

    public Veiculo criarCelta() {
        return new CeltaBuilder().criarCarro();
    }

    public Veiculo criarCorsa() {
        return new CorsaClassicBuilder().criarCarro();
    }

}
