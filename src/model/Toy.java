package model;

import java.util.Objects;

public class Toy {
    private Integer id;
    private String name;
    private Integer quantity;
    private Integer frequency;

    /**
     * Конструктор класса
     *
     * @param id        id Игрушки
     * @param name      Название игрушки
     * @param quantity  Количество игрушек
     * @param frequency Частота выпадения игрушки
     */
    public Toy(Integer id, String name, Integer quantity, Integer frequency) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return Objects.equals(id, toy.id) && Objects.equals(name, toy.name) && Objects.equals(quantity, toy.quantity) && Objects.equals(frequency, toy.frequency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity, frequency);
    }

    @Override
    public String toString() {
        return "Игрушка{" +
                "id=" + id +
                ", Название='" + name + '\'' +
                ", Количество=" + quantity +
                ", Частота выпадения=" + frequency +
                '}';
    }
}