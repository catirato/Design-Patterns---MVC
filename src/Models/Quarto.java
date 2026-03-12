package Models;

/**
 * Representa um quarto disponível para reserva no sistema.
 * <p>
 * Cada quarto possui um número identificador, uma tipologia associada
 * (que define o preço e características) e um estado de disponibilidade.
 * </p>
 */
public class Quarto {

    /** Número identificador do quarto */
    private int numQuarto;

    /** Tipologia do quarto, responsável por definir o preço semanal */
    private Tipologia tipologia;

    /** Indica se o quarto se encontra disponível para reserva */
    private boolean disponivel;

    /**
     * Construtor da classe {@code Quarto}.
     *
     * @param numQuarto número identificador do quarto
     * @param tipologia tipologia do quarto
     * @param disponivel estado de disponibilidade do quarto
     */
    public Quarto(int numQuarto, Tipologia tipologia, boolean disponivel) {
        this.numQuarto = numQuarto;
        this.tipologia = tipologia;
        this.disponivel = disponivel;
    }

    /**
     * Obtém o número do quarto.
     *
     * @return número identificador do quarto
     */
    public int getNumQuarto() {
        return numQuarto;
    }

    /**
     * Obtém a tipologia do quarto.
     *
     * @return tipologia do quarto
     */
    public Tipologia getTipologia() {
        return tipologia;
    }

    /**
     * Obtém o preço semanal do quarto.
     * <p>
     * O preço é definido pela tipologia associada ao quarto.
     * </p>
     *
     * @return preço semanal do quarto
     */
    public double getPrecoSemana() {
        return tipologia.getPrecoSemana();
    }

    /**
     * Indica se o quarto está disponível para reserva.
     *
     * @return {@code true} se o quarto estiver disponível,
     *         {@code false} caso contrário
     */
    public boolean isDisponivel() {
        return disponivel;
    }
}
