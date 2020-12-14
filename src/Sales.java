import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Sales {
    Scanner scan = new Scanner(System.in);
    public Date getTime_of_sale() {
        return time_of_sale;
    }

    public void setTime_of_sale(Date date) {
        this.time_of_sale = new Timestamp (date.getTime ());
    }

    Date time_of_sale;
    int quantity;
    long ID;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity() {
        System.out.println ("How much did you sell");
        this.quantity = scan.nextInt ();
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct() {
        System.out.println ("Hello. Congratulations on the sale. Now, let's add some details, shall we? \n What did you sell" );
        this.nameOfProduct = scan.nextLine().toLowerCase ();
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(Product product, Sales temp) {
        TotalPrice = getQuantity ()*(product.products.get(temp.nameOfProduct).price);
    }

    public String getNameOfClient() {
        return NameOfClient;
    }

    public void setNameOfClient() {
        NameOfClient = scan.nextLine();
    }

    public String getNameOfTradeRep() {
        return NameOfTradeRep;
    }

    public void setNameOfTradeRep(Login user) {
        NameOfTradeRep = user.getUsername ();
    }

    String nameOfProduct;
    double TotalPrice;
    String NameOfClient, NameOfTradeRep;
    ArrayList<Sales> sales = new ArrayList<>();

    public void addSale(){
        Login user = new Login ();
        Date date = new Date ();
        Sales temp = new Sales ();
        Product product = new Product ();
        setNameOfProduct ();
        setNameOfClient ();
        setQuantity ();
        setTotalPrice (product, temp);
        setNameOfTradeRep (user);
        setTime_of_sale (date);
        time_of_sale = getTime_of_sale ();
        temp.nameOfProduct = getNameOfProduct ();
        temp.quantity = getQuantity ();
        temp.TotalPrice = getTotalPrice ();
        temp.NameOfClient = getNameOfClient ();
        temp.NameOfTradeRep = getNameOfTradeRep ();
        sales.add (temp);
    }


}
