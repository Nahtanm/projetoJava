package br.com.projeto.entidades;

import br.com.projeto.interfaces.Persistence;

import java.util.Objects;

public class Cliente implements Persistence {

    private Long cpf;
    private String nome;
    private String email;
    private String telefone;
    private Aluguel aluguel;

    public Cliente(Long cpf, String nome, String email, String telefone, Aluguel aluguel) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.aluguel = aluguel;
    }

    public Cliente() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf=" + cpf +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", aluguel=" + aluguel +
                '}';
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    @Override
    public Long getCodigo() {
        return cpf;
    }
}
