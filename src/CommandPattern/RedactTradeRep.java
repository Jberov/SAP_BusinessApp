package CommandPattern;


import DAO.TraderDAOImpl;


public class RedactTradeRep implements Command {
    private TraderDAOImpl trader;
    public RedactTradeRep(TraderDAOImpl trader){
        this.trader = trader;
    }

    @Override
    public void execute() {
        trader.redactTrader();
    }
}
