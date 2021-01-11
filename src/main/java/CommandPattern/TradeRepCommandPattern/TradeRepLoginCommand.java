package CommandPattern.TradeRepCommandPattern;

import CommandPattern.LoginCommand;
import DAO.LoginDAO;

public class TradeRepLoginCommand implements LoginCommand {
    private final LoginDAO login;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username, password;
    public TradeRepLoginCommand(LoginDAO login) {
        this.login = login;
    }

    @Override
    public boolean execute(String userInput, String userPass) {
        setUsername (userInput);
        setPassword (userPass);
        return login.loginTradeRep (getUsername (), getPassword ());
        }
    }

