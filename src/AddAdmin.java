public class AddAdmin implements Command{
    private Administrator admin;
    public AddAdmin(Administrator admin){
        this.admin = admin;
    }

    @Override
    public void execute() {
        admin.addAdmin ();
    }
}
