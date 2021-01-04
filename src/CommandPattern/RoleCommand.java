package CommandPattern;

import DAO.LoginDAO;

public class RoleCommand implements Command{
    private final LoginDAO login;

    public RoleCommand(LoginDAO login) {
        this.login = login;
    }

    @Override
    public void execute() {
        login.roleSetter ();
    }
}
