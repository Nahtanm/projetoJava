package br.com.projeto.implementacao;

import br.com.projeto.entidades.Cliente;
import br.com.projeto.interfaces.IClienteDao;

public class ClienteDaoMap extends GenericoDaoMap<Cliente> implements IClienteDao {
    @Override
    public Class getNomeClasse() {
        return Cliente.class;
    }
}
