package Repositories;

import Models.Experiencia;
import Models.Guia;
import Tools.CsvFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Repositório responsável pela gestão das experiências do sistema.
 * <p>
 * Esta classe carrega as experiências a partir de um ficheiro CSV e
 * associa cada experiência ao respetivo guia.
 * </p>
 */
public class ExperienciaRepository {

    /** Lista de experiências disponíveis no sistema */
    private ArrayList<Experiencia> experiencias;

    /**
     * Construtor da classe {@code ExperienciaRepository}.
     * <p>
     * Lê os dados das experiências a partir do ficheiro CSV
     * {@code files/experiencias.csv} e associa cada experiência
     * a um guia existente.
     * </p>
     *
     * @param guias lista de guias disponíveis no sistema
     * @throws FileNotFoundException caso o ficheiro CSV não seja encontrado
     */
    public ExperienciaRepository(ArrayList<Guia> guias)
            throws FileNotFoundException {

        this.experiencias = CsvFileReader.readExperienciasCsvFile(
                "files/experiencias.csv", guias);
    }

    /**
     * Obtém a lista de experiências disponíveis.
     *
     * @return lista de experiências
     */
    public ArrayList<Experiencia> getExperiencias() {
        return experiencias;
    }
}
