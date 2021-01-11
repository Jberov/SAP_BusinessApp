package CommandPattern.AdminCommandPattern;

import DAO.AdministratorDAOImpl;

public class RedactAdminUsername implements RedactAdminCommandInterface {
    private  final AdministratorDAOImpl admin;

    public RedactAdminUsername(AdministratorDAOImpl admin) {
        this.admin = admin;
    }
    @Override
    public boolean execute(String username, String newUsername){
        return admin.redactUsername (username, newUsername);
    }
}
