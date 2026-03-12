package Controllers;

import Models.Venda;
import Repositories.VendaRepository;

/**
 * Controlador responsável pela gestão de reservas de experiências.
 * <p>
 * Esta classe contém métodos que permitem criar e registar vendas
 * associadas às experiências, tanto para adultos como para crianças.
 * </p>
 */
public class GestaoController {

    /**
     * Regista a reserva de uma experiência, criando vendas individuais
     * para adultos e crianças.
     * <p>
     * Cada venda corresponde a um bilhete. O método cria tantas vendas
     * quantos os adultos e crianças indicados.
     * </p>
     *
     * @param vendaRepo repositório onde as vendas serão armazenadas
     * @param idExperiencia identificador da experiência reservada
     * @param numAdultos número de bilhetes de adulto a reservar
     * @param numCriancas número de bilhetes de criança a reservar
     * @param ano ano em que a venda é registada
     * @param mes mês em que a venda é registada
     */
    public static void reservarExperiencia(
            VendaRepository vendaRepo,
            String idExperiencia,
            int numAdultos,
            int numCriancas,
            int ano,
            int mes
    ) {

        // 🔹 Criar vendas de ADULTOS
        for (int i = 0; i < numAdultos; i++) {
            Venda v = new Venda(
                    gerarIdVenda(vendaRepo),
                    idExperiencia,
                    "adulto",
                    ano,
                    mes
            );
            vendaRepo.adicionarVenda(v);
        }

        // 🔹 Criar vendas de CRIANÇAS
        for (int i = 0; i < numCriancas; i++) {
            Venda v = new Venda(
                    gerarIdVenda(vendaRepo),
                    idExperiencia,
                    "crianca",
                    ano,
                    mes
            );
            vendaRepo.adicionarVenda(v);
        }
    }

    /**
     * Gera um identificador único para uma venda.
     * <p>
     * O identificador segue o formato {@code V000X}, onde {@code X}
     * corresponde ao número sequencial da venda.
     * </p>
     *
     * @param vendaRepo repositório de vendas, usado para determinar
     *                  o próximo identificador disponível
     * @return identificador único da venda
     */
    private static String gerarIdVenda(VendaRepository vendaRepo) {
        int proximo = vendaRepo.getVendas().size() + 1;
        return String.format("V%04d", proximo);
    }
}
