package Models;

/**
 * Representa a tipologia de um quarto.
 * <p>
 * A tipologia define as características gerais do quarto, como a sua
 * descrição e o respetivo preço semanal.
 * </p>
 */
public class Tipologia {

    /** Identificador único da tipologia */
    private int id;

    /** Descrição da tipologia do quarto */
    private String descricao;

    /** Preço semanal associado à tipologia */
    private double precoSemana;

    /**
     * Construtor da classe {@code Tipologia}.
     *
     * @param id identificador único da tipologia
     * @param descricao descrição da tipologia
     * @param precoSemana preço semanal do quarto
     */
    public Tipologia(int id, String descricao, double precoSemana) {
        this.id = id;
        this.descricao = descricao;
        this.precoSemana = precoSemana;
    }

    /**
     * Obtém o identificador da tipologia.
     *
     * @return identificador da tipologia
     */
    public int getId() {
        return id;
    }

    /**
     * Obtém a descrição da tipologia.
     *
     * @return descrição da tipologia
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Obtém o preço semanal associado à tipologia.
     *
     * @return preço semanal
     */
    public double getPrecoSemana() {
        return precoSemana;
    }
}
