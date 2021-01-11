package CommandPattern.AdminCommandPattern;

import DAO.AdministratorDAOImpl;

public class RedactAdminNameCommand implements RedactAdminCommandInterface {
    private  final AdministratorDAOImpl admin;

    public RedactAdminNameCommand(AdministratorDAOImpl admin) {
        this.admin = admin;
    }
    @Override
    public boolean execute(String username, String name){
        return admin.redactPassword (username, name);
    }
}
