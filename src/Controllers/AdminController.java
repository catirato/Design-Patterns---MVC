package Controllers;

import Models.Experiencia;
import Models.Quarto;
import Models.Reserva;
import Models.Venda;
import Repositories.ExperienciaRepository;
import Repositories.QuartoRepository;
import Repositories.ReservaRepository;
import Repositories.VendaRepository;

/**
 * Controlador responsável por funcionalidades administrativas do sistema.
 * <p>
 * Esta classe contém métodos de apoio à gestão, nomeadamente a consulta
 * das receitas mensais provenientes de reservas de quartos e da venda
 * de experiências.
 * </p>
 */
public class AdminController {

    /**
     * Calcula o total de receitas mensais do sistema, considerando:
     * <ul>
     *   <li>Reservas de quartos (preço semanal do quarto reservado)</li>
     *   <li>Vendas de experiências (bilhetes de adulto e/ou criança)</li>
     * </ul>
     *
     * Apenas são consideradas reservas e vendas realizadas no mês e ano
     * especificados.
     *
     * @param ano ano para o qual se pretende calcular as receitas
     * @param mes mês para o qual se pretende calcular as receitas
     * @param reservaRepo repositório que contém todas as reservas registadas
     * @param quartoRepo repositório que contém todos os quartos disponíveis
     * @param vendaRepo repositório que contém todas as vendas de experiências
     * @param experienciaRepo repositório que contém todas as experiências disponíveis
     * @return valor total das receitas do mês especificado
     */
    public static double consultarReservasReceitasMensais(
            int ano,
            int mes,
            ReservaRepository reservaRepo,
            QuartoRepository quartoRepo,
            VendaRepository vendaRepo,
            ExperienciaRepository experienciaRepo
    ) {

        double totalReceitas = 0;

        // 🔹 RECEITAS DE QUARTOS (por reserva)
        for (Reserva r : reservaRepo.getReservas()) {

            // Filtra reservas pelo ano e mês pretendidos
            if (r.getAno() == ano && r.getMes() == mes) {

                // Procura o quarto associado à reserva
                for (Quarto q : quartoRepo.getQuartos()) {

                    if (q.getNumQuarto() == r.getNumQuarto()) {
                        totalReceitas += q.getPrecoSemana();
                        break;
                    }
                }
            }
        }

        // 🔹 RECEITAS DE EXPERIÊNCIAS (1 venda = 1 bilhete)
        for (Venda v : vendaRepo.getVendas()) {

            // Filtra vendas pelo ano e mês
            if (v.getAno() != ano || v.getMes() != mes) {
                continue;
            }

            // Procura a experiência associada à venda
            for (Experiencia e : experienciaRepo.getExperiencias()) {

                if (e.getId().equals(v.getIdExperiencia())) {

                    // Adiciona o preço do bilhete de adulto, se aplicável
                    if (v.isAdulto()) {
                        totalReceitas += e.getPrecoAdulto();
                    }

                    // Adiciona o preço do bilhete de criança, se aplicável
                    if (v.isCrianca()) {
                        totalReceitas += e.getPrecoCrianca();
                    }

                    break;
                }
            }
        }

        return totalReceitas;
    }
}
