package CommandPattern.AdminCommandPattern;

import DAO.AdministratorDAOImpl;

public class RedactAdminPassword implements RedactAdminCommandInterface {
    private  final AdministratorDAOImpl admin;

    public RedactAdminPassword(AdministratorDAOImpl admin) {
        this.admin = admin;
    }
    @Override
    public boolean execute(String username, String newUsername){
        return admin.redactPassword (username, newUsername);
    }
}
