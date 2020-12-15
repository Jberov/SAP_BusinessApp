
    public class RedactClient implements Command {
        private TradeRep trader;
        public RedactClient(TradeRep trader){
            this.trader = trader;
        }

        @Override
        public void execute() {
            trader.redactClient ();
        }
    }

