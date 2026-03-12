package Views;

import Controllers.AdminController;
import Repositories.*;

import java.util.Scanner;

/**
 * Classe responsável pela interface de consola do administrador.
 * <p>
 * Esta classe apresenta o menu do administrador e permite executar
 * operações administrativas, como a consulta de receitas mensais.
 * </p>
 */
public class AdminView {

    /** Scanner utilizado para leitura de dados introduzidos pelo utilizador */
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Apresenta o menu do administrador e gere a interação com o utilizador.
     * <p>
     * O menu permite selecionar várias opções administrativas, embora
     * algumas funcionalidades ainda se encontrem em desenvolvimento.
     * </p>
     *
     * @param reservaRepo repositório de reservas
     * @param quartoRepo repositório de quartos
     * @param vendaRepo repositório de vendas
     * @param experienciaRepo repositório de experiências
     */
    public static void menuAdmin(
            ReservaRepository reservaRepo,
            QuartoRepository quartoRepo,
            VendaRepository vendaRepo,
            ExperienciaRepository experienciaRepo
    ) {

        int opcao;

        do {
            System.out.println("\n=== MENU ADMINISTRADOR ===");
            System.out.println("1. Consultar Total de Reservas (Em Construção)");
            System.out.println("2. Consultar Total de Receitas (Em Construção)");
            System.out.println("3. Consultar Reservas / Receitas Mensais");
            System.out.println("4. Consultar Tipologia de Quarto Mais Reservada (Em Construção)");
            System.out.println("5. Consultar Experiência Mais Procurada (Adultos) (Em Construção)");
            System.out.println("6. Consultar Experiência Mais Procurada (Crianças) (Em Construção)");
            System.out.println("7. Consultar Experiência Mais Lucrativa (Em Construção)");
            System.out.println("8. Consultar Experiência Menos Lucrativa (Em Construção)");
            System.out.println("9. Consultar Quarto com Melhor Preço/Semana (Em Construção)");
            System.out.println("10. Adicionar Novo Login (Em Construção)");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> System.out.println("Funcionalidade não implementada.");

                case 2 -> System.out.println("Funcionalidade não implementada.");

                case 3 -> consultarReservasReceitasMensais(
                        reservaRepo,
                        quartoRepo,
                        vendaRepo,
                        experienciaRepo
                );

                case 4 -> System.out.println("Funcionalidade não implementada.");

                case 5 -> System.out.println("Funcionalidade não implementada.");

                case 6 -> System.out.println("Funcionalidade não implementada.");

                case 7 -> System.out.println("Funcionalidade não implementada.");

                case 8 -> System.out.println("Funcionalidade não implementada.");

                case 9 -> System.out.println("Funcionalidade não implementada.");

                case 10 -> System.out.println("Funcionalidade não implementada.");

                case 0 -> System.out.println("A voltar ao menu anterior...");

                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    /**
     * Solicita ao utilizador um mês e um ano e apresenta o total de receitas
     * correspondente.
     * <p>
     * O cálculo das receitas é delegado ao {@link AdminController}.
     * </p>
     *
     * @param reservaRepo repositório de reservas
     * @param quartoRepo repositório de quartos
     * @param vendaRepo repositório de vendas
     * @param experienciaRepo repositório de experiências
     */
    private static void consultarReservasReceitasMensais(
            ReservaRepository reservaRepo,
            QuartoRepository quartoRepo,
            VendaRepository vendaRepo,
            ExperienciaRepository experienciaRepo
    ) {

        System.out.print("Ano: ");
        int ano = sc.nextInt();

        System.out.print("Mês: ");
        int mes = sc.nextInt();

        double total =
                AdminController.consultarReservasReceitasMensais(
                        ano,
                        mes,
                        reservaRepo,
                        quartoRepo,
                        vendaRepo,
                        experienciaRepo
                );

        System.out.printf(
                "Receita total em %02d/%d: %.2f €%n",
                mes,
                ano,
                total
        );
    }
}
