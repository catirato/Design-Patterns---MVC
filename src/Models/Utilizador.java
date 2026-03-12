package Models;

/**
 * Representa um utilizador do sistema.
 * <p>
 * Um utilizador possui credenciais de autenticação e um tipo que define
 * o seu perfil de acesso (por exemplo, administrador, guia ou cliente).
 * </p>
 */
public class Utilizador {

    /** Tipo de utilizador (ex.: administrador, guia, cliente) */
    private String tipo;

    /** Nome de utilizador usado para autenticação */
    private String username;

    /** Palavra-passe do utilizador */
    private String password;

    /**
     * Construtor da classe {@code Utilizador}.
     *
     * @param tipo tipo de utilizador
     * @param username nome de utilizador
     * @param password palavra-passe do utilizador
     */
    public Utilizador(String tipo, String username, String password) {
        this.tipo = tipo;
        this.username = username;
        this.password = password;
    }

    /**
     * Obtém o tipo de utilizador.
     *
     * @return tipo de utilizador
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtém o nome de utilizador.
     *
     * @return nome de utilizador
     */
    public String getUsername() {
        return username;
    }

    /**
     * Obtém a palavra-passe do utilizador.
     *
     * @return palavra-passe do utilizador
     */
    public String getPassword() {
        return password;
    }
}
