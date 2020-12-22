package CommandPattern;

import CommandPattern.Command;
import DAO.ProductsDAOImpl;

public class DeleteProduct implements Command {
    private ProductsDAOImpl product;
    public DeleteProduct(ProductsDAOImpl product){
        this.product = product;
    }

    @Override
    public void execute() {
        product.removeProduct ();
    }
}
