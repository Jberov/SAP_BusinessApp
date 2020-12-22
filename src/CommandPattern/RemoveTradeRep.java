package CommandPattern;


import DAO.TraderDAOImpl;

public class RemoveTradeRep implements Command {
    private TraderDAOImpl trader;
    public RemoveTradeRep(TraderDAOImpl trader){
        this.trader = trader;
    }

    @Override
    public void execute() {
        trader.removeTrader ();
    }
}

