package Controllers;

import Models.Experiencia;
import Models.Guia;
import Models.Venda;
import Repositories.ExperienciaRepository;
import Repositories.VendaRepository;

import java.util.ArrayList;

/**
 * Controlador responsável pelas funcionalidades associadas aos guias.
 * <p>
 * Esta classe permite obter informação estatística sobre as experiências
 * realizadas por um determinado guia, incluindo o número de participantes
 * e o total de receitas geradas.
 * </p>
 */
public class GuiaController {

    /**
     * Classe auxiliar que representa um resumo estatístico de uma experiência.
     * <p>
     * Contém o nome da experiência, o número de adultos e crianças participantes
     * e o valor total de receitas geradas.
     * </p>
     */
    public static class ResumoExperiencia {

        /** Nome da experiência */
        public String nome;

        /** Número de participantes adultos */
        public int adultos;

        /** Número de participantes crianças */
        public int criancas;

        /** Total de receitas geradas pela experiência */
        public double total;

        /**
         * Construtor da classe {@code ResumoExperiencia}.
         *
         * @param nome nome da experiência
         * @param adultos número de adultos participantes
         * @param criancas número de crianças participantes
         * @param total total de receitas geradas
         */
        public ResumoExperiencia(String nome, int adultos, int criancas, double total) {
            this.nome = nome;
            this.adultos = adultos;
            this.criancas = criancas;
            this.total = total;
        }
    }

    /**
     * Obtém o histórico de experiências associadas a um guia específico.
     * <p>
     * Para cada experiência do guia, este método calcula:
     * <ul>
     *   <li>O número de bilhetes de adulto vendidos</li>
     *   <li>O número de bilhetes de criança vendidos</li>
     *   <li>O total de receitas geradas</li>
     * </ul>
     * </p>
     *
     * @param guia guia cujas experiências se pretendem analisar
     * @param experienciaRepo repositório que contém todas as experiências
     * @param vendaRepo repositório que contém todas as vendas registadas
     * @return lista de resumos estatísticos das experiências do guia
     */
    public static ArrayList<ResumoExperiencia> obterHistoricoGuia(
            Guia guia,
            ExperienciaRepository experienciaRepo,
            VendaRepository vendaRepo
    ) {

        ArrayList<ResumoExperiencia> resumo = new ArrayList<>();

        // Percorre todas as experiências existentes
        for (Experiencia e : experienciaRepo.getExperiencias()) {

            // Considera apenas experiências associadas ao guia indicado
            if (!e.getGuia().getId().equals(guia.getId())) {
                continue;
            }

            int adultos = 0;
            int criancas = 0;
            double total = 0;

            // Conta vendas associadas à experiência
            for (Venda v : vendaRepo.getVendas()) {

                if (v.getIdExperiencia().equals(e.getId())) {

                    if (v.isAdulto()) {
                        adultos++;
                        total += e.getPrecoAdulto();
                    }

                    if (v.isCrianca()) {
                        criancas++;
                        total += e.getPrecoCrianca();
                    }
                }
            }

            // Adiciona o resumo da experiência à lista
            resumo.add(new ResumoExperiencia(
                    e.getNome(),
                    adultos,
                    criancas,
                    total
            ));
        }

        return resumo;
    }
}
