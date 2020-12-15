public class RemoveClient implements Command {
    private TradeRep trader;
    public RemoveClient(TradeRep trader){
        this.trader = trader;
    }

    @Override
    public void execute() {
        trader.redactClient ();
    }
}
