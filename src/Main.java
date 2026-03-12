import Repositories.*;
import Views.MenuLoginView;

import java.io.FileNotFoundException;

/**
 * Classe principal da aplicação.
 * <p>
 * Esta classe é o ponto de entrada do sistema, sendo responsável
 * pela inicialização dos repositórios e pelo arranque do menu
 * principal da aplicação.
 * </p>
 */
public class Main {

    /**
     * Método principal da aplicação.
     * <p>
     * Inicializa todos os repositórios necessários, carregando os dados
     * a partir de ficheiros CSV, e apresenta o menu inicial ao utilizador.
     * </p>
     *
     * @param args argumentos da linha de comandos (não utilizados)
     * @throws FileNotFoundException caso algum ficheiro CSV não seja encontrado
     */
    public static void main(String[] args) throws FileNotFoundException {

        // 🔹 LOGIN
        UsersRepository usersRepo = new UsersRepository();

        // 🔹 TIPOLOGIAS E QUARTOS
        TipologiaRepository tipologiaRepo = new TipologiaRepository();
        QuartoRepository quartoRepo =
                new QuartoRepository(tipologiaRepo.getTipologias());

        // 🔹 GUIAS E EXPERIÊNCIAS
        GuiaRepository guiaRepo = new GuiaRepository();
        ExperienciaRepository experienciaRepo =
                new ExperienciaRepository(guiaRepo.getGuias());

        // 🔹 CLIENTES, RESERVAS E VENDAS
        ClienteRepository clienteRepo = new ClienteRepository();
        ReservaRepository reservaRepo = new ReservaRepository();
        VendaRepository vendaRepo = new VendaRepository();

        // 🔹 MENU PRINCIPAL
        MenuLoginView.mostrarMenu(
                usersRepo,
                quartoRepo,
                experienciaRepo,
                reservaRepo,
                clienteRepo,
                vendaRepo,
                guiaRepo
        );
    }
}
