public class AddSale implements Add{
    private Sales sale;
    public AddSale(Sales sale){
        this.sale = sale;
    }

    @Override
    public void execute() {
        sale.addSale ();
    }
}
