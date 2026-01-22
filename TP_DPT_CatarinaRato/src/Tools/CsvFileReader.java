package Tools;

import Models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe utilitária responsável pela leitura de ficheiros CSV.
 * <p>
 * Esta classe contém métodos estáticos que permitem ler diferentes tipos
 * de dados (utilizadores, tipologias, quartos, reservas, guias, experiências,
 * clientes e vendas) a partir de ficheiros CSV e convertê-los em objetos
 * do modelo do sistema.
 * </p>
 */
public class CsvFileReader {

    /**
     * Lê um ficheiro CSV contendo os utilizadores do sistema.
     *
     * @param filePath caminho para o ficheiro CSV
     * @return lista de utilizadores lidos do ficheiro
     * @throws FileNotFoundException caso o ficheiro não seja encontrado
     */
    public static ArrayList<Utilizador> readUsersCsvFile(String filePath)
            throws FileNotFoundException {

        ArrayList<Utilizador> users = new ArrayList<>();
        Scanner sc = new Scanner(new File(filePath));
        sc.nextLine(); // ignora cabeçalho

        while (sc.hasNextLine()) {

            String lineRaw = sc.nextLine().trim();
            if (lineRaw.isEmpty()) continue;

            String[] line = lineRaw.split(",");

            String username = line[0];
            String password = line[1];
            String tipo = line[2];

            users.add(new Utilizador(
                    tipo,
                    username,
                    password
            ));
        }

        sc.close();
        return users;
    }

    /**
     * Lê um ficheiro CSV contendo as tipologias de quartos.
     *
     * @param filePath caminho para o ficheiro CSV
     * @return lista de tipologias
     * @throws FileNotFoundException caso o ficheiro não seja encontrado
     */
    public static ArrayList<Tipologia> readTipologiasCsvFile(String filePath)
            throws FileNotFoundException {

        ArrayList<Tipologia> tipologias = new ArrayList<>();
        Scanner sc = new Scanner(new File(filePath));
        sc.nextLine(); // ignora cabeçalho

        while (sc.hasNextLine()) {

            String lineRaw = sc.nextLine().trim();
            if (lineRaw.isEmpty()) continue;

            String[] l = lineRaw.split(",");

            int id = Integer.parseInt(l[0]);
            String descricao = l[1];
            double precoSemana = Double.parseDouble(l[2]);

            tipologias.add(new Tipologia(
                    id,
                    descricao,
                    precoSemana
            ));
        }

        sc.close();
        return tipologias;
    }

    /**
     * Lê um ficheiro CSV contendo os quartos do sistema.
     * <p>
     * Cada quarto é associado à respetiva tipologia com base no identificador.
     * </p>
     *
     * @param filePath caminho para o ficheiro CSV
     * @param tipologias lista de tipologias existentes
     * @return lista de quartos
     * @throws FileNotFoundException caso o ficheiro não seja encontrado
     */
    public static ArrayList<Quarto> readQuartosCsvFile(
            String filePath, ArrayList<Tipologia> tipologias)
            throws FileNotFoundException {

        ArrayList<Quarto> quartos = new ArrayList<>();
        Scanner sc = new Scanner(new File(filePath));
        sc.nextLine(); // ignora cabeçalho

        while (sc.hasNextLine()) {

            String[] l = sc.nextLine().split(",");

            int numQuarto = Integer.parseInt(l[0]);
            int tipologiaId = Integer.parseInt(l[1]);

            Tipologia tip = tipologias.stream()
                    .filter(t -> t.getId() == tipologiaId)
                    .findFirst()
                    .orElse(null);

            quartos.add(new Quarto(
                    numQuarto,
                    tip,
                    true // disponível por defeito
            ));
        }

        sc.close();
        return quartos;
    }

    /**
     * Lê um ficheiro CSV contendo as reservas de quartos.
     *
     * @param filePath caminho para o ficheiro CSV
     * @return lista de reservas
     * @throws FileNotFoundException caso o ficheiro não seja encontrado
     */
    public static ArrayList<Reserva> readReservasCsvFile(String filePath)
            throws FileNotFoundException {

        ArrayList<Reserva> reservas = new ArrayList<>();
        Scanner sc = new Scanner(new File(filePath));
        sc.nextLine(); // ignora cabeçalho

        while (sc.hasNextLine()) {

            String lineRaw = sc.nextLine().trim();
            if (lineRaw.isEmpty()) continue;

            String[] data = lineRaw.split(",");

            String idReserva = data[0];
            int numQuarto = Integer.parseInt(data[1]);
            String idCliente = data[2];
            int ano = Integer.parseInt(data[3]);
            int mes = Integer.parseInt(data[4]);
            int semana = Integer.parseInt(data[5]);

            reservas.add(new Reserva(
                    idReserva,
                    numQuarto,
                    idCliente,
                    ano,
                    mes,
                    semana
            ));
        }

        sc.close();
        return reservas;
    }

