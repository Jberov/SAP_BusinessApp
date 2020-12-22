package CommandPattern;

import CommandPattern.Command;
import DAO.AdministratorDAOImpl;

public class RedactAdmin implements Command {
    private AdministratorDAOImpl admin;
    public RedactAdmin(AdministratorDAOImpl admin){
        this.admin = admin;
    }
    @Override
    public void execute() {
        admin.redactAdmin ();
    }
}
