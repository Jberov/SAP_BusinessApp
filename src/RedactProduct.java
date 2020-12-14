public class RedactProduct implements Load {
    private Product product;
    public RedactProduct(Product product){
        this.product = product;
    }

    @Override
    public void execute() {
        product.redact ();
    }
}
