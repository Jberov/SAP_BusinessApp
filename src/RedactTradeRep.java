public class RedactTradeRep implements Command{
    private Administrator admin;
    public RedactTradeRep(Administrator admin){
        this.admin = admin;
    }

    @Override
    public void execute() {
        admin.redactTradeReps ();
    }
}
