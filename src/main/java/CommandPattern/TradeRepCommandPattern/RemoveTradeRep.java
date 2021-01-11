package CommandPattern.TradeRepCommandPattern;


import CommandPattern.DeleteUsersCommandInterface;
import DAO.TraderDAOImpl;

public class RemoveTradeRep implements DeleteUsersCommandInterface {
    private TraderDAOImpl trader;
    public RemoveTradeRep(TraderDAOImpl trader){
        this.trader = trader;
    }

    @Override
    public boolean execute(String username) {
        return trader.removeTrader (username);
    }
}

