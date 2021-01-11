package DAO;

import DatabaseUtility.DBConnectionHandler;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;

public class AnalysisProdDAOImpl{
    DBConnectionHandler database = DBConnectionHandler.getInstance ();

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    private String product;
    public boolean analyze(String prod, JTextPane text) {
        try{
        if(!checkProduct (prod)){
            return false;
        }
        double profit= 0.00, absolute=0.00;
        int counterProd = 0, counter = 0;
        PreparedStatement statement = database.setDBConnection ().prepareStatement ("select TotalPrice from Sales where IdOfProduct=?");
        PreparedStatement auxiliaryStatement = database.setDBConnection ().prepareStatement ("select Id from products where Name=?");
        auxiliaryStatement.setString (1, getProduct ());
        ResultSet rs = auxiliaryStatement.executeQuery ();
        rs.next ();
        statement.setLong (1,rs.getLong (1));
        rs = statement.executeQuery ();
        while(rs.next ()){
            profit += rs.getDouble ("TotalPrice");
            counterProd++;
        }
        statement=database.setDBConnection ().prepareStatement ("select TotalPrice from Sales");
        rs = statement.executeQuery ();
        while(rs.next ()){
            absolute += rs.getDouble ("TotalPrice");
            counter++;
        }
        text.setText ("Product " +  getProduct () + " has accumulated total profit of : " + profit + " lv.\nThe percentage of the profits of the sales of the product " + getProduct () + " compared to all profits is " + (profit/absolute)*100 + "%\nThe ratio of sales is: " + ((double)counterProd/(double)counter)*100 + "%.");
        database.shutDB ();
        return true;
    }catch(SQLException sqle){
            JOptionPane.showMessageDialog (new JPanel (), "Product not found");
        sqle.printStackTrace ();
        return false;
    }catch (InputMismatchException ime){
            JOptionPane.showMessageDialog (new JPanel (), "Use the proper format");
        ime.printStackTrace ();
            return false;
    }catch (NullPointerException nptr){
            JOptionPane.showMessageDialog (new JPanel (), "No results");
            return false;
    } catch (Exception E){
        E.printStackTrace ();
        return false;
    }
    }
    public boolean checkProduct(String product) {
        try {
                PreparedStatement result = database.setDBConnection ().prepareStatement ("select Name from products where  Name=? ");
                result.setString (1, product);
                ResultSet rs = result.executeQuery ();
                if(!rs.next ()){
                    JOptionPane.showMessageDialog (new JPanel (), "Product not found");
                    return false;
                }
                else if (product.equals (rs.getString (1))) {
                    setProduct (product);
                    return true;
                }
        } catch (SQLException SQLEx) {
            JOptionPane.showMessageDialog (new JPanel (), "Failure to connect to DB");
            SQLEx.printStackTrace ();
            return false;
        }catch (IndexOutOfBoundsException iobe) {
            JOptionPane.showMessageDialog (new JPanel (), "No such product");
            return false;
        }
        return false;
    }
}
