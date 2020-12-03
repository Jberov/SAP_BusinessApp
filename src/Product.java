
import java.util.LinkedList;
import java.util.Scanner;

public class Product implements Operations {
    double price;
    String name;
    long ID = 0;
    LinkedList<Product> products = new LinkedList<>();
    Scanner scan = new Scanner(System.in);
    //TODO Save the information to a DB
    @Override
    public void add() {

        Product temp = new Product();
        if (products == null) {
            temp.ID = 1;
        } else {
            temp.ID = products.getLast().ID + 1;
        }
        System.out.println("You wish to add a new product. Very well");
        System.out.println("Please enter the name of the product");
        temp.name = scan.nextLine().toLowerCase();
        System.out.println("Please enter the name of the product");
        temp.price = scan.nextDouble();
        products.add(temp);
    }

    @Override
    public void redact() {
        System.out.println("Enter the name of the product you wish to redact");
        try {
            for (Product i : products) {
                if (i.name.equals(scan.nextLine())) {
                    System.out.println("What would you like to redact: name or price?");
                    String choice = scan.nextLine().toLowerCase();
                    switch (choice) {
                        case "name" -> {
                            System.out.println("Enter the new name of the product:");
                            i.name = scan.nextLine();
                        }
                        case "price" -> {
                            System.out.println("Enter the new price of the product:");
                            i.price = scan.nextDouble();
                        }
                    }
                }
            }
        } catch (IndexOutOfBoundsException iobe) {
            System.out.println("No such product found");
        }
    }

    @Override
    public void remove() {
        System.out.println("Enter the name of the product you wish to redact");
        try {
            products.removeIf(i -> i.name.equals(scan.nextLine()));
        } catch (IndexOutOfBoundsException iobe) {
            System.out.println("No such product found");
        }
    }
}