    /**
     * Lê um ficheiro CSV contendo os guias do sistema.
     *
     * @param filePath caminho para o ficheiro CSV
     * @return lista de guias
     * @throws FileNotFoundException caso o ficheiro não seja encontrado
     */
    public static ArrayList<Guia> readGuiasCsvFile(String filePath)
            throws FileNotFoundException {

        ArrayList<Guia> guias = new ArrayList<>();
        Scanner sc = new Scanner(new File(filePath));
        sc.nextLine(); // ignora cabeçalho

        while (sc.hasNextLine()) {

            String lineRaw = sc.nextLine().trim();
            if (lineRaw.isEmpty()) continue;

            String[] l = lineRaw.split(",");

            String id = l[0];
            String nome = l[1];

            guias.add(new Guia(id, nome));
        }

        sc.close();
        return guias;
    }

    /**
     * Lê um ficheiro CSV contendo as experiências do sistema.
     * <p>
     * Cada experiência é associada ao respetivo guia com base no identificador.
     * </p>
     *
     * @param filePath caminho para o ficheiro CSV
     * @param guias lista de guias existentes
     * @return lista de experiências
     * @throws FileNotFoundException caso o ficheiro não seja encontrado
     */
    public static ArrayList<Experiencia> readExperienciasCsvFile(
            String filePath,
            ArrayList<Guia> guias)
            throws FileNotFoundException {

        ArrayList<Experiencia> experiencias = new ArrayList<>();
        Scanner sc = new Scanner(new File(filePath));
        sc.nextLine(); // ignora cabeçalho

        while (sc.hasNextLine()) {

            String lineRaw = sc.nextLine().trim();
            if (lineRaw.isEmpty()) continue;

            String[] l = lineRaw.split(",");

            String id = l[0];
            String nome = l[1];
            String guiaId = l[2];
            double precoAdulto = Double.parseDouble(l[3]);
            double precoCrianca = Double.parseDouble(l[4]);

            Guia guia = guias.stream()
                    .filter(g -> g.getId().equals(guiaId))
                    .findFirst()
                    .orElse(null);

            experiencias.add(new Experiencia(
                    id,
                    nome,
                    precoAdulto,
                    precoCrianca,
                    guia
            ));
        }

        sc.close();
        return experiencias;
    }

    /**
     * Lê um ficheiro CSV contendo os clientes do sistema.
     *
     * @param filePath caminho para o ficheiro CSV
     * @return lista de clientes
     * @throws FileNotFoundException caso o ficheiro não seja encontrado
     */
    public static ArrayList<Cliente> readClientesCsvFile(String filePath)
            throws FileNotFoundException {

        ArrayList<Cliente> clientes = new ArrayList<>();
        Scanner sc = new Scanner(new File(filePath));
        sc.nextLine(); // ignora cabeçalho

        while (sc.hasNextLine()) {

            String lineRaw = sc.nextLine().trim();
            if (lineRaw.isEmpty()) continue;

            String[] l = lineRaw.split(",");

            String idCliente = l[0];
            String nome = l[1];
            String nacionalidade = l[2];
            String email = l[3];

            clientes.add(new Cliente(
                    idCliente,
                    nome,
                    nacionalidade,
                    email
            ));
        }

        sc.close();
        return clientes;
    }

    /**
     * Lê um ficheiro CSV contendo as vendas de experiências.
     *
     * @param filePath caminho para o ficheiro CSV
     * @return lista de vendas
     * @throws FileNotFoundException caso o ficheiro não seja encontrado
     */
    public static ArrayList<Venda> readVendasCsvFile(String filePath)
            throws FileNotFoundException {

        ArrayList<Venda> vendas = new ArrayList<>();
        Scanner sc = new Scanner(new File(filePath));
        sc.nextLine(); // ignora cabeçalho

        while (sc.hasNextLine()) {

            String lineRaw = sc.nextLine().trim();
            if (lineRaw.isEmpty()) continue;

            String[] data = lineRaw.split(",");

            String idVenda = data[0];
            String idExperiencia = data[1];
            String tipoCliente = data[2];
            int ano = Integer.parseInt(data[3]);
            int mes = Integer.parseInt(data[4]);

            vendas.add(new Venda(
                    idVenda,
                    idExperiencia,
                    tipoCliente,
                    ano,
                    mes
            ));
        }

        sc.close();
        return vendas;
    }
}
