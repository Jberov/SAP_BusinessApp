public class AddProduct implements Command {
    private Product product;
    public AddProduct(Product product){
        this.product = product;
    }

    @Override
    public void execute() {
        product.addProduct ();
    }
}
