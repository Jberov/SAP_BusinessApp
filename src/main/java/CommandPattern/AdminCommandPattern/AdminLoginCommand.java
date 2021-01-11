package CommandPattern.AdminCommandPattern;

import CommandPattern.LoginCommand;
import DAO.LoginDAO;



public class AdminLoginCommand implements LoginCommand {
    private final LoginDAO login;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    private String username, password;
    public AdminLoginCommand(LoginDAO login) {
        this.login = login;
    }

    @Override
    public boolean execute(String input1, String input2) {
        setUsername (input1);
        setPassword (input2);
        return login.loginAdmin (getUsername (), getPassword ());

    }
}
