package DAO;
import DatabaseUtility.DBConnectionHandler;
import Entity.Sales;

import java.sql.*;

public class SalesDAOImpl implements  SalesDAOInterface{
    Console console = Console.getInstance ();
    DBConnectionHandler database = DBConnectionHandler.getInstance ();

    @Override
    public void addSale() {
        Sales temp = new Sales ();
        productValidator(temp);
        clientValidator(temp);
        console.printLine ("Enter the quantity of the product being sold: ");
        temp.setQuantity (console.readInt ());
        temp.setTotalPrice (TotalPrice (temp.getQuantity (), getPriceFromDB (temp)));
        traderValidator(temp);
        addSaleToDB (temp);
    }
    private double TotalPrice(int quantity, double price){
        return quantity*price;
    }
    private void clientValidator(Sales temp) {
            try {
                while (true) {
                    console.printLine ("Enter the name of your client :");
                    String tempTrader = console.readLine ();
                    PreparedStatement result = database.setDBConnection ().prepareStatement ("select * from clients where  Name=? ");
                    result.setString (1, tempTrader);
                    ResultSet rs = result.executeQuery ();
                    if (!rs.next ()) {
                        console.printLine ("No such client. Please enter again");
                    } else if(tempTrader.equals (rs.getString (2))){
                        console.printLine ("Client found");
                        temp.setIdOfClient (rs.getLong (1));
                        break;
                    }
                }
            } catch (SQLException SQLEx) {
                console.printLine ("Error connecting to database");
                SQLEx.printStackTrace ();
            }
    }
    private void productValidator(Sales temp){
            try {
                while(true) {
                    console.printLine ("Enter the name of the product you sold:");
                    String tempProd = console.readLine ();
                    PreparedStatement result = database.setDBConnection ().prepareStatement ("select * from products where Name=? ");
                    result.setString (1, tempProd);
                    ResultSet rs = result.executeQuery ();
                    if(!rs.next ()){
                        console.printLine ("No such product");
                    }else if(tempProd.equals (rs.getString (2))){
                        console.printLine ("Product found");
                        temp.setIdOfProduct (rs.getLong (1));
                        break;
                    }
                }
            } catch (SQLException SQLEx) {
                console.printLine ("Error connecting to database");
                SQLEx.printStackTrace ();
            }

    }
    private void traderValidator(Sales temp){

            try {
                while (true) {
                    console.printLine ("Enter your username :");
                    String tempTrader = console.readLine ();
                    PreparedStatement result = database.setDBConnection ().prepareStatement ("select * from tradereps where  Username=? ");
                    result.setString (1, tempTrader);
                    ResultSet rs = result.executeQuery ();
                    if (!rs.next ()) {
                        console.printLine ("No such username");
                    } else if(tempTrader.equals (rs.getString (4))){
                        temp.setIdOfTrader (rs.getLong (1));
                        break;
                    }
                }
            } catch (SQLException SQLEx) {
                console.printLine ("Error connecting to database");
                SQLEx.printStackTrace ();
            }
    }
    private void addSaleToDB(Sales temp){
        try {
            PreparedStatement pstmt =database.setDBConnection ().prepareStatement ("insert into sales(IdOfSale,TimeOfSale, Quantity, IdOfProduct, TotalPrice, IdofClient, TradeRepId) values(NULL,CURRENT_TIMESTAMP,?,?,?,?,?)");
            pstmt.setInt (1, temp.getQuantity ());
            pstmt.setLong (2, temp.getIdOfProduct ());
            pstmt.setDouble (3, temp.getTotalPrice ());
            pstmt.setLong (4, temp.getIdOfClient ());
            pstmt.setLong (5, temp.getIdOfTrader ());
            pstmt.execute ();
            database.shutDB ();
        }catch(SQLException sqle){
            console.printLine ("Error connecting to the database");
            sqle.printStackTrace ();
        }
    }
    private double getPriceFromDB(Sales temp){
        double price = 0.00;
        try {
            PreparedStatement result = database.setDBConnection ().prepareStatement ("select * from products where Id=?");
            result.setLong(1, temp.getIdOfProduct ());
            ResultSet rs = result.executeQuery ();
            rs.next ();
            price = rs.getDouble (3);
        }catch ( SQLException s){
            console.printLine ("Error connecting to DB");
            s.printStackTrace ();
        }
        return price;
    }


}
