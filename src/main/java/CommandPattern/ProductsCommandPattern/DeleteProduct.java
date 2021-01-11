package CommandPattern.ProductsCommandPattern;

import CommandPattern.Command;
import CommandPattern.DeleteUsersCommandInterface;
import DAO.ProductsDAOImpl;

public class DeleteProduct implements DeleteUsersCommandInterface {
    private ProductsDAOImpl product;
    public DeleteProduct(ProductsDAOImpl product){
        this.product = product;
    }

    @Override
    public boolean execute(String name) {
        return product.removeProduct (name);
    }
}
