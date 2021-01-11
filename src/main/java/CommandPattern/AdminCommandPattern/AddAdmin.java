package CommandPattern.AdminCommandPattern;

import CommandPattern.AddUsersCommandInterface;
import DAO.AdministratorDAOImpl;

public class AddAdmin implements AddUsersCommandInterface {
    private final AdministratorDAOImpl admin;
    public AddAdmin(AdministratorDAOImpl admin){
        this.admin = admin;
    }

    @Override
    public boolean execute(String username, String email, String password, String name) {
        return admin.addAdmin (username, email, password, name);
    }
}
