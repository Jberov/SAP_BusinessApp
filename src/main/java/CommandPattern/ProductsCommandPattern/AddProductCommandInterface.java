package CommandPattern.ProductsCommandPattern;

public interface AddProductCommandInterface {
    boolean execute(String name, double price, int quantity, String email);
}
