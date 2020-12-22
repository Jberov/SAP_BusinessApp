package CommandPattern;

import DAO.SalesDAOImpl;
import Entity.Sales;

public class AddSale implements Command {
    private SalesDAOImpl sale;
    public AddSale(SalesDAOImpl sale){
        this.sale = sale;
    }

    @Override
    public void execute() {
        sale.addSale ();
    }
}
