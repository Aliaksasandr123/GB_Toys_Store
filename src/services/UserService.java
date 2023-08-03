package services;

import model.Toy;
import utils.ToyFrequencyComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class UserService implements IUserService {
    @Override
    public void play() {
        List<Toy> toys = ModelService.getAllToys();
        List<Toy> prizeList = new ArrayList<>();
        if (!toys.isEmpty()) {
            PriorityQueue<Toy> prizeToys = new PriorityQueue<>(new ToyFrequencyComparator());
            for (Toy toy : toys) {
                if (toy.getQuantity() > 0) {
                    prizeToys.add(toy);
                }
            }
            Toy toy = prizeToys.poll();
            System.out.println("Вы выиграли игрушку " + Objects.requireNonNull(toy).getName());
            prizeList.add(toy);
            Objects.requireNonNull(toy).setQuantity(toy.getQuantity() - 1);
            ModelService.saveAllToys(toys);
            ModelService.saveAllPrizeToys(prizeList);
        } else {
            System.out.println("Нет игрушек для розыгрыша");
        }
    }

    @Override
    public void showAllPrizeToys() {
        List<String> prizeToys = ModelService.getAllPrizeToys();
        if (!prizeToys.isEmpty()) {
            for (String toy : prizeToys) {
                System.out.println(toy);
            }
        } else {
            System.out.println("Нет выигранных игрушек. Поучаствуйте в розыгрыше игрушек");
        }
    }

    @Override
    public void getPrizeToy() {
        List<String> prizeToys = ModelService.getAllPrizeToys();
        if (!prizeToys.isEmpty()) {
            String toy = prizeToys.remove(0);
            System.out.println("Игрушка " + toy + " выдана");
            ModelService.reSaveAllPrizeToys(prizeToys);
        } else {
            System.out.println("Нет выигранных игрушек для выдачи");
        }
    }
}