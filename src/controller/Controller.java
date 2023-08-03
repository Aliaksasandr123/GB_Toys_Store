package controller;

import services.IAdminService;
import services.IUserService;
import view.IView;

public class Controller {
    private final IView mainView;
    private final IView adminView;
    private final IView userView;
    private final IAdminService adminService;
    private final IUserService userService;

    /**
     * Конструктор класса контроллера
     *
     * @param mainView     Главное меню
     * @param adminView    Меню Администратора
     * @param userView     Меню Пользователя
     * @param adminService Сервисы для Администратора
     * @param userService  Сервисы для Пользователя
     */
    public Controller(IView mainView, IView adminView, IView userView, IAdminService adminService, IUserService userService) {
        this.mainView = mainView;
        this.adminView = adminView;
        this.userView = userView;
        this.adminService = adminService;
        this.userService = userService;
    }

    /**
     * Метод отображения меню и управления ответом от пользователя
     */
    public void run() {
        StoreCommands com = StoreCommands.NONE;
        boolean getNewIteration = true;
        while (getNewIteration) {
            mainView.printMenu();
            String command = mainView.prompt("Введите команду:");
            if (isStoreCommand(command)) {
                com = StoreCommands.valueOf(command.toUpperCase());
                switch (com) {
                    case EXIT -> {
                        getNewIteration = false;
                        System.out.println("Выход из программы!");
                    }
                    case ADMIN -> {
                        boolean adminIteration = true;
                        while (adminIteration) {
                            adminView.printMenu();
                            String number = adminView.prompt("Введите номер операции:");
                            if (isDigit(number)) {
                                switch (number) {
                                    case "0" -> adminService.addToy();
                                    case "1" -> adminService.showAllToys();
                                    case "2" -> adminService.changeToyFrequency();
                                    case "3" -> adminService.deleteToyById();
                                    case "4" -> adminIteration = false;
                                    default ->
                                            System.out.println("Вы ввели не корректный номер операции, повторите ввод");
                                }
                            } else {
                                System.out.println("Введите номер операции от 0 до 4");
                            }
                        }
                    }
                    case USER -> {
                        boolean userIteration = true;
                        while (userIteration) {
                            userView.printMenu();
                            String number = adminView.prompt("Введите номер операции:");
                            if (isDigit(number)) {
                                switch (number) {
                                    case "0" -> userService.play();
                                    case "1" -> userService.showAllPrizeToys();
                                    case "2" -> userService.getPrizeToy();
                                    case "3" -> userIteration = false;
                                    default ->
                                            System.out.println("Вы ввели не корректный номер операции, повторите ввод");
                                }
                            } else {
                                System.out.println("Введите номер операции от 0 до 3");
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean isStoreCommand(String command) {
        try {
            StoreCommands.valueOf(command.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Вы ввели не корректную команду. Повторите ввод команды");
            return false;
        }
    }

    private boolean isDigit(String line) {
        try {
            Integer.parseInt(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}