package Views;

import Controllers.ClienteController;
import Models.Quarto;
import Repositories.QuartoRepository;
import Repositories.ExperienciaRepository;

import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável pela interface de consola do cliente.
 * <p>
 * Esta classe apresenta o menu do cliente e permite consultar informação
 * disponível, como os quartos atualmente disponíveis.
 * </p>
 */
public class ClienteView {

    /** Scanner utilizado para leitura de dados introduzidos pelo utilizador */
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Apresenta o menu do cliente e gere a interação com o utilizador.
     * <p>
     * Algumas funcionalidades encontram-se ainda em desenvolvimento.
     * </p>
     *
     * @param quartoRepo repositório de quartos
     * @param experienciaRepo repositório de experiências
     */
    public static void menuCliente(
            QuartoRepository quartoRepo,
            ExperienciaRepository experienciaRepo
    ) {

        int opcao;

        do {
            System.out.println("\n=== MENU CLIENTE ===");
            System.out.println("1. Consultar Quartos Disponíveis");
            System.out.println("2. Consultar Experiências Disponíveis (Em Construção)");
            System.out.println("3. Consultar Experiência Favorita (Em Construção)");
            System.out.println("4. Consultar Experiência Top-Seller (Em Construção)");
            System.out.println("5. Avaliar uma Experiência (Em Construção)");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 ->
                        consultarQuartosDisponiveis(quartoRepo);

                case 2 ->
                        System.out.println("Funcionalidade não implementada.");

                case 3 ->
                        System.out.println("Funcionalidade não implementada.");

                case 4 ->
                        System.out.println("Funcionalidade não implementada.");

                case 5 ->
                        System.out.println("Funcionalidade não implementada.");

                case 0 ->
                        System.out.println("A voltar ao menu anterior...");

                default ->
                        System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    /**
     * Apresenta na consola a lista de quartos disponíveis.
     * <p>
     * O método obtém os quartos disponíveis através do
     * {@link ClienteController} e apresenta-os num formato tabular.
     * </p>
     *
     * @param quartoRepo repositório de quartos
     */
    private static void consultarQuartosDisponiveis(
            QuartoRepository quartoRepo
    ) {

        List<Quarto> quartosDisponiveis =
                ClienteController.getQuartosDisponiveis(quartoRepo.getQuartos());

        System.out.println("\n--- Quartos Disponíveis ---");
        System.out.printf("%-12s %-15s %-15s%n",
                "Nº Quarto", "Tipologia", "Preço/Semana");

        for (Quarto q : quartosDisponiveis) {
            System.out.printf("%-12d %-15s %-15.2f%n",
                    q.getNumQuarto(),
                    q.getTipologia().getDescricao(),
                    q.getPrecoSemana());
        }
    }
}
