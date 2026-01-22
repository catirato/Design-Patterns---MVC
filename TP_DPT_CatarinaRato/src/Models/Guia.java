package Models;

import java.util.ArrayList;

/**
 * Representa um guia responsável por experiências turísticas.
 * <p>
 * Esta classe armazena a informação básica do guia, bem como as
 * avaliações atribuídas pelos clientes às experiências que conduz.
 * </p>
 */
public class Guia {

    /** Identificador único do guia */
    private String id;

    /** Nome do guia */
    private String nome;

    /** Lista de avaliações atribuídas ao guia */
    private ArrayList<Integer> ratings;

    /**
     * Construtor da classe {@code Guia}.
     *
     * @param id identificador único do guia
     * @param nome nome do guia
     */
    public Guia(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.ratings = new ArrayList<>();
    }

    /**
     * Obtém o identificador do guia.
     *
     * @return identificador do guia
     */
    public String getId() {
        return id;
    }

    /**
     * Obtém o nome do guia.
     *
     * @return nome do guia
     */
    public String getNome() {
        return nome;
    }

    /**
     * Adiciona uma avaliação ao guia.
     *
     * @param rating valor da avaliação atribuída (por exemplo, de 1 a 5)
     */
    public void adicionarRating(int rating) {
        ratings.add(rating);
    }

    /**
     * Calcula o valor médio das avaliações do guia.
     * <p>
     * Caso o guia ainda não possua avaliações, o método devolve {@code 0}.
     * </p>
     *
     * @return média das avaliações do guia
     */
    public double getRatingMedio() {
        if (ratings.isEmpty()) return 0;
        return ratings.stream().mapToInt(Integer::intValue).average().orElse(0);
    }
}
