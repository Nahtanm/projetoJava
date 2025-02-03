import br.com.projeto.implementacao.ClienteDaoMap;
import br.com.projeto.implementacao.VeiculoDaoMap;
import br.com.projeto.implementacao.builder.BuilderDaoMap;
import br.com.projeto.interfaces.IClienteDao;
import br.com.projeto.interfaces.IVeiculoDao;

import javax.swing.*;

public class Aplicacao {

    private IClienteDao iClienteDao;
    private IVeiculoDao iVeiculoDao;
    private BuilderDaoMap builderDaoMap;

    public Aplicacao() {
        this.iClienteDao = new ClienteDaoMap();
        this.iVeiculoDao = new VeiculoDaoMap();
        this.builderDaoMap = new BuilderDaoMap();
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


    }

}
