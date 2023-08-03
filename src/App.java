import controller.Controller;
import view.IView;
import services.*;
import view.AdminView;
import view.MainView;
import view.UserView;

public class App {
    public static void main(String[] args) {
        IView mainView = new MainView();
        IView adminView = new AdminView();
        IView userView = new UserView();
        IAdminService adminService = new AdminService();
        IUserService userService = new UserService();
        Controller controller = new Controller(mainView, adminView, userView, adminService, userService);
        controller.run();
    }
}