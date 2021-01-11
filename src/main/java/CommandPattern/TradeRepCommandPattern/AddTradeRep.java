package CommandPattern.TradeRepCommandPattern;

import CommandPattern.AddUsersCommandInterface;
import DAO.TraderDAOImpl;

public class AddTradeRep implements AddUsersCommandInterface {
    private final TraderDAOImpl trader;
    public AddTradeRep(TraderDAOImpl trader){
        this.trader = trader;
    }

    @Override
    public boolean execute(String username, String email, String password, String name) {
        return trader.addTrader (username,  email,  password,  name);
    }
}
