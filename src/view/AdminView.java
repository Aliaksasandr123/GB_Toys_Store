package view;

import java.util.Scanner;

public class AdminView implements IView {
    @Override
    public void printMenu() {
        System.out.println("""
                \t------- Режим Администратора -------
                0 - Добавить игрушку
                1 - Показать все игрушки
                2 - Изменить вес(частота выпадения игрушки от 1 до 9) игрушки по id
                3 - Удалить игрушку по id
                4 - Вернуться в предыдущее меню""");
    }

    @Override
    public String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
}