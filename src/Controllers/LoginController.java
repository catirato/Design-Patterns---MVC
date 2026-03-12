package Controllers;

import Models.Utilizador;

import java.util.ArrayList;

/**
 * Controlador responsável pela autenticação de utilizadores.
 * <p>
 * Esta classe contém métodos que permitem validar as credenciais
 * de acesso de um utilizador ao sistema.
 * </p>
 */
public class LoginController {

    /**
     * Autentica um utilizador com base no nome de utilizador e palavra-passe.
     * <p>
     * O método percorre a lista de utilizadores registados e verifica
     * se existe algum utilizador cujas credenciais correspondam às
     * fornecidas.
     * </p>
     *
     * @param username nome de utilizador a autenticar
     * @param password palavra-passe associada ao utilizador
     * @param users lista de utilizadores registados no sistema
     * @return objeto {@link Utilizador} autenticado caso as credenciais
     *         sejam válidas, ou {@code null} caso contrário
     */
    public static Utilizador autenticar(
            String username,
            String password,
            ArrayList<Utilizador> users) {

        // Percorre todos os utilizadores registados
        for (Utilizador u : users) {
            if (u.getUsername().equals(username)
                    && u.getPassword().equals(password)) {
                return u;
            }
        }

        // Retorna null se as credenciais não forem válidas
        return null;
    }
}
