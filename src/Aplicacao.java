import br.com.projeto.entidades.Aluguel;
import br.com.projeto.entidades.Cliente;
import br.com.projeto.entidades.ModeloDoCarro;
import br.com.projeto.entidades.Veiculo;
import br.com.projeto.implementacao.AluguelDaoMap;
import br.com.projeto.implementacao.ClienteDaoMap;
import br.com.projeto.implementacao.VeiculoDaoMap;
import br.com.projeto.implementacao.builder.BuilderDaoMap;
import br.com.projeto.interfaces.IClienteDao;
import br.com.projeto.interfaces.IVeiculoDao;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Aplicacao {

    private IClienteDao iClienteDao;
    private IVeiculoDao iVeiculoDao;
    private BuilderDaoMap builderDaoMap;
    private AluguelDaoMap aluguelDaoMap;

    public Aplicacao() {
        this.iClienteDao = new ClienteDaoMap();
        this.iVeiculoDao = new VeiculoDaoMap();
        this.builderDaoMap = new BuilderDaoMap();
        this.aluguelDaoMap = new AluguelDaoMap();
        teste();
        menu();
    }

    public void menu() {
        JOptionPane.showMessageDialog(null, "BEM VINDO A LOCABOA", "BEM VINDO", JOptionPane.INFORMATION_MESSAGE);

        String opcao = "0";

        while (opcao != "5") {

            opcao = JOptionPane.showInputDialog(null, "1 - CADASTRAR  \n2 - BUSCAR \n3 - REALIZAR ALUGUEL  \n4 - VER CARROS DISPONIVEIS \n5 - BUSCAR ALUGUEIS \n6 - SAIR", "MENU", JOptionPane.INFORMATION_MESSAGE);

            switch (opcao) {
                case "1":
                    cadastrar();
                    break;
                case "2":
                    buscar();
                    break;
                case "3":
                    realizarAluguel();
                    break;
                case "4":
                    verCarrosDisponiveis();
                    break;
                case "5":
                    verAlugueisPorCliente();
                    break;
                case "6":
                    JOptionPane.showMessageDialog(null, "Saindo do aplicativo", "SAINDO", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(1);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida, tente outra vez!", "Opção inválida", JOptionPane.INFORMATION_MESSAGE);
            }

        }


    }

    private void verAlugueisPorCliente() {
        String usuarioCpf = JOptionPane.showInputDialog(null, "Informe o cpf do cliente a realizar a consulta", "CONSULTA", JOptionPane.INFORMATION_MESSAGE);

        Aluguel aluguel = aluguelDaoMap.buscarAluguel(Long.valueOf(usuarioCpf));

        JOptionPane.showMessageDialog(null, "Aluguel: " + aluguel, "CONSULTA", JOptionPane.INFORMATION_MESSAGE);

    }

    private void verCarrosDisponiveis() {
        HashMap<Long, Veiculo> collection = new HashMap<>();
        for (Veiculo vei : iVeiculoDao.buscarTodosOsTs()) {
            if (vei.getEstado()) {
                collection.put(vei.getCodigo(), vei);
            }
        }
        JOptionPane.showMessageDialog(null, collection.values(), "Veiculos disponiveis", JOptionPane.INFORMATION_MESSAGE);
    }

    private void realizarAluguel() {
        String usuarioCpf = JOptionPane.showInputDialog(null, "Informe o cpf do cliente a realizar o aluguel", "ALUGUEL", JOptionPane.INFORMATION_MESSAGE);
        Cliente cliente = null;
        Veiculo veiculo = null;
        if (iClienteDao.buscarT(Long.valueOf(usuarioCpf)) != null) {
            cliente = iClienteDao.buscarT(Long.valueOf(usuarioCpf));
        }

        verCarrosDisponiveis();
        String codigoVeiculo = JOptionPane.showInputDialog(null, "Informe o codigo do veiculo desejado", "ALUGUEL", JOptionPane.INFORMATION_MESSAGE);
        if (iVeiculoDao.buscarT(Long.valueOf(codigoVeiculo)) != null) {
            veiculo = iVeiculoDao.buscarT(Long.valueOf(codigoVeiculo));
        }

        String dataFinalDoAluguel = JOptionPane.showInputDialog(null, "Informe a data de devolução do veiculo (EX: 28/04/2001)", "ALUGUEL", JOptionPane.INFORMATION_MESSAGE);
        aluguelDaoMap.realizarAluguel(cliente, veiculo, dataFinalDoAluguel);
        JOptionPane.showMessageDialog(null, "Aluguel realizado com sucesso", "ALUGUEL", JOptionPane.INFORMATION_MESSAGE);
    }

    private void buscar() {
        String opcao = opcao();
        if (opcao.equals("1")) {
            String codigo = JOptionPane.showInputDialog(null, "Codigo do cliente", "CONSULTA", JOptionPane.INFORMATION_MESSAGE);
            Cliente cliente = iClienteDao.buscarT(Long.valueOf(codigo));
            JOptionPane.showMessageDialog(null, cliente + "\n", "CONSULTA", JOptionPane.INFORMATION_MESSAGE);

        } else if (opcao.equals("2")) {
            String codigo = JOptionPane.showInputDialog(null, "Codigo do veiculo", "CONSULTA", JOptionPane.INFORMATION_MESSAGE);
            Veiculo veiculo = iVeiculoDao.buscarT(Long.valueOf(codigo));
            JOptionPane.showMessageDialog(null, veiculo + "\n", "CONSULTA", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Opção inválida, tente outra vez!", "Opção inválida", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private Boolean cadastrar() {
        String opcao = opcao();
        if (opcao.equals("1")) {
            Cliente cliente = cadastrarCliente();
            if (!iClienteDao.cadastrarT(cliente)) {
                JOptionPane.showMessageDialog(null, "Veiculo já cadastrado!", "CADASTRO", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
            iClienteDao.cadastrarT(cliente);
        } else if (opcao.equals("2")) {
            Veiculo veiculo = cadastrarVeiculo();
            if (!iVeiculoDao.cadastrarT(veiculo)) {
                JOptionPane.showMessageDialog(null, "Veiculo já cadastrado!", "CADASTRO", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
            iVeiculoDao.cadastrarT(veiculo);
        } else {
            JOptionPane.showMessageDialog(null, "Opção inválida, tente outra vez!", "Opção inválida", JOptionPane.INFORMATION_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "CADASTRO", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    public String opcao() {
        String opcao = JOptionPane.showInputDialog(null, "1 - CLIENTE \n2 - VEICULO ", "OPÇÃO", JOptionPane.INFORMATION_MESSAGE);
        return opcao;
    }

    public Cliente cadastrarCliente() {
        String[] listaCliente = {"CPF", "NOME", "EMAIL", "TELEFONE"};
        List<String> strings = new ArrayList<>();
        for (String str : listaCliente) {
            String opcao = JOptionPane.showInputDialog(null, str, "CADASTRO CLIENTE", JOptionPane.INFORMATION_MESSAGE);
            strings.add(opcao);
        }
        return new Cliente(Long.parseLong(strings.get(0)), strings.get(1), strings.get(2), strings.get(3), null);
    }

    public Veiculo cadastrarVeiculo() {
        String[] listaVeiculo = {"CODIGO", "NOME", "MARCA"};
        List<String> strings = new ArrayList<>();
        for (String str : listaVeiculo) {
            String opcao = JOptionPane.showInputDialog(null, str, "CADASTRO VEICULO", JOptionPane.INFORMATION_MESSAGE);
            strings.add(opcao);
        }

        String opcao = JOptionPane.showInputDialog(null, "MODELO DO CARRO - SUV, HATCH, SEDAN", "CADASTRO VEICULO", JOptionPane.INFORMATION_MESSAGE);

        return new Veiculo(Long.valueOf(strings.get(0)), strings.get(1), ModeloDoCarro.valueOf(opcao), strings.get(2), true);
    }

    public void teste(){
        Cliente cliente1 = new Cliente(123L, "João Silva", "joao.silva@example.com", "11987654321", null);
        Cliente cliente2 = new Cliente(456L, "Maria Oliveira", "maria.oliveira@example.com", "21912345678", null);
        Cliente cliente3 = new Cliente(789L, "Carlos Souza", "carlos.souza@example.com", "31987654321", null);
        Cliente cliente4 = new Cliente(987L, "Ana Costa", "ana.costa@example.com", "41912345678", null);
        Cliente cliente5 = new Cliente(654L, "Pedro Rocha", "pedro.rocha@example.com", "51987654321", null);

        iClienteDao.cadastrarT(cliente1);
        iClienteDao.cadastrarT(cliente2);
        iClienteDao.cadastrarT(cliente3);
        iClienteDao.cadastrarT(cliente4);
        iClienteDao.cadastrarT(cliente5);

        iVeiculoDao.cadastrarT(builderDaoMap.criarSiena());
        iVeiculoDao.cadastrarT(builderDaoMap.criarCelta());
        iVeiculoDao.cadastrarT(builderDaoMap.criarCorsa());
        iVeiculoDao.cadastrarT(builderDaoMap.criarUno());
        iVeiculoDao.cadastrarT(builderDaoMap.criarSw4());
    }
}
