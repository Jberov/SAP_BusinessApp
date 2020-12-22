package CommandPattern;

import CommandPattern.Command;
import DAO.AdministratorDAOImpl;

public class RemoveAdmin implements Command {
    private AdministratorDAOImpl admin;
    public RemoveAdmin(AdministratorDAOImpl admin){
        this.admin = admin;
    }
    @Override
    public void execute() {
        admin.removeAdmin ();
    }
}
