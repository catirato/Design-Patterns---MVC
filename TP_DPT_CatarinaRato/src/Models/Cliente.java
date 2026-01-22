package Models;

/**
 * Representa um cliente do sistema.
 * <p>
 * Esta classe armazena a informação pessoal de um cliente, incluindo
 * identificação, nome, nacionalidade e contacto por email.
 * </p>
 */
public class Cliente {

    /** Identificador único do cliente */
    private String idCliente;

    /** Nome do cliente */
    private String nome;

    /** Nacionalidade do cliente */
    private String nacionalidade;

    /** Endereço de email do cliente */
    private String email;

    /**
     * Construtor da classe {@code Cliente}.
     *
     * @param idCliente identificador único do cliente
     * @param nome nome do cliente
     * @param nacionalidade nacionalidade do cliente
     * @param email endereço de email do cliente
     */
    public Cliente(String idCliente, String nome,
                   String nacionalidade, String email) {

        this.idCliente = idCliente;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.email = email;
    }

    /**
     * Obtém o identificador do cliente.
     *
     * @return identificador do cliente
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * Obtém o nome do cliente.
     *
     * @return nome do cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém a nacionalidade do cliente.
     *
     * @return nacionalidade do cliente
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * Obtém o endereço de email do cliente.
     *
     * @return email do cliente
     */
    public String getEmail() {
        return email;
    }
}
