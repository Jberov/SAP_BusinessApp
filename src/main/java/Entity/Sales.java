package Entity;

import java.sql.Timestamp;
import java.util.Date;


public class Sales {
    Timestamp time_of_sale;
    int quantity;
    long ID;

    public long getIdOfProduct() {
        return IdOfProduct;
    }

    public void setIdOfProduct(long idOfProduct) {
        IdOfProduct = idOfProduct;
    }

    public long getIdOfClient() {
        return IdOfClient;
    }

    public void setIdOfClient(long idOfClient) {
        IdOfClient = idOfClient;
    }

    public long getIdOfTrader() {
        return IdOfTrader;
    }

    public void setIdOfTrader(long idOfTrader) {
        IdOfTrader = idOfTrader;
    }

    long IdOfProduct;
    long IdOfClient;
    long IdOfTrader;
    String nameOfProduct;
    double TotalPrice;
    String NameOfClient, NameOfTradeRep;

    public Date getTime_of_sale() {
        return time_of_sale;
    }

    public void setTime_of_sale(Timestamp time_of_sale) {
        this.time_of_sale = time_of_sale;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        TotalPrice = totalPrice;
    }

    public String getNameOfClient() {
        return NameOfClient;
    }

    public void setNameOfClient(String nameOfClient) {
        NameOfClient = nameOfClient;
    }

    public String getNameOfTradeRep() {
        return NameOfTradeRep;
    }

    public void setNameOfTradeRep(String nameOfTradeRep) {
        NameOfTradeRep = nameOfTradeRep;
    }

}
