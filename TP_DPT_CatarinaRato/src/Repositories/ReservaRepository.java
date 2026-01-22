package Repositories;

import Models.Reserva;
import Tools.CsvFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Repositório responsável pela gestão das reservas de quartos.
 * <p>
 * Esta classe carrega as reservas a partir de um ficheiro CSV e permite
 * consultar e adicionar novas reservas ao sistema.
 * </p>
 */
public class ReservaRepository {

    /** Lista de reservas registadas no sistema */
    private ArrayList<Reserva> reservas;

    /**
     * Construtor da classe {@code ReservaRepository}.
     * <p>
     * Lê os dados das reservas a partir do ficheiro CSV
     * {@code files/reservas_quartos.csv}.
     * </p>
     *
     * @throws FileNotFoundException caso o ficheiro CSV não seja encontrado
     */
    public ReservaRepository() throws FileNotFoundException {
        this.reservas = CsvFileReader.readReservasCsvFile("files/reservas_quartos.csv");
    }

    /**
     * Obtém a lista de reservas registadas.
     *
     * @return lista de reservas
     */
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    /**
     * Adiciona uma nova reserva ao sistema.
     * <p>
     * Atualmente, a reserva é apenas adicionada à lista em memória.
     * A escrita no ficheiro CSV poderá ser implementada futuramente.
     * </p>
     *
     * @param r reserva a adicionar
     */
    public void adicionarReserva(Reserva r) {
        reservas.add(r);
        // mais tarde: escrever no CSV
    }
}
