package br.com.projeto.interfaces;

import br.com.projeto.entidades.Aluguel;
import br.com.projeto.entidades.Cliente;
import br.com.projeto.entidades.Veiculo;

import java.util.Collection;
import java.util.Date;

public interface IAluguelDao {
    void realizarAluguel(Cliente cliente, Veiculo veiculo, String dataFinal);
    Aluguel buscarAluguel(Long id);
}
