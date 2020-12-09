import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Sales {
    Date time_of_sale;
    int quantity;
    String nameOfProduct;
    double TotalPrice;
    String NameOfClient, NameOfTradeRep;
    ArrayList<Sales> sales = new ArrayList<>();
    Scanner scan = new Scanner (System.in);
    public void addSale(){
        Login user = new Login ();
        Date date = new Date ();
        Sales temp = new Sales ();
        Product product = new Product ();
        time_of_sale = new Timestamp (date.getTime ());
        System.out.println ("Hello. Congratulations on the sale. Now, let's add some details, shall we? \n What did you sell" );
        temp.nameOfProduct = scan.nextLine().toLowerCase ();
        System.out.println ("How much did you sell");
        temp.quantity = scan.nextInt ();
        temp.TotalPrice = quantity*(product.products.get(temp.nameOfProduct).price);
        System.out.println ("Sold to whom?");
        temp.NameOfClient = scan.nextLine ();
        temp.NameOfTradeRep = user.getUsername ();
        sales.add (temp);
    }


}
