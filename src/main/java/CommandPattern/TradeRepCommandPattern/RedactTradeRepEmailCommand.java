package CommandPattern.TradeRepCommandPattern;

import CommandPattern.AdminCommandPattern.RedactAdminCommandInterface;
import DAO.TraderDAOImpl;

public class RedactTradeRepEmailCommand implements RedactAdminCommandInterface {
    private  final TraderDAOImpl trader;

    public RedactTradeRepEmailCommand(TraderDAOImpl admin) {
        this.trader = admin;
    }
    @Override
    public boolean execute(String username, String email){
        return trader.redactEmail (username, email);
    }
}
