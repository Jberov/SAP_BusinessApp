package CommandPattern;

import DAO.ProductsDAOImpl;

public class AddProduct implements Command {
    private ProductsDAOImpl product;
    public AddProduct(ProductsDAOImpl product){
        this.product = product;
    }

    @Override
    public void execute() {
        product.addProduct ();
    }
}
