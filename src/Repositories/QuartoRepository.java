package Repositories;

import Models.Quarto;
import Models.Tipologia;
import Tools.CsvFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Repositório responsável pela gestão dos quartos do sistema.
 * <p>
 * Esta classe carrega os dados dos quartos a partir de um ficheiro CSV
 * e associa cada quarto à respetiva tipologia.
 * </p>
 */
public class QuartoRepository {

    /** Lista de quartos disponíveis no sistema */
    private ArrayList<Quarto> quartos;

    /**
     * Construtor da classe {@code QuartoRepository}.
     * <p>
     * Lê os dados dos quartos a partir do ficheiro CSV
     * {@code files/quartos.csv} e associa cada quarto a uma tipologia existente.
     * </p>
     *
     * @param tipologias lista de tipologias disponíveis no sistema
     * @throws FileNotFoundException caso o ficheiro CSV não seja encontrado
     */
    public QuartoRepository(ArrayList<Tipologia> tipologias)
            throws FileNotFoundException {

        this.quartos = CsvFileReader.readQuartosCsvFile(
                "files/quartos.csv", tipologias);
    }

    /**
     * Obtém a lista de quartos disponíveis.
     *
     * @return lista de quartos
     */
    public ArrayList<Quarto> getQuartos() {
        return quartos;
    }
}
