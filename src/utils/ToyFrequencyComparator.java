package utils;

import model.Toy;

import java.util.Comparator;
import java.util.Objects;

public class ToyFrequencyComparator implements Comparator<Toy> {
    /**
     * Метод сортировки Игрушек по частоте выигрыша(по убыванию)
     */
    @Override
    public int compare(Toy o1, Toy o2) {
        if (Objects.equals(o1.getFrequency(), o2.getFrequency())) {
            return 0;
        } else if (o1.getFrequency() > o2.getFrequency()) {
            return -1;
        } else
            return 1;
    }
}