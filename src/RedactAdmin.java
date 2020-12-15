public class RedactAdmin implements Command{
    private Administrator admin;
    public RedactAdmin(Administrator admin){
        this.admin = admin;
    }
    @Override
    public void execute() {
        admin.redactAdmin ();
    }
}
