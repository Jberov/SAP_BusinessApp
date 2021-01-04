package CommandPattern;

import DAO.LoginDAO;

public class TradeRepLoginCommand implements Command{
    private final LoginDAO login;

    public TradeRepLoginCommand(LoginDAO login) {
        this.login = login;
    }

    @Override
    public void execute() {
        login.loginTradeRep ();
    }
}
