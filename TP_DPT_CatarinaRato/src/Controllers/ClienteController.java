package Controllers;

import Models.Quarto;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador responsável pelas funcionalidades acessíveis ao cliente.
 * <p>
 * Esta classe fornece métodos relacionados com a consulta de informação
 * disponível para os clientes, como a listagem de quartos disponíveis.
 * </p>
 */
public class ClienteController {

    /**
     * Obtém a lista de quartos disponíveis.
     * <p>
     * Percorre a lista de quartos fornecida e seleciona apenas aqueles
     * que se encontram disponíveis.
     * </p>
     *
     * @param quartos lista de quartos a analisar
     * @return lista de quartos que estão atualmente disponíveis
     */
    public static List<Quarto> getQuartosDisponiveis(List<Quarto> quartos) {

        List<Quarto> disponiveis = new ArrayList<>();

        // Percorre todos os quartos e filtra os que estão disponíveis
        for (Quarto q : quartos) {
            if (q.isDisponivel()) {
                disponiveis.add(q);
            }
        }

        return disponiveis;
    }
}
