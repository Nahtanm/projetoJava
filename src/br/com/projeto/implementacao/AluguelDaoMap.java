package br.com.projeto.implementacao;

import br.com.projeto.entidades.Aluguel;
import br.com.projeto.entidades.Cliente;
import br.com.projeto.entidades.Veiculo;
import br.com.projeto.interfaces.IAluguelDao;

import java.util.*;

public class AluguelDaoMap implements IAluguelDao {

    private Map<Long, Aluguel> mapAluguel;

    public AluguelDaoMap(){
        if(this.mapAluguel == null){
            this.mapAluguel = new HashMap<>();
        }
    }

    @Override
    public void realizarAluguel(Cliente cliente, Veiculo veiculo, String dataFinal) {
        if (veiculo.getEstado()){
            Aluguel aluguel = new Aluguel(veiculo, cliente, dataFinal);
            veiculo.setEstado(false);
            this.mapAluguel.put(cliente.getCodigo(), aluguel);
        }else {
            System.out.println("Carro indisponivel no momento");
        }
    }

    @Override
    public Aluguel buscarAluguel(Long id) {
        if(this.mapAluguel.containsKey(id)){
            return this.mapAluguel.get(id);
        }else{
            System.out.println("Aluguel não encotrado");
            return null;
        }
    }

}
