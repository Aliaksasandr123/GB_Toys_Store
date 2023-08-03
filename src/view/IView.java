package view;

public interface IView {
    /**
     * Метод для отображения меню
     */
    void printMenu();

    /**
     * Метод для отображения сообщения
     *
     * @param message Сообщение
     * @return Возвращает строку, введённую с консоли
     */
    String prompt(String message);
}