package view;

import java.util.Scanner;

public class MainView implements IView {
    @Override
    public void printMenu() {
        System.out.println("""
                \t\t------- Магазин игрушек -------
                Для работы в режиме Администратора, введите: ADMIN
                Для работы в режиме Пользователя, введите: USER
                Для завершения программы, введите: EXIT""");
    }

    @Override
    public String prompt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
}