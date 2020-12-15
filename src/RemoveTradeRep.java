public class RemoveTradeRep implements Command{
    private Administrator admin;
    public RemoveTradeRep(Administrator admin){
        this.admin = admin;
    }

    @Override
    public void execute() {
        admin.removeTradeReps ();
    }
}

