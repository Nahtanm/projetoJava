package br.com.projeto.entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Aluguel {

    private Cliente cliente;
    private Veiculo veiculo;
    private Date dataInicial;
    private Date dataFinal;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Aluguel(Veiculo veiculo, Cliente cliente, Date dataInicial, String dataFinal) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataInicial = dataInicial;
        try {
            this.dataFinal = simpleDateFormat.parse(dataFinal);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
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
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                ", simpleDateFormat=" + simpleDateFormat +
                '}';
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
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
