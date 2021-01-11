package CommandPattern.ProductsCommandPattern;

import DAO.ProductsDAOImpl;

public class RedactProductNameCommand {
    private  final ProductsDAOImpl product;

    public  RedactProductNameCommand(ProductsDAOImpl product) {
        this.product = product;
    }
    public boolean execute(String username, String name){
        return product.redactName (username, name);
    }
}
