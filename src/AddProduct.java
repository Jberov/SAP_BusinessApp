public class AddProduct implements Add{
    private Product product;
    public AddProduct(Product product){
        this.product = product;
    }

    @Override
    public void execute() {
        product.redact ();
    }
}
