public class AddTradeRep implements Command{
    private Administrator admin;
    public AddTradeRep(Administrator admin){
        this.admin = admin;
    }

    @Override
    public void execute() {
        admin.addTradeRep ();
    }
}
