import br.com.projeto.entidades.Cliente;
import br.com.projeto.entidades.ModeloDoCarro;
import br.com.projeto.entidades.Veiculo;
import br.com.projeto.implementacao.ClienteDaoMap;
import br.com.projeto.implementacao.VeiculoDaoMap;
import br.com.projeto.interfaces.IClienteDao;
import br.com.projeto.interfaces.IVeiculoDao;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(12345678901L, "João Silva", "joao.silva@example.com", "11987654321", null);
        Cliente cliente2 = new Cliente(98765432109L, "Maria Oliveira", "maria.oliveira@example.com", "21912345678", null);
        Cliente cliente3 = new Cliente(45678912345L, "Carlos Souza", "carlos.souza@example.com", "31987654321", null);
        Cliente cliente4 = new Cliente(32165498701L, "Ana Costa", "ana.costa@example.com", "41912345678", null);
        Cliente cliente5 = new Cliente(65412398709L, "Pedro Rocha", "pedro.rocha@example.com", "51987654321", null);

        Veiculo veiculo1 = new Veiculo(1l,"Siena", ModeloDoCarro.SEDAN, "Fiat", true);
        Veiculo veiculo2 = new Veiculo(2l,"Celta", ModeloDoCarro.HATCH, "GW", true);
        Veiculo veiculo3 = new Veiculo(3l,"Uno", ModeloDoCarro.HATCH, "Fiat", true);
        Veiculo veiculo4 = new Veiculo(4l,"Corsa Classic", ModeloDoCarro.SEDAN, "GW", true);
        Veiculo veiculo5 = new Veiculo(5l,"SW4", ModeloDoCarro.SUV, "Toyota", true);

        IClienteDao iClienteDao = new ClienteDaoMap();
        IVeiculoDao iVeiculoDao = new VeiculoDaoMap();

        iClienteDao.cadastrarT(cliente1);
        iClienteDao.cadastrarT(cliente2);
        iClienteDao.cadastrarT(cliente3);
        iClienteDao.cadastrarT(cliente4);
        iClienteDao.cadastrarT(cliente5);

        iVeiculoDao.cadastrarT(veiculo1);
        iVeiculoDao.cadastrarT(veiculo2);
        iVeiculoDao.cadastrarT(veiculo3);
        iVeiculoDao.cadastrarT(veiculo4);
        iVeiculoDao.cadastrarT(veiculo5);

        System.out.println(iClienteDao.buscarT(cliente1.getCodigo()));
        System.out.println(iClienteDao.buscarTodosOsTs());

        System.out.println(iVeiculoDao.buscarT(veiculo1.getCodigo()));
        System.out.println(iVeiculoDao.buscarTodosOsTs());
    }
}