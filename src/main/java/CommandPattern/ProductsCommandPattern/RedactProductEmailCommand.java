package CommandPattern.ProductsCommandPattern;

import DAO.ProductsDAOImpl;

public class RedactProductEmailCommand {
    private final ProductsDAOImpl product;

    public  RedactProductEmailCommand(ProductsDAOImpl product) {
        this.product = product;
    }
    public boolean execute(String username, String email){
        return product.redactTraderEmail (username, email);
    }
}
