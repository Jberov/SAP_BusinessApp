package CommandPattern.TradeRepCommandPattern;

import CommandPattern.AdminCommandPattern.RedactAdminCommandInterface;
import DAO.TraderDAOImpl;

public class RedactPasswordTradeRepCommand implements RedactAdminCommandInterface {
    private  final TraderDAOImpl trader;

    public RedactPasswordTradeRepCommand(TraderDAOImpl trader) {
        this.trader = trader;
    }
    @Override
    public boolean execute(String username, String password){
        return trader.redactPassword (username, password);
    }
}
