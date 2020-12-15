public class RedactProduct implements Command {
    private Product product;
    public RedactProduct(Product product){
        this.product = product;
    }

    @Override
    public void execute() {
        product.redactProduct ();
    }
}
