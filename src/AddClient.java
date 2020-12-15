public class AddClient implements Command {
    private TradeRep trader;
    public AddClient(TradeRep trader){
        this.trader = trader;
    }

    @Override
    public void execute() {
        trader.addClient ();
    }
}
