import br.com.projeto.entidades.Cliente;
import br.com.projeto.entidades.Veiculo;
import br.com.projeto.implementacao.ClienteDaoMap;
import br.com.projeto.implementacao.GenericoDaoMap;
import br.com.projeto.implementacao.VeiculoDaoMap;
import br.com.projeto.implementacao.builder.BuilderDaoMap;
import br.com.projeto.interfaces.IClienteDao;
import br.com.projeto.interfaces.IVeiculoDao;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    private IClienteDao iClienteDao;
    private IVeiculoDao iVeiculoDao;
    private BuilderDaoMap builderDaoMap;

    public Aplicacao() {
        this.iClienteDao = new ClienteDaoMap();
        this.iVeiculoDao = new VeiculoDaoMap();
        this.builderDaoMap = new BuilderDaoMap();
        menu();
    }

    public void menu() {
        JOptionPane.showMessageDialog(null, "BEM VINDO A LOCABOA", "BEM VINDO", JOptionPane.INFORMATION_MESSAGE);

        String opcao = JOptionPane.showInputDialog(null, "1 - CADASTRAR  2 - BUSCAR \n3 - REALIZAR ALUGUEL  4 - VER CARROS DISPONIVEIS", "MENU", JOptionPane.INFORMATION_MESSAGE);

        while (opcao != "5") {

            opcao = JOptionPane.showInputDialog(null, "1 - CADASTRAR  2 - BUSCAR \n3 - REALIZAR ALUGUEL  4 - VER CARROS DISPONIVEIS", "MENU", JOptionPane.INFORMATION_MESSAGE);

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

                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida, tente outra vez!", "Opção inválida", JOptionPane.INFORMATION_MESSAGE);
            }

        }


    }

    private void verCarrosDisponiveis() {

    }

    private void realizarAluguel() {

    }

    private void buscar() {

    }

    private void cadastrar() {
        String opcao = opcao();
        if(opcao.equals("1")){
            Cliente cliente = cadastrarCliente();
            iClienteDao.cadastrarT(cliente);
        }else if(opcao.equals("2")){

        }else{
            JOptionPane.showMessageDialog(null, "Opção inválida, tente outra vez!", "Opção inválida", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public String opcao(){
        String opcao = JOptionPane.showInputDialog(null, "1 - CLIENTE \n2 - VEICULO ", "OPÇÃO", JOptionPane.INFORMATION_MESSAGE);
        return opcao;
    }

    public Cliente cadastrarCliente(){
        String[] listaCliente = {"CPF", "NOME", "EMAIL", "TELEFONE"};
        List<String> strings = new ArrayList<>();
        for(String str : listaCliente){
            String opcao = JOptionPane.showInputDialog(null, str, "CADASTRO CLIENTE", JOptionPane.INFORMATION_MESSAGE);
            strings.add(opcao);
        }
        return new Cliente(Long.parseLong(strings.get(0)), strings.get(1), strings.get(2), strings.get(3), null);
    }

    public Veiculo cadastrarVeiculo() {
        String[] listaVeiculo = {"CODIGO", "NOME", "MODELO", "MARCA"};
        List<String> strings = new ArrayList<>();
        for (String str : listaVeiculo) {
            String opcao = JOptionPane.showInputDialog(null, str, "CADASTRO VEICULO", JOptionPane.INFORMATION_MESSAGE);
            strings.add(opcao);
        }
        return new Veiculo() ;
    }
}
