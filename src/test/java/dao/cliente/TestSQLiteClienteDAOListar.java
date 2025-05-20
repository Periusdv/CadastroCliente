package dao.cliente;

import dao.DAOFactory;
import dao.Factory;
import entidade.Cliente;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSQLiteClienteDAOListar {
    
    @Test
    void testListarQuantidade() {
        DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
        ClienteDAO clientedao = factory.getClienteDAO();
        //objetos a serem testados
        Cliente cliente1 = new Cliente("1", "Joao", "11111111111");
        Cliente cliente2 = new Cliente("2", "Ana", "222222222222");
        
        clientedao.inserir(cliente1);
        clientedao.inserir(cliente2);
        
        int quantidadeEsperada = 2;
        
        int quantidadeRecuperada = clientedao.getLista().size();
        
        assertEquals(quantidadeEsperada, quantidadeRecuperada);
        //Excluindo objetos de teste
        clientedao.excluir(cliente1);
        clientedao.excluir(cliente2);
    }
    
    @Test
    void testListarDados() {
        DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
        ClienteDAO clientedao = factory.getClienteDAO();
        //objetos a serem testados
        Cliente cliente1 = new Cliente("1", "Joao", "11111111111");
        
        clientedao.inserir(cliente1);
        
        //Recuperação do objeto
        List clientes = clientedao.getLista();
        Cliente clienterecuperado = (Cliente)clientes.get(0);
        
        assertEquals(cliente1.getCliente_id(), clienterecuperado.getCliente_id());
        assertEquals(cliente1.getNome(), clienterecuperado.getNome());
        assertEquals(cliente1.getCPF(), clienterecuperado.getCPF());
        
        //Excluindo objetos teste
        clientedao.excluir(cliente1);
    }
}
