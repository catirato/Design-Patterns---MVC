package Repositories;

import Models.Utilizador;
import Tools.CsvFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Repositório responsável pela gestão dos utilizadores do sistema.
 * <p>
 * Esta classe carrega os dados de autenticação dos utilizadores a partir
 * de um ficheiro CSV e disponibiliza acesso à lista de utilizadores registados.
 * </p>
 */
public class UsersRepository {

    /** Lista de utilizadores registados no sistema */
    private ArrayList<Utilizador> users;

    /**
     * Construtor da classe {@code UsersRepository}.
     * <p>
     * Lê os dados dos utilizadores a partir do ficheiro CSV
     * {@code files/logins.csv}.
     * </p>
     *
     * @throws FileNotFoundException caso o ficheiro CSV não seja encontrado
     */
    public UsersRepository() throws FileNotFoundException {
        this.users = CsvFileReader.readUsersCsvFile("files/logins.csv");
    }

    /**
     * Obtém a lista de utilizadores registados.
     *
     * @return lista de utilizadores
     */
    public ArrayList<Utilizador> getUsers() {
        return users;
    }
}
