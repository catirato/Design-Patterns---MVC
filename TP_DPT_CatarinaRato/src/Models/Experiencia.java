package Models;

import java.util.ArrayList;

/**
 * Representa uma experiência turística disponível no sistema.
 * <p>
 * Cada experiência possui um identificador, um nome, preços distintos
 * para adultos e crianças, um guia responsável e uma lista de avaliações
 * efetuadas pelos clientes.
 * </p>
 */
public class Experiencia {

    /** Identificador único da experiência */
    private String id;

    /** Nome da experiência */
    private String nome;

    /** Preço do bilhete para adultos */
    private double precoAdulto;

    /** Preço do bilhete para crianças */
    private double precoCrianca;

    /** Guia responsável pela experiência */
    private Guia guia;



    /**
     * Construtor da classe {@code Experiencia}.
     *
     * @param id identificador único da experiência
     * @param nome nome da experiência
     * @param precoAdulto preço do bilhete de adulto
     * @param precoCrianca preço do bilhete de criança
     * @param guia guia responsável pela experiência
     */
    public Experiencia(
            String id,
            String nome,
            double precoAdulto,
            double precoCrianca,
            Guia guia) {

        this.id = id;
        this.nome = nome;
        this.precoAdulto = precoAdulto;
        this.precoCrianca = precoCrianca;
        this.guia = guia;
    }

    /**
     * Obtém o identificador da experiência.
     *
     * @return identificador da experiência
     */
    public String getId() {
        return id;
    }

    /**
     * Obtém o nome da experiência.
     *
     * @return nome da experiência
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtém o guia responsável pela experiência.
     *
     * @return guia da experiência
     */
    public Guia getGuia() {
        return guia;
    }

    /**
     * Obtém o preço do bilhete de adulto.
     *
     * @return preço do bilhete de adulto
     */
    public double getPrecoAdulto() {
        return precoAdulto;
    }

    /**
     * Obtém o preço do bilhete de criança.
     *
     * @return preço do bilhete de criança
     */
    public double getPrecoCrianca() {
        return precoCrianca;
    }
}
