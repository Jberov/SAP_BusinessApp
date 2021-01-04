package CommandPattern;

import DAO.LoginDAO;

public class AdminLoginCommand implements Command{
    private final LoginDAO login;

    public AdminLoginCommand(LoginDAO login) {
        this.login = login;
    }

    @Override
    public void execute() {
        login.loginAdmin ();
    }
}
