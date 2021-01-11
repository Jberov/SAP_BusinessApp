package CommandPattern.TradeRepCommandPattern;

import CommandPattern.AdminCommandPattern.RedactAdminCommandInterface;
import DAO.TraderDAOImpl;

public class RedactTradeRepUsernameCommand implements RedactAdminCommandInterface {
    private  final TraderDAOImpl trader;

    public RedactTradeRepUsernameCommand(TraderDAOImpl trader) {
        this.trader = trader;
    }
    @Override
    public boolean execute(String oldUsername, String newUsername){
        return trader.redactEmail (oldUsername, newUsername);
    }
}
