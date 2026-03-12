package Repositories;

import Models.Cliente;
import Tools.CsvFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Repositório responsável pela gestão dos clientes do sistema.
 * <p>
 * Esta classe carrega os dados dos clientes a partir de um ficheiro CSV
 * e disponibiliza acesso à lista de clientes registados.
 * </p>
 */
public class ClienteRepository {

    /** Lista de clientes carregados no sistema */
    private ArrayList<Cliente> clientes;

    /**
     * Construtor da classe {@code ClienteRepository}.
     * <p>
     * Lê os dados dos clientes a partir do ficheiro CSV
     * {@code files/clientes.csv}.
     * </p>
     *
     * @throws FileNotFoundException caso o ficheiro CSV não seja encontrado
     */
    public ClienteRepository() throws FileNotFoundException {
        this.clientes = CsvFileReader.readClientesCsvFile("files/clientes.csv");
    }

    /**
     * Obtém a lista de clientes registados.
     *
     * @return lista de clientes
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}
