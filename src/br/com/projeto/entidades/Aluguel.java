package br.com.projeto.entidades;

import java.util.Objects;

public class Aluguel {

    private Cliente cliente;
    private Veiculo veiculo;

    public Aluguel(Veiculo veiculo, Cliente cliente) {
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    public Aluguel() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aluguel aluguel = (Aluguel) o;
        return Objects.equals(cliente, aluguel.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cliente);
    }

    @Override
    public String toString() {
        return "Aluguel{" +
                "cliente=" + cliente +
                ", veiculo=" + veiculo +
                '}';
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
