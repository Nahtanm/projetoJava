import br.com.projeto.entidades.Cliente;
import br.com.projeto.entidades.ModeloDoCarro;
import br.com.projeto.entidades.Veiculo;
import br.com.projeto.implementacao.ClienteDaoMap;
import br.com.projeto.implementacao.VeiculoDaoMap;
import br.com.projeto.implementacao.builder.BuilderDaoMap;
import br.com.projeto.interfaces.IClienteDao;
import br.com.projeto.interfaces.IVeiculoDao;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(12345678901L, "João Silva", "joao.silva@example.com", "11987654321", null);
        Cliente cliente2 = new Cliente(98765432109L, "Maria Oliveira", "maria.oliveira@example.com", "21912345678", null);
        Cliente cliente3 = new Cliente(45678912345L, "Carlos Souza", "carlos.souza@example.com", "31987654321", null);
        Cliente cliente4 = new Cliente(32165498701L, "Ana Costa", "ana.costa@example.com", "41912345678", null);
        Cliente cliente5 = new Cliente(65412398709L, "Pedro Rocha", "pedro.rocha@example.com", "51987654321", null);

        IClienteDao iClienteDao = new ClienteDaoMap();
        IVeiculoDao iVeiculoDao = new VeiculoDaoMap();
        BuilderDaoMap builderDaoMap = new BuilderDaoMap();

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

        System.out.println(iClienteDao.buscarT(cliente1.getCodigo()));
        System.out.println(iClienteDao.buscarTodosOsTs());

        System.out.println(iVeiculoDao.buscarT(1l));
        System.out.println(iVeiculoDao.buscarTodosOsTs());


        Veiculo veiculo = builderDaoMap.criarSiena();

        System.out.println(veiculo);

    }
}