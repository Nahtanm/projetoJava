package br.com.projeto.entidades;

import br.com.projeto.interfaces.Persistence;

import java.util.Objects;

public class Veiculo implements Persistence {

    private Long codigo;
    private String nome;
    private ModeloDoCarro modelo;
    private String marca;
    private Boolean estado;

    public Veiculo(Long codigo, String nome, ModeloDoCarro modelo, String marca, Boolean estado) {
        this.nome = nome;
        this.modelo = modelo;
        this.marca = marca;
        this.estado = estado;
        this.codigo = codigo;
    }

    public Veiculo() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(codigo, veiculo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", modelo=" + modelo +
                ", marca='" + marca + '\'' +
                ", estado=" + estado +
                "}\n";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ModeloDoCarro getModelo() {
        return modelo;
    }

    public void setModelo(ModeloDoCarro modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
}
