import models.Project;
import models.User;
import service.UserService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserService();
        User user = new User("pleaseGiveMeWork@please.com", "0733659054", "2019-10-12");
        userService.saveUser(user);

        Project project = new Project("dxdigita","house of rising sun");
        user.addProject(project);
    }
}
