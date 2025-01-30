package br.com.projeto.implementacao;

import br.com.projeto.entidades.Veiculo;
import br.com.projeto.interfaces.IVeiculoDao;

public class VeiculoDaoMap extends GenericoDaoMap<Veiculo> implements IVeiculoDao {
    @Override
    public Class getNomeClasse() {
        return Veiculo.class;
    }
}
