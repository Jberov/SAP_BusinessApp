package DAO;
import DatabaseUtility.DBConnectionHandler;
import Entity.Sales;
import Mail.MailSender;

import javax.swing.*;
import java.sql.*;

public class SalesDAOImpl implements  SalesDAOInterface{
    DBConnectionHandler database = DBConnectionHandler.getInstance ();

    @Override
    public boolean addSale(String product, String client, int quantity, String trader) {
        Sales temp = new Sales ();
        temp.setNameOfProduct (product);
        temp.setNameOfClient (client);
        temp.setQuantity (quantity);
        if(!productValidator(temp,product)){
            JOptionPane.showMessageDialog (new JPanel (), "No such product");
            return false;
        }
        if(!clientValidator(temp,client)){
            JOptionPane.showMessageDialog (new JPanel (), "No such client");
            return false;
        }
        temp.setTotalPrice (TotalPrice (temp.getQuantity (), getPriceFromDB (temp)));
        temp.setNameOfTradeRep (trader);
        if(!traderValidator(temp, trader)){
            JOptionPane.showMessageDialog (new JPanel (), "No such trader");
            return false;
        }
        return addSaleToDB (temp, product);
    }
    private double TotalPrice(int quantity, double price){
        return quantity*price;
    }
    private boolean clientValidator(Sales temp, String clientName) {
            try {
                    PreparedStatement result = database.setDBConnection ().prepareStatement ("select * from clients where  Name=? ");
                    result.setString (1, clientName);
                    ResultSet rs = result.executeQuery ();
                    if (!rs.next ()) {
                        JOptionPane.showMessageDialog (new JPanel (), "No such client");
                        return false;
                    } else if(clientName.equals (rs.getString (2))){
                        temp.setIdOfClient (rs.getLong (1));
                        return true;
                    }
            } catch (SQLException SQLEx) {
                JOptionPane.showMessageDialog (new JPanel (), "Error connecting to database");
                SQLEx.printStackTrace ();
                return false;
            }
            return true;
    }
    private boolean productValidator(Sales temp, String prod){
            try {
                PreparedStatement result = database.setDBConnection ().prepareStatement ("select * from products where Name=? ");
                result.setString (1, prod);
                ResultSet rs = result.executeQuery ();
                if (!rs.next ()) {
                    JOptionPane.showMessageDialog (new JPanel (), "No such product");
                    return false;
                } else if (prod.equals (rs.getString ("Name"))) {
                    temp.setIdOfProduct (rs.getLong ("Id"));
                    if (temp.getQuantity () > rs.getInt ("Quantity")) {
                        JOptionPane.showMessageDialog (new JPanel (), "Not enough product in stock!");
                        return false;
                    } else {
                        return true;
                    }
                }
            }catch (SQLException SQLEx) {
                JOptionPane.showMessageDialog (new JPanel (), "Error connecting to database");
                SQLEx.printStackTrace ();
                return false;
            }
        return false;
    }
    private boolean traderValidator(Sales temp, String trader){
            try {
                    PreparedStatement result = database.setDBConnection ().prepareStatement ("select * from tradereps where  Username=? ");
                    result.setString (1, trader);
                    ResultSet rs = result.executeQuery ();
                    if (!rs.next ()) {
                        JOptionPane.showMessageDialog (new JPanel (), "No such trader");
                        return false;
                    } else if(trader.equals (rs.getString (4))){
                        temp.setIdOfTrader (rs.getLong (1));
                        return true;
                    }
            } catch (SQLException SQLEx) {
                JOptionPane.showMessageDialog (new JPanel (), "Error connecting to database");
                SQLEx.printStackTrace ();
                return false;
            }
            return false;
    }
    private boolean addSaleToDB(Sales temp, String product){
        try {
            PreparedStatement pstmt =database.setDBConnection ().prepareStatement ("insert into sales(IdOfSale,TimeOfSale, Quantity, IdOfProduct, TotalPrice, IdofClient, TradeRepId) values(NULL,CURRENT_TIMESTAMP,?,?,?,?,?)");
            pstmt.setInt (1, temp.getQuantity ());
            pstmt.setLong (2, temp.getIdOfProduct ());
            pstmt.setDouble (3, temp.getTotalPrice ());
            pstmt.setLong (4, temp.getIdOfClient ());
            pstmt.setLong (5, temp.getIdOfTrader ());
            pstmt.execute ();
            pstmt = database.setDBConnection ().prepareStatement ("select Quantity from products where Id=?");
            pstmt.setLong (1, temp.getIdOfProduct ());
            ResultSet set  = pstmt.executeQuery ();
            set.next ();
            pstmt = database.setDBConnection ().prepareStatement ("update products set Quantity = ? where Id=?");
            int newQuantity = set.getInt ("Quantity") - temp.getQuantity ();
            System.out.println (newQuantity);
            pstmt.setInt (1, newQuantity);
            pstmt.setLong (2, temp.getIdOfProduct ());
            pstmt.execute ();
            pstmt = database.setDBConnection ().prepareStatement ("select Quantity from products where Id=?");
            pstmt.setLong (1, temp.getIdOfProduct ());
            set = pstmt.executeQuery ();
            if(set.next ()){
                if(set.getInt ("Quantity") <= 30){
                    MailSender mail = new MailSender ();
                    mail.sendmail ("Low stocks of product " + product +". \n Please restock.", product);
                    return true;
                }
            }else{
                return false;
            }
            database.shutDB ();
            return true;
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog (new JPanel (), "Error connecting to database");
            sqle.printStackTrace ();
        }catch (Exception e){
            e.printStackTrace ();
        }
        return false;
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
            JOptionPane.showMessageDialog (new JPanel (), "Error connecting to database");
            s.printStackTrace ();
        }
        return price;
    }
}
