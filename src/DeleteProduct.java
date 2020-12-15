public class DeleteProduct implements Command {
    private Product product;
    public DeleteProduct(Product product){
        this.product = product;
    }

    @Override
    public void execute() {
        product.removeProduct ();
    }
}
