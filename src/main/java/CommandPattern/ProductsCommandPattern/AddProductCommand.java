package CommandPattern.ProductsCommandPattern;

import CommandPattern.Command;
import DAO.ProductsDAOImpl;

public class AddProductCommand implements AddProductCommandInterface {
    private final ProductsDAOImpl product;
    public AddProductCommand(ProductsDAOImpl product){
        this.product = product;
    }

    @Override
    public boolean execute(String name, double price, int quantity, String email) {
        return product.addProduct (name, price, quantity, email);
    }
}
