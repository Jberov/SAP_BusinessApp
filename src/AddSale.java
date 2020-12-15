public class AddSale implements Command {
    private Sales sale;
    public AddSale(Sales sale){
        this.sale = sale;
    }

    @Override
    public void execute() {
        sale.addSale ();
    }
}
