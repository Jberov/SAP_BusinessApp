package DAO;

import DatabaseUtility.DBConnectionHandler;
import Entity.Product;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductsDAOImpl implements ProductsDAOInterface{
    DBConnectionHandler database = DBConnectionHandler.getInstance ();
    @Override
    public boolean addProduct(String name, double price, int quantity, String email) {
        try{
            Product product = new Product ();
            PreparedStatement statement;
                statement = database.setDBConnection ().prepareStatement ("select Name from products where  Name=? ");
                statement.setString (1, name);
                ResultSet rs = statement.executeQuery ();
                if(!rs.next ()){
                    product.setName (name);
                    product.setPrice (price);
                    PreparedStatement auxil = database.setDBConnection ().prepareStatement ("select email from tradereps where email=?");
                    auxil.setString (1, email);
                    ResultSet set = auxil.executeQuery ();
                    if(set.next ()){
                        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
                        Pattern pattern = Pattern.compile (regex);
                        Matcher matcher = pattern.matcher (email);
                        if(matcher.matches ()){
                            product.setEmail (email);
                        }else{
                            JOptionPane.showMessageDialog (new JPanel (), "Invalid email input");
                        }
                    }else{
                        JOptionPane.showMessageDialog (new JPanel (), "There is no such associated email");
                        return false;
                    }
                    product.setQuantity(quantity);
                    addProductToDB (product);
                    return true;

                }
                else if (name.equals (rs.getString (1))) {
                    JOptionPane.showMessageDialog (new JPanel (),"There is already such a product");
                    return false;
                }
        }catch (SQLException A){
            JOptionPane.showMessageDialog (new JPanel (),"Error connecting to database");
            A.printStackTrace ();
            return false;
        }catch (InputMismatchException imex){
            JOptionPane.showMessageDialog (new JPanel (),"Use coma for the decimal pointer");
            imex.printStackTrace ();
            return false;
        }catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog (new JPanel (),"Use coma for the decimal pointer");
            return false;
        }
        return true;
    }
    public boolean redactName(String oldName, String  newName){
        try {
            PreparedStatement result = database.setDBConnection ().prepareStatement ("select Name from products where  Name=? ");
            result.setString (1, oldName);
            ResultSet rs = result.executeQuery ();
            if(!rs.next ()){
                JOptionPane.showMessageDialog (new JPanel (), "No such product");
                return false;
            }
            result = database.setDBConnection ().prepareStatement ("update products set Name =? where Name=?");
            result.setString (1, newName);
            result.setString (2, oldName);
            if(result.execute ()) {
                JOptionPane.showMessageDialog (new JPanel (), "Update successful");
                return true;
            }
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog (new JPanel (), "Query failed");
            return false;
        }
        return true;
    }

    public boolean redactPrice(String username, double price){
        try {
            PreparedStatement result = database.setDBConnection ().prepareStatement ("select Name from products where  Name=? ");
            result.setString (1, username);
            ResultSet rs = result.executeQuery ();
            if(!rs.next ()){
                JOptionPane.showMessageDialog (new JPanel (), "No such admin");
                return false;
            }
            result = database.setDBConnection ().prepareStatement ("update administrators set Price =? where Name=?");
            result.setDouble (1, price);
            result.setString (2, username);
            if(result.execute ()) {
                JOptionPane.showMessageDialog (new JPanel (), "Update successful");
                return true;
            }
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog (new JPanel (), "Query failed");
            return false;
        }
        return true;
    }
    public boolean redactQuantity(String username, int quantity){
        try {
            PreparedStatement result = database.setDBConnection ().prepareStatement ("select Name from products where  Name=? ");
            result.setString (1, username);
            ResultSet rs = result.executeQuery ();
            if(!rs.next ()){
                JOptionPane.showMessageDialog (new JPanel (), "No such product");
                return false;
            }
            result = database.setDBConnection ().prepareStatement ("update products set Quantity =? where Name=?");
            result.setInt (1, quantity);
            result.setString (2, username);
            if(result.execute ()) {
                JOptionPane.showMessageDialog (new JPanel (), "Update successful");
                return true;
            }
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog (new JPanel (), "Query failed");
            return false;
        }
        return true;
    }
    public boolean redactTraderEmail(String username, String email){
        try {
            PreparedStatement result = database.setDBConnection ().prepareStatement ("select Name from products where  Name=? ");
            result.setString (1, username);
            ResultSet rs = result.executeQuery ();
            if(!rs.next ()){
                JOptionPane.showMessageDialog (new JPanel (), "No such product");
                return false;
            }
            result = database.setDBConnection ().prepareStatement ("update product set EmailTradeRep =? where Username=?");
            String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
            Pattern pattern = Pattern.compile (regex);
            Matcher matcher = pattern.matcher (email);
            if(matcher.matches ()){
                result.setString (1, email);
            }else{
                JOptionPane.showMessageDialog (new JPanel (), "Invalid email input");
            }
            result.setString (2, username);
            if(result.execute ()) {
                JOptionPane.showMessageDialog (new JPanel (), "Update successful");
                return true;
            }
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog (new JPanel (), "Query failed");
            return false;
        }
        return true;
    }

    @Override
    public boolean removeProduct(String name) {
        try {
                PreparedStatement result = database.setDBConnection ().prepareStatement ("select Name from products where  Name=? ");
                result.setString (1, name);
                ResultSet rs = result.executeQuery ();
                if(!rs.next ()){
                   JOptionPane.showMessageDialog (new JPanel (), "No product found");
                   return false;
                }
                else if (name.equals (rs.getString (1))) {
                        result = database.setDBConnection ().prepareStatement ("delete from products where  Name=? ");
                        result.setString (1, name);
                        result.execute ();
                        database.shutDB ();
                        return true;
                }
        } catch (SQLException SQLEx) {
            JOptionPane.showMessageDialog (new JPanel (), "Error connecting to database");
            SQLEx.printStackTrace ();
            return false;
        }
        return true;
    }
    private void addProductToDB(Product temp){
        try {
            PreparedStatement pstmt =database.setDBConnection ().prepareStatement ("insert into products(Id, Name, Price, Quantity, EmailTradeRep) values(NULL,?,?,?,?)");
            pstmt.setString (1, temp.getName ());
            pstmt.setDouble (2, temp.getPrice ());
            pstmt.setInt (3, temp.getQuantity ());
            pstmt.setString (4, temp.getEmail ());
            pstmt.executeUpdate ();
            database.shutDB ();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog (new JPanel (), "Error connecting to database");
            sqle.printStackTrace ();
        }
    }
}

