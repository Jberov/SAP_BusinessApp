package DAO;

import DatabaseUtility.DBConnectionHandler;
import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;


 public class LoginDAO {
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


     public void setUsername(String username) {
         this.username = username;
     }

     public void setPassword(String password) {
         this.password = password;
     }

     private String username;
     private String password;
     private JPanel message = null;
    public boolean loginAdmin(String username, String password){

        try{
            DBConnectionHandler database = DBConnectionHandler.getInstance ();
            setUsername (username);
            setPassword (password);
            PreparedStatement statement = database.setDBConnection ().prepareStatement ("select Username from administrators where Username=?");
            statement.setString (1,getUsername ());
            ResultSet rs = statement.executeQuery ();
            message = new JPanel ();
            if(!rs.next ()){
                JOptionPane.showMessageDialog (message, "Wrong username");
                return false;
            }
            statement = database.setDBConnection ().prepareStatement ("select Password from administrators where Password=?");
            statement.setString (1, DigestUtils.sha256Hex(getPassword ()));
            rs = statement.executeQuery ();

            if(!rs.next ()){
                JOptionPane.showMessageDialog (message, "Wrong password");
                return false;
            }else{
                JOptionPane.showMessageDialog (message, "Success");
            }
            database.shutDB ();

        }catch(SQLException heresy){
            JOptionPane.showMessageDialog (message, "Database connection error");
        }catch(NullPointerException nptr){
            System.out.println ("No such user" + nptr.getMessage ());
        }catch(InputMismatchException ime){
            JOptionPane.showMessageDialog (message, "Invalid characters");
        }
        return true;
    }
    public boolean loginTradeRep(String inputUser, String inputPass){
        try{
            setUsername (inputUser);
            setPassword (inputPass);
            DBConnectionHandler database = DBConnectionHandler.getInstance ();
            PreparedStatement statement = database.setDBConnection ().prepareStatement ("select Username from tradereps where Username=?");
            statement.setString (1,getUsername ());
            ResultSet rs = statement.executeQuery ();
            if(!rs.next ()){
                JOptionPane.showMessageDialog (message, "Wrong username");
                return false;
            }
            statement = database.setDBConnection ().prepareStatement ("select Password from tradereps where Password=?");
            statement.setString (1, DigestUtils.sha256Hex(getPassword ()));
            rs = statement.executeQuery ();
            if(!rs.next ()){
                JOptionPane.showMessageDialog (message, "Wrong password");
                return false;
            }else{
                JOptionPane.showMessageDialog (message, "Login successful. Welcome");
            }
            database.shutDB ();
        }catch (NullPointerException npe){
            System.out.println ("No such user");
        }catch (InputMismatchException ime){
            JOptionPane.showMessageDialog (message, "Invalid characters. Please, use valid characters");
        }catch (SQLException SQLExc){
            JOptionPane.showMessageDialog (message, "Error connecting to database");
        }
        return true;
    }

}
