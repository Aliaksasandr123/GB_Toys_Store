package view;

import java.util.Scanner;

public class UserView implements IView {
    @Override
    public void printMenu() {
        System.out.println("""
                \t------- Режим Пользователя -------
                0 - Участвовать в розыгрыше игрушек
                1 - Посмотреть список выигранных игрушек
                2 - Получить призовую игрушку
                3 - Вернуться в предыдущее меню""");
    }

    @Override
    public String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
}