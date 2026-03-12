package Views;

import Controllers.GuiaController;
import Models.Guia;
import Repositories.ExperienciaRepository;
import Repositories.VendaRepository;

import java.util.Scanner;

/**
 * Classe responsável pela interface de consola do guia.
 * <p>
 * Esta classe apresenta o menu do guia e permite consultar o histórico
 * de experiências associadas, incluindo número de participantes e receitas.
 * </p>
 */
public class GuiaView {

    /** Scanner utilizado para leitura de dados introduzidos pelo utilizador */
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Apresenta o menu do guia e gere a interação com o utilizador.
     *
     * @param guiaLogado guia autenticado no sistema
     * @param experienciaRepo repositório de experiências
     * @param vendaRepo repositório de vendas
     */
    public static void menuGuia(
            Guia guiaLogado,
            ExperienciaRepository experienciaRepo,
            VendaRepository vendaRepo
    ) {

        int opcao;

        do {
            System.out.println("\n=== MENU GUIA ===");
            System.out.println("1. Consultar Histórico de Experiências");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> mostrarHistorico(
                        guiaLogado,
                        experienciaRepo,
                        vendaRepo
                );

                case 0 ->
                        System.out.println("A voltar ao menu anterior...");

                default ->
                        System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    /**
     * Apresenta o histórico de experiências associadas a um guia.
     * <p>
     * O histórico inclui o número de adultos, crianças e o total de
     * receitas geradas por cada experiência.
     * </p>
     *
     * @param guia guia cujas experiências se pretendem consultar
     * @param experienciaRepo repositório de experiências
     * @param vendaRepo repositório de vendas
     */
    private static void mostrarHistorico(
            Guia guia,
            ExperienciaRepository experienciaRepo,
            VendaRepository vendaRepo
    ) {

        var resumo =
                GuiaController.obterHistoricoGuia(
                        guia,
                        experienciaRepo,
                        vendaRepo
                );

        if (resumo.isEmpty()) {
            System.out.println("Não existem experiências associadas a este guia.");
            return;
        }

        System.out.println("\n--- HISTÓRICO DE EXPERIÊNCIAS ---");
        System.out.printf(
                "%-25s %-10s %-10s %-12s%n",
                "Experiência", "Adultos", "Crianças", "Total (€)"
        );

        for (GuiaController.ResumoExperiencia r : resumo) {
            System.out.printf(
                    "%-25s %-10d %-10d %-12.2f%n",
                    r.nome,
                    r.adultos,
                    r.criancas,
                    r.total
            );
        }
    }
}
