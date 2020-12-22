package CommandPattern;

import DAO.AdministratorDAOImpl;

public class AddAdmin implements Command {
    private AdministratorDAOImpl admin;
    public AddAdmin(AdministratorDAOImpl admin){
        this.admin = admin;
    }

    @Override
    public void execute() {
        admin.addAdmin ();
    }
}
