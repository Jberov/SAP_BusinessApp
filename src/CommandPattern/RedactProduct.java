package CommandPattern;

import CommandPattern.Command;
import DAO.ProductsDAOImpl;

public class RedactProduct implements Command {
    private ProductsDAOImpl product;
    public RedactProduct(ProductsDAOImpl product){
        this.product = product;
    }

    @Override
    public void execute() {
        product.redactProduct ();
    }
}
