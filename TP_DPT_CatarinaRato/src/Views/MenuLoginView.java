package Views;

import Controllers.LoginController;
import Models.Guia;
import Models.Utilizador;
import Repositories.*;

import java.util.Scanner;

/**
 * Classe responsável pela apresentação do menu inicial da aplicação.
 * <p>
 * Esta classe permite ao utilizador efetuar login ou aceder ao sistema
 * como cliente em modo público, encaminhando depois para o menu
 * correspondente ao perfil autenticado.
 * </p>
 */
public class MenuLoginView {

    /** Scanner utilizado para leitura de dados introduzidos pelo utilizador */
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Apresenta o menu principal da aplicação.
     * <p>
     * O utilizador pode efetuar login, aceder como cliente ou sair
     * da aplicação.
     * </p>
     *
     * @param usersRepo repositório de utilizadores
     * @param quartoRepo repositório de quartos
     * @param experienciaRepo repositório de experiências
     * @param reservaRepo repositório de reservas
     * @param clienteRepo repositório de clientes
     * @param vendaRepo repositório de vendas
     * @param guiaRepo repositório de guias
     */
    public static void mostrarMenu(
            UsersRepository usersRepo,
            QuartoRepository quartoRepo,
            ExperienciaRepository experienciaRepo,
            ReservaRepository reservaRepo,
            ClienteRepository clienteRepo,
            VendaRepository vendaRepo,
            GuiaRepository guiaRepo
    ) {

        int opcao;

        do {
            System.out.println("\n=== CESAE Resort ===");
            System.out.println("1. Login");
            System.out.println("2. Cliente (acesso público)");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> fazerLogin(
                        usersRepo,
                        quartoRepo,
                        experienciaRepo,
                        reservaRepo,
                        clienteRepo,
                        vendaRepo,
                        guiaRepo
                );

                case 2 -> ClienteView.menuCliente(
                        quartoRepo,
                        experienciaRepo
                );

                case 0 -> System.out.println("A sair da aplicação...");

                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    /**
     * Realiza o processo de autenticação de um utilizador.
     * <p>
     * Caso as credenciais sejam válidas, o utilizador é encaminhado
     * para o menu correspondente ao seu perfil (Administrador,
     * Gestão ou Guia).
     * </p>
     *
     * @param usersRepo repositório de utilizadores
     * @param quartoRepo repositório de quartos
     * @param experienciaRepo repositório de experiências
     * @param reservaRepo repositório de reservas
     * @param clienteRepo repositório de clientes
     * @param vendaRepo repositório de vendas
     * @param guiaRepo repositório de guias
     */
    private static void fazerLogin(
            UsersRepository usersRepo,
            QuartoRepository quartoRepo,
            ExperienciaRepository experienciaRepo,
            ReservaRepository reservaRepo,
            ClienteRepository clienteRepo,
            VendaRepository vendaRepo,
            GuiaRepository guiaRepo
    ) {

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        Utilizador utilizadorLogado =
                LoginController.autenticar(
                        username,
                        password,
                        usersRepo.getUsers()
                );

        if (utilizadorLogado == null) {
            System.out.println("Login inválido.");
            return;
        }

        System.out.println("Login efetuado com sucesso!");
        System.out.println("Perfil: " + utilizadorLogado.getTipo());

        switch (utilizadorLogado.getTipo()) {

            case "ADMIN" -> {
                AdminView.menuAdmin(
                        reservaRepo,
                        quartoRepo,
                        vendaRepo,
                        experienciaRepo
                );
            }

            case "GESTAO" -> {
                GestaoView.menuGestao(
                        quartoRepo,
                        reservaRepo,
                        clienteRepo,
                        experienciaRepo,
                        vendaRepo
                );
            }

            case "GUIA" -> {

                // Converte o utilizador autenticado no respetivo guia
                Guia guiaLogado = guiaRepo.getGuias().stream()
                        .filter(g -> g.getId().equals(utilizadorLogado.getUsername()))
                        .findFirst()
                        .orElse(null);

                if (guiaLogado == null) {
                    System.out.println("Guia não encontrado.");
                    return;
                }

                GuiaView.menuGuia(
                        guiaLogado,
                        experienciaRepo,
                        vendaRepo
                );
            }

            default -> System.out.println("Perfil desconhecido.");
        }
    }
}
