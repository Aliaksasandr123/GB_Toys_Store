package services;

import model.Toy;

import java.util.List;

public interface IAdminService {
    /**
     * Метод добавления игрушки
     */
    void addToy();

    /**
     * Метод отображения всех игрушек
     */
    void showAllToys();

    /**
     * Метод получения игрушки по id
     *
     * @param toys Список игрушек
     * @param id   id игрушки
     * @return метод возвращает экземпляр игрушки или null
     */
    Toy getToyById(List<Toy> toys, int id);

    /**
     * Метод получения списка игрушек
     */
    List<Toy> getAllToys();

    /**
     * Метод изменения частоты выпадения игрушки
     */
    void changeToyFrequency();

    /**
     * Метод удаления игрушки по id
     */
    void deleteToyById();
}