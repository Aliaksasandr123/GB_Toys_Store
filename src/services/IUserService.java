package services;

public interface IUserService {
    /**
     * Метод розыгрыша игрушек
     */
    void play();

    /**
     * Метод отображения всех выигранных игрушек
     */
    void showAllPrizeToys();

    /**
     * Метод получения выигранной игрушки
     */
    void getPrizeToy();
}