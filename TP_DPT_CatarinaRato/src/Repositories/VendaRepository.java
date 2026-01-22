package Repositories;

import Models.Venda;
import Tools.CsvFileReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Repositório responsável pela gestão das vendas de experiências.
 * <p>
 * Esta classe carrega as vendas a partir de um ficheiro CSV e permite
 * consultar e adicionar novas vendas ao sistema.
 * </p>
 */
public class VendaRepository {

    /** Lista de vendas registadas no sistema */
    private ArrayList<Venda> vendas;

    /**
     * Construtor da classe {@code VendaRepository}.
     * <p>
     * Lê os dados das vendas a partir do ficheiro CSV
     * {@code files/vendas_experiencias.csv}.
     * </p>
     *
     * @throws FileNotFoundException caso o ficheiro CSV não seja encontrado
     */
    public VendaRepository() throws FileNotFoundException {
        this.vendas = CsvFileReader.readVendasCsvFile("files/vendas_experiencias.csv");
    }

    /**
     * Obtém a lista de vendas registadas.
     *
     * @return lista de vendas
     */
    public ArrayList<Venda> getVendas() {
        return vendas;
    }

    /**
     * Adiciona uma nova venda ao sistema.
     * <p>
     * Atualmente, a venda é apenas adicionada à lista em memória.
     * A escrita no ficheiro CSV poderá ser implementada futuramente.
     * </p>
     *
     * @param v venda a adicionar
     */
    public void adicionarVenda(Venda v) {
        vendas.add(v);
    }
}
