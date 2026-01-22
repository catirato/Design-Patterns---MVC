package Models;

/**
 * Representa uma venda de um bilhete para uma experiência.
 * <p>
 * Cada venda corresponde a um único bilhete, podendo ser destinada
 * a um adulto ou a uma criança, e está associada a uma experiência
 * específica e a um período temporal.
 * </p>
 */
public class Venda {

    /** Identificador único da venda */
    private String idVenda;

    /** Identificador da experiência associada à venda */
    private String idExperiencia;

    /** Tipo de cliente da venda ("adulto" ou "crianca") */
    private String tipoCliente;

    /** Ano em que a venda foi registada */
    private int ano;

    /** Mês em que a venda foi registada */
    private int mes;

    /**
     * Construtor da classe {@code Venda}.
     *
     * @param idVenda identificador único da venda
     * @param idExperiencia identificador da experiência
     * @param tipoCliente tipo de cliente ("adulto" ou "crianca")
     * @param ano ano da venda
     * @param mes mês da venda
     */
    public Venda(String idVenda, String idExperiencia,
                 String tipoCliente, int ano, int mes) {

        this.idVenda = idVenda;
        this.idExperiencia = idExperiencia;
        this.tipoCliente = tipoCliente;
        this.ano = ano;
        this.mes = mes;
    }

    /**
     * Obtém o identificador da venda.
     *
     * @return identificador da venda
     */
    public String getIdVenda() {
        return idVenda;
    }

    /**
     * Obtém o identificador da experiência associada à venda.
     *
     * @return identificador da experiência
     */
    public String getIdExperiencia() {
        return idExperiencia;
    }

    /**
     * Obtém o tipo de cliente da venda.
     *
     * @return tipo de cliente ("adulto" ou "crianca")
     */
    public String getTipoCliente() {
        return tipoCliente;
    }

    /**
     * Obtém o ano da venda.
     *
     * @return ano da venda
     */
    public int getAno() {
        return ano;
    }

    /**
     * Obtém o mês da venda.
     *
     * @return mês da venda
     */
    public int getMes() {
        return mes;
    }

    /**
     * Indica se a venda corresponde a um bilhete de adulto.
     *
     * @return {@code true} se o tipo de cliente for adulto,
     *         {@code false} caso contrário
     */
    public boolean isAdulto() {
        return tipoCliente.equalsIgnoreCase("adulto");
    }

    /**
     * Indica se a venda corresponde a um bilhete de criança.
     *
     * @return {@code true} se o tipo de cliente for criança,
     *         {@code false} caso contrário
     */
    public boolean isCrianca() {
        return tipoCliente.equalsIgnoreCase("crianca");
    }
}
