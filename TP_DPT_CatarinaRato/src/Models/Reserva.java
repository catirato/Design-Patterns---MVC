package Models;

/**
 * Representa uma reserva de um quarto efetuada por um cliente.
 * <p>
 * Uma reserva associa um cliente a um quarto específico, num determinado
 * período temporal definido por ano, mês e semana.
 * </p>
 */
public class Reserva {

    /** Identificador único da reserva */
    private String idReserva;

    /** Número do quarto reservado */
    private int numQuarto;

    /** Identificador do cliente que efetuou a reserva */
    private String idCliente;

    /** Ano da reserva */
    private int ano;

    /** Mês da reserva */
    private int mes;

    /** Semana da reserva dentro do mês */
    private int semana;

    /**
     * Construtor da classe {@code Reserva}.
     *
     * @param idReserva identificador único da reserva
     * @param numQuarto número do quarto reservado
     * @param idCliente identificador do cliente
     * @param ano ano em que a reserva é efetuada
     * @param mes mês em que a reserva é efetuada
     * @param semana semana da reserva
     */
    public Reserva(String idReserva, int numQuarto, String idCliente,
                   int ano, int mes, int semana) {

        this.idReserva = idReserva;
        this.numQuarto = numQuarto;
        this.idCliente = idCliente;
        this.ano = ano;
        this.mes = mes;
        this.semana = semana;
    }

    /**
     * Obtém o identificador da reserva.
     *
     * @return identificador da reserva
     */
    public String getIdReserva() {
        return idReserva;
    }

    /**
     * Obtém o número do quarto reservado.
     *
     * @return número do quarto
     */
    public int getNumQuarto() {
        return numQuarto;
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
     * Obtém o ano da reserva.
     *
     * @return ano da reserva
     */
    public int getAno() {
        return ano;
    }

    /**
     * Obtém o mês da reserva.
     *
     * @return mês da reserva
     */
    public int getMes() {
        return mes;
    }

    /**
     * Obtém a semana da reserva.
     *
     * @return semana da reserva
     */
    public int getSemana() {
        return semana;
    }
}
