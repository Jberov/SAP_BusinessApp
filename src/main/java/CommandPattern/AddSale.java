package CommandPattern;

import DAO.SalesDAOImpl;


public class AddSale{
    private final SalesDAOImpl sale;
    public AddSale(SalesDAOImpl sale){
        this.sale = sale;
    }
    public boolean execute(String product, String client, int quantity, String trader) {
        return sale.addSale (product, client, quantity, trader);
    }
}
