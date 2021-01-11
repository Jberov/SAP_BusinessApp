package CommandPattern.ProductsCommandPattern;

import DAO.ProductsDAOImpl;

public class RedactProductPriceCommand {
    private final ProductsDAOImpl product;

    public  RedactProductPriceCommand(ProductsDAOImpl product) {
        this.product = product;
    }
    public boolean execute(String username, double price){
        return product.redactPrice (username, price);
    }
}
