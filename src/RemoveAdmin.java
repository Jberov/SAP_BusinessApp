public class RemoveAdmin implements Command{
    private Administrator admin;
    public RemoveAdmin(Administrator admin){
        this.admin = admin;
    }
    @Override
    public void execute() {
        admin.removeAdmin ();
    }
}
