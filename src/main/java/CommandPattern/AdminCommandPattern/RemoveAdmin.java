package CommandPattern.AdminCommandPattern;

import CommandPattern.DeleteUsersCommandInterface;
import DAO.AdministratorDAOImpl;

public class RemoveAdmin implements DeleteUsersCommandInterface {
    private AdministratorDAOImpl admin;
    public RemoveAdmin(AdministratorDAOImpl admin){
        this.admin = admin;
    }
    @Override
    public boolean execute(String username) {
        return admin.removeAdmin (username);
    }
}
