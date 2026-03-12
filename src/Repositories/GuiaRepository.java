package Repositories;

import Models.Guia;
import Tools.CsvFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Repositório responsável pela gestão dos guias do sistema.
 * <p>
 * Esta classe carrega os dados dos guias a partir de um ficheiro CSV
 * e disponibiliza acesso à lista de guias registados.
 * </p>
 */
public class GuiaRepository {

    /** Lista de guias carregados no sistema */
    private ArrayList<Guia> guias;

    /**
     * Construtor da classe {@code GuiaRepository}.
     * <p>
     * Lê os dados dos guias a partir do ficheiro CSV
     * {@code files/guias_experiencias.csv}.
     * </p>
     *
     * @throws FileNotFoundException caso o ficheiro CSV não seja encontrado
     */
    public GuiaRepository() throws FileNotFoundException {
        this.guias = CsvFileReader.readGuiasCsvFile("files/guias_experiencias.csv");
    }

    /**
     * Obtém a lista de guias registados no sistema.
     *
     * @return lista de guias
     */
    public ArrayList<Guia> getGuias() {
        return guias;
    }
}
