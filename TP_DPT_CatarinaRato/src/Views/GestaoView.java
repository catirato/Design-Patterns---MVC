package Views;

import Controllers.GestaoController;
import Repositories.*;

import java.util.Scanner;

/**
 * Classe responsável pela interface de consola da área de gestão.
 * <p>
 * Esta classe apresenta o menu de gestão e permite executar operações
 * relacionadas com reservas, nomeadamente a reserva de experiências.
 * </p>
 */
public class GestaoView {

    /** Scanner utilizado para leitura de dados introduzidos pelo utilizador */
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Apresenta o menu de gestão e gere a interação com o utilizador.
     * <p>
     * Algumas funcionalidades encontram-se ainda em desenvolvimento.
     * </p>
     *
     * @param quartoRepo repositório de quartos
     * @param reservaRepo repositório de reservas
     * @param clienteRepo repositório de clientes
     * @param experienciaRepo repositório de experiências
     * @param vendaRepo repositório de vendas
     */
    public static void menuGestao(
            QuartoRepository quartoRepo,
            ReservaRepository reservaRepo,
            ClienteRepository clienteRepo,
            ExperienciaRepository experienciaRepo,
            VendaRepository vendaRepo
    ) {

        int opcao;

        do {
            System.out.println("\n=== MENU GESTÃO ===");
            System.out.println("1. Consultar Quartos Disponíveis (Em Construção)");
            System.out.println("2. Consultar Quartos Reservados (Em Construção)");
            System.out.println("3. Consultar Reservas Atuais (Em Construção)");
            System.out.println("4. Efetuar Reserva de Quarto (Em Construção)");
            System.out.println("5. Reservar Experiência");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 ->
                        System.out.println("Funcionalidade não implementada.");

                case 2 ->
                        System.out.println("Funcionalidade não implementada.");

                case 3 ->
                        System.out.println("Funcionalidade não implementada.");

                case 4 ->
                        System.out.println("Funcionalidade não implementada.");

                case 5 ->
                        reservarExperiencia(
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
     * Permite efetuar a reserva de uma experiência.
     * <p>
     * O método solicita ao utilizador os dados necessários e delega
     * a criação das vendas ao {@link GestaoController}.
     * </p>
     *
     * @param experienciaRepo repositório de experiências
     * @param vendaRepo repositório de vendas
     */
    private static void reservarExperiencia(
            ExperienciaRepository experienciaRepo,
            VendaRepository vendaRepo
    ) {

        System.out.print("ID da Experiência: ");
        String idExperiencia = sc.nextLine();

        System.out.print("Número de Adultos: ");
        int numAdultos = sc.nextInt();

        System.out.print("Número de Crianças: ");
        int numCriancas = sc.nextInt();

        System.out.print("Ano: ");
        int ano = sc.nextInt();

        System.out.print("Mês: ");
        int mes = sc.nextInt();

        sc.nextLine(); // limpar buffer

        GestaoController.reservarExperiencia(
                vendaRepo,
                idExperiencia,
                numAdultos,
                numCriancas,
                ano,
                mes
        );

        System.out.println("Reserva de experiência efetuada com sucesso!");
    }
}
