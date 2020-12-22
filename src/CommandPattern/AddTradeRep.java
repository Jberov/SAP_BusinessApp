package CommandPattern;

import DAO.AdministratorDAOImpl;
import DAO.TraderDAOImpl;

public class AddTradeRep implements Command {
    private TraderDAOImpl trader;
    public AddTradeRep(TraderDAOImpl trader){
        this.trader = trader;
    }

    @Override
    public void execute() {
        trader.addTrader ();
    }
}
