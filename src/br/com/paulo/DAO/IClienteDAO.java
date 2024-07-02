package br.com.paulo.DAO;

import br.com.paulo.domain.Cliente;

import java.util.Collection;

public interface IClienteDAO {
    public boolean cadastro(Cliente cliente);

    public void excluir(Long cpf);

    public void alterar(Cliente cliente);

    public Cliente consultar(Long cpf);

    public Collection<Cliente> buscaTodos();
}
