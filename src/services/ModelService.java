package services;

import model.Toy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModelService {
    private static final String TOYS = "Toys.txt";
    private static final String PRIZE_TOYS = "PrizeToys.txt";

    /**
     * Метод получения списка игрушек из файла
     *
     * @return Список игрушек
     */
    public static List<Toy> getAllToys() {
        List<Toy> toys = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(TOYS))) {
            String line = reader.readLine();
            while (line != null) {
                String[] param = line.split(",");
                Toy toy = new Toy(Integer.parseInt(param[0]), param[1], Integer.parseInt(param[2]), Integer.parseInt(param[3]));
                toys.add(toy);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Файл не найден" + e.getMessage());
        }
        return toys;
    }

    /**
     * Метод сохранения списка игрушек в файл
     *
     * @param toys Список игрушек
     */
    public static void saveAllToys(List<Toy> toys) {
        try (FileWriter fileWriter = new FileWriter(TOYS, false)) {
            for (Toy toy : toys) {
                fileWriter.write(toy.getId() + "," + toy.getName() + "," + toy.getQuantity() + "," + toy.getFrequency());
                fileWriter.append('\n');
            }
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Файл не найден" + e.getMessage());
        }
    }

    /**
     * Метод добавления игрушки в файл
     *
     * @param toy Игрушка
     */
    public static void addToy(Toy toy) {
        try (FileWriter fileWriter = new FileWriter(TOYS, true)) {
            fileWriter.write(toy.getId() + "," + toy.getName() + "," + toy.getQuantity() + "," + toy.getFrequency());
            fileWriter.append('\n');
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Файл не найден" + e.getMessage());
        }
    }

    /**
     * Метод получения списка выигранных игрушек из файла
     *
     * @return Список выигранных игрушек
     */
    public static List<String> getAllPrizeToys() {
        List<String> prizeToys = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PRIZE_TOYS))) {
            String line = reader.readLine();
            while (line != null) {
                prizeToys.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Файл не найден" + e.getMessage());
        }
        return prizeToys;
    }

    /**
     * Метод сохранения списка выигранных игрушек
     *
     * @param prizeToys Список выигранных игрушек
     */
    public static void saveAllPrizeToys(List<Toy> prizeToys) {
        try (FileWriter fileWriter = new FileWriter(PRIZE_TOYS, true)) {
            for (Toy toy : prizeToys) {
                fileWriter.write(toy.getName());
                fileWriter.append('\n');
            }
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Файл не найден" + e.getMessage());
        }
    }

    /**
     * Метод перезаписи списка выигранных игрушек
     *
     * @param prizeToys Список выигранных игрушек
     */
    public static void reSaveAllPrizeToys(List<String> prizeToys) {
        try (FileWriter fileWriter = new FileWriter(PRIZE_TOYS, false)) {
            for (String toy : prizeToys) {
                fileWriter.write(toy);
                fileWriter.append('\n');
            }
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Файл не найден" + e.getMessage());
        }
    }
}