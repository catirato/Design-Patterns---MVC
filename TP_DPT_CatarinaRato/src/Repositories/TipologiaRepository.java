package Repositories;

import Models.Tipologia;
import Tools.CsvFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Repositório responsável pela gestão das tipologias de quartos.
 * <p>
 * Esta classe carrega as tipologias a partir de um ficheiro CSV
 * e disponibiliza acesso à lista de tipologias registadas.
 * </p>
 */
public class TipologiaRepository {

    /** Lista de tipologias carregadas no sistema */
    private ArrayList<Tipologia> tipologias;

    /**
     * Construtor da classe {@code TipologiaRepository}.
     * <p>
     * Lê os dados das tipologias a partir do ficheiro CSV
     * {@code files/tipologia.csv}.
     * </p>
     *
     * @throws FileNotFoundException caso o ficheiro CSV não seja encontrado
     */
    public TipologiaRepository() throws FileNotFoundException {
        this.tipologias = CsvFileReader.readTipologiasCsvFile("files/tipologia.csv");
    }

    /**
     * Obtém a lista de tipologias disponíveis.
     *
     * @return lista de tipologias
     */
    public ArrayList<Tipologia> getTipologias() {
        return tipologias;
    }
}
