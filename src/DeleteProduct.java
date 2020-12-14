public class DeleteProduct implements Load {
    private Product product;
    public DeleteProduct(Product product){
        this.product = product;
    }

    @Override
    public void execute() {
        product.remove ();
    }
}
