package br.com.projeto.interfaces;

import br.com.projeto.entidades.Cliente;
import br.com.projeto.entidades.Veiculo;

public interface IAluguelDao {
    void realizarAluguel(Cliente cliente, Veiculo veiculo);
}
