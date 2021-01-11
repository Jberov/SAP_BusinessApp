package CommandPattern.ProductsCommandPattern;

import DAO.ProductsDAOImpl;

public class RedactProductQuantityCommand {
    private final ProductsDAOImpl product;

    public  RedactProductQuantityCommand(ProductsDAOImpl product) {
        this.product = product;
    }
    public boolean execute(String username, int quantity){
        return product.redactQuantity (username, quantity);
    }
}
