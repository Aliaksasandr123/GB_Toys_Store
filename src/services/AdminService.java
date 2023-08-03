package services;

import model.Toy;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AdminService implements IAdminService {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void addToy() {
        boolean isPositiveDigit = false;
        boolean isFrequency = false;
        String quantity = null;
        String frequency = null;
        int id = getAllToys().size() + 1;
        System.out.println("Введите название игрушки:");
        String name = scanner.nextLine();
        while (!isPositiveDigit) {
            System.out.println("Введите количество игрушек:");
            quantity = scanner.nextLine();
            if (isPositiveDigit(quantity)) {
                isPositiveDigit = true;
            } else {
                System.out.println("Введите положительную цифру");
            }
        }
        while (!isFrequency) {
            System.out.println("Введите шанс получения игрушки:");
            frequency = scanner.nextLine();
            if (isFrequency(frequency)) {
                isFrequency = true;
            } else {
                System.out.println("Введите шанс получения игрушки от 1 до 9");
            }
        }
        ModelService.addToy(new Toy(id, name, Integer.parseInt(quantity), Integer.parseInt(frequency)));
        System.out.println("Игрушка добавлена");
    }

    @Override
    public void showAllToys() {
        List<Toy> toys = getAllToys();
        if (!toys.isEmpty()) {
            for (Toy toy : toys) {
                System.out.println(toy);
            }
        } else {
            System.out.println("Список игрушек пуст");
        }
    }

    @Override
    public Toy getToyById(List<Toy> toys, int id) {
        if (!toys.isEmpty()) {
            for (Toy toy : toys) {
                if (toy.getId().equals(id)) {
                    return toy;
                }
            }
        }
        return null;
    }

    @Override
    public List<Toy> getAllToys() {
        return ModelService.getAllToys();
    }

    @Override
    public void changeToyFrequency() {
        boolean isChanged = false;
        boolean isFrequency = false;
        String frequency;
        List<Toy> toys = ModelService.getAllToys();
        if (!toys.isEmpty()) {
            while (!isChanged) {
                System.out.println("Введите id игрушки для изменения частоты выпадения игрушки");
                String id = scanner.nextLine();
                if (isPositiveDigit(id)) {
                    Toy toy = getToyById(toys, Integer.parseInt(id));
                    if (Objects.nonNull(toy)) {
                        while (!isFrequency) {
                            System.out.println("Введите шанс получения игрушки от 1 до 9");
                            frequency = scanner.nextLine();
                            if (isFrequency(frequency)) {
                                toy.setFrequency(Integer.parseInt(frequency));
                                ModelService.saveAllToys(toys);
                                isFrequency = true;
                                isChanged = true;
                                System.out.println("Шанс игрушки с id " + id + " обновлён");
                            } else {
                                System.out.println("Введите шанс получения игрушки от 1 до 9");
                            }
                        }
                    }
                } else {
                    System.out.println("Вы ввели не корректный id игрушки, повторите ввод");
                }
            }
        } else {
            System.out.println("Список игрушек пуст");
        }
    }

    @Override
    public void deleteToyById() {
        List<Toy> toys = ModelService.getAllToys();
        System.out.println("Введите id игрушки для удаления игрушки");
        String id = scanner.nextLine();
        if (isPositiveDigit(id)) {
            if (!toys.isEmpty()) {
                if (toys.remove(getToyById(toys, Integer.parseInt(id)))) {
                    System.out.println("Игрушка с id " + id + " удалена");
                    ModelService.saveAllToys(toys);
                } else {
                    System.out.println("Игрушка с id " + id + " не найдена");
                }
            }
        } else {
            System.out.println("Вы ввели не корректный id игрушки, повторите операцию");
        }
    }

    private boolean isPositiveDigit(String line) {
        try {
            return Integer.parseInt(line) >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isFrequency(String line) {
        try {
            return line.matches("[1-9]");
        } catch (NumberFormatException e) {
            return false;
        }
    }
}