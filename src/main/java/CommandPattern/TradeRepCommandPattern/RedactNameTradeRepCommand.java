package CommandPattern.TradeRepCommandPattern;

import CommandPattern.AdminCommandPattern.RedactAdminCommandInterface;
import DAO.TraderDAOImpl;

public class RedactNameTradeRepCommand implements RedactAdminCommandInterface {
    private  final TraderDAOImpl trader;

    public RedactNameTradeRepCommand(TraderDAOImpl admin) {
        this.trader = admin;
    }
    @Override
    public boolean execute(String username, String name){
        return trader.redactName (username, name);
    }
}

