package DAO;

import DatabaseUtility.DBConnectionHandler;
import Entity.TradeRep;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TraderDAOImpl implements TraderDAOInterface{
    DBConnectionHandler database = DBConnectionHandler.getInstance ();
    @Override
    public boolean addTrader(String username, String email, String password, String name) {
        TradeRep temp = new TradeRep ();
        if(!usernameChecker(temp,  username)){
            return false;
        }else if(!passwordValidator(temp, password)) {
            return false;
        }else if(!emailChecker (temp, email)){
            return false;
        }
        temp.setName (name);
        return  addTraderToDB (temp);
    }
    @Override
    public boolean redactUsername(String oldUsername, String  newUsername){
        try {
            PreparedStatement result = database.setDBConnection ().prepareStatement ("select Username from tradereps where  Username=? ");
            result.setString (1, oldUsername);
            ResultSet rs = result.executeQuery ();
            if(!rs.next ()){
                JOptionPane.showMessageDialog (new JPanel (), "No such trade representative");
                return false;
            }
            result = database.setDBConnection ().prepareStatement ("update tradereps set Username =? where Username=?");
            result.setString (1, newUsername);
            result.setString (2, oldUsername);
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
    public boolean redactPassword(String username, String newPassword){
        try {
            PreparedStatement result = database.setDBConnection ().prepareStatement ("select Username from tradereps where  Username=? ");
            result.setString (1, username);
            ResultSet rs = result.executeQuery ();
            if(!rs.next ()){
                JOptionPane.showMessageDialog (new JPanel (), "No such trade representative");
                return false;
            }
            result = database.setDBConnection ().prepareStatement ("update tradereps set Password =? where Username=?");
            result.setString (1, newPassword);
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
    public boolean redactEmail(String username, String email){
        try {
            PreparedStatement result = database.setDBConnection ().prepareStatement ("select Username from tradereps where  Username=? ");
            result.setString (1, username);
            ResultSet rs = result.executeQuery ();
            if(!rs.next ()){
                JOptionPane.showMessageDialog (new JPanel (), "No such trade representative");
                return false;
            }
            result = database.setDBConnection ().prepareStatement ("update tradereps set email =? where Username=?");
            result.setString (1, email);
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
    public boolean redactName(String username, String name){
        try {
            PreparedStatement result = database.setDBConnection ().prepareStatement ("select Username from tradereps where  Username=? ");
            result.setString (1, username);
            ResultSet rs = result.executeQuery ();
            if(!rs.next ()){
                JOptionPane.showMessageDialog (new JPanel (), "No such trade representative");
                return false;
            }
            result = database.setDBConnection ().prepareStatement ("update tradereps set Name =? where Username=?");
            result.setString (1, name);
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
    public boolean removeTrader(String username) {
        try {
            PreparedStatement result = database.setDBConnection ().prepareStatement ("select Username from tradereps where  Username=? ");
            result.setString (1, username);
            ResultSet rs = result.executeQuery ();
            if(!rs.next ()){
                JOptionPane.showMessageDialog (new JPanel (),"No such trade representative.Try again");
                return false;
            }
            else if (username.equals (rs.getString (1))) {
                result = database.setDBConnection ().prepareStatement ("delete from tradereps where  Username=? ");
                result.setString (1, username);
                result.execute ();
                JOptionPane.showMessageDialog (new JPanel (),"Trade representative deleted");
                database.shutDB ();
                return true;
            }
        } catch (SQLException SQLEx) {
            JOptionPane.showMessageDialog (new JPanel (),"Error connecting to database");
            SQLEx.printStackTrace ();
        }
        return true;
    }
    private boolean usernameChecker(TradeRep temp, String username){
        try {
                PreparedStatement result = database.setDBConnection ().prepareStatement ("select Username from tradereps where  Username=? ");
                result.setString (1, username);
                ResultSet rs = result.executeQuery ();
                if(!rs.next ()){
                    temp.setUsername (username);
                    return true;
                }
                else if (username.equals (rs.getString (1))) {
                    JOptionPane.showMessageDialog (new JPanel (), "Username is already taken");
                    return false;
                } else {
                    temp.setUsername (username);
                    return true;
                }
        } catch (SQLException SQLEx) {
            JOptionPane.showMessageDialog (new JPanel (), "Database error");
            SQLEx.printStackTrace ();
        }
        return true;
    }
    private boolean passwordValidator(TradeRep temp, String password){
        try {
                PreparedStatement result = database.setDBConnection ().prepareStatement ("select Password from tradereps where  Password=? ");
                result.setString (1, password);
                ResultSet rs = result.executeQuery ();
                if(!rs.next ()){
                    temp.setPassword (password);
                    return true;
                }
                else if (password.equals (rs.getString (1))) {
                    JOptionPane.showMessageDialog (new JPanel (), "Password is already taken");
                    return false;
                } else {
                    temp.setPassword (password);
                    return true;
                }
        } catch (SQLException SQLEx) {
            JOptionPane.showMessageDialog (new JPanel (), "Database error");
            SQLEx.printStackTrace ();
        }
        return true;
    }
    private boolean emailChecker(TradeRep temp, String email){
        try {
                PreparedStatement result = database.setDBConnection ().prepareStatement ("select email from tradereps where  email=? ");
                result.setString (1, email);
                ResultSet rs = result.executeQuery ();
                if(!rs.next ()){
                    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
                    Pattern pattern = Pattern.compile (regex);
                    Matcher matcher = pattern.matcher (email);
                    if(matcher.matches ()){
                        temp.setEmail (email);
                    }else{
                        JOptionPane.showMessageDialog (new JPanel (), "Invalid email input");
                        return false;
                    }

                    return true;
                }
                else if (email.equals (rs.getString (1))) {
                    JOptionPane.showMessageDialog (new JPanel (), "Email already used by another account");
                    return false;
                } else {
                    temp.setEmail (email);
                    return true;
                }
        } catch (SQLException SQLEx) {
            JOptionPane.showMessageDialog (new JPanel (), "Database error");
            SQLEx.printStackTrace ();
        }
        return true;
    }

    private boolean addTraderToDB(TradeRep temp){
        try {
            PreparedStatement pstmt =database.setDBConnection ().prepareStatement ("insert into tradereps(TradeRepID, Name, email, Username, Password ) values(NULL,?,?,?,?)");
            pstmt.setString (1, temp.getName ());
            pstmt.setString (2, temp.getEmail ());
            pstmt.setString (3, temp.getUsername ());
            pstmt.setString (4, temp.getPassword ());
            pstmt.execute ();
            database.shutDB ();
            return true;
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog (new JPanel (), "Database connection error");
            sqle.printStackTrace ();
        }catch (Exception e){
            JOptionPane.showMessageDialog (new JPanel (), "Error");
        }
        return true;
    }

}