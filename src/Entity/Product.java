package Entity;

public class Product {
    private double price;
    private String name;
    private long ID = 0;
    //HashMap<String, Entity.Product> products = new HashMap<> ();

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
    //TODO Save the information to a DB
    /*


    public void redactProduct() {
        System.out.println("Enter the name of the product you wish to redact");
        try {
            if(!products.containsKey (scan.nextLine ())){
                System.out.println ("No such Trade representative");

            }else{
                Entity.Product temp = products.get (name);
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
            System.out.println ("Entity.Product successfully redacted");
        }
    }
    public void removeProduct() {
        System.out.println("Enter the name of the product you wish to remove");
        products.remove(scan.nextLine ());
    }*/
}
