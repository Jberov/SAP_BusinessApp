
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Product implements Operations {
    double price;
    String name;
    long ID = 0;
    HashMap<String, Product> products = new HashMap<> ();
    Scanner scan = new Scanner(System.in);
    //TODO Save the information to a DB
    @Override
    public void add() {

        Product temp = new Product ();
        try {
            System.out.println ("You wish to add a new product. Very well");
            System.out.println ("Please enter the name of the product");
            temp.name = scan.nextLine ().toLowerCase ();
            System.out.println ("Please enter the price of the product");
            temp.price = scan.nextDouble ();

        } catch (InputMismatchException inme) {
            System.out.println ("Enter a valid value. Use coma for the decimal point");
        }
        products.put (temp.name, temp);
    }
    @Override
    public void redact() {
        System.out.println("Enter the name of the product you wish to redact");
        try {
            if(!products.containsKey (scan.nextLine ())){
                System.out.println ("No such Trade representative");

            }else{
                Product temp = products.get (name);
            System.out.println("What would you like to redact: name or price?");
            String choice = scan.nextLine().toLowerCase();
            switch (choice) {
                case "name" -> {

                    System.out.println("Enter the new name of the product:");
                    temp.name = scan.nextLine();
                    products.put (temp.name, temp);
                }
                case "price" -> {
                    System.out.println("Enter the new price of the product:");
                    temp.price = scan.nextDouble();
                    products.put (temp.name, temp);
                }
            }
        }
    }
    catch (IndexOutOfBoundsException iobe) {
            System.out.println("No such product found");
        } finally {
            System.out.println ("Product successfully redacted");
        }
    }

    @Override
    public void remove() {
        System.out.println("Enter the name of the product you wish to remove");
        products.remove(scan.nextLine ());
    }
}
