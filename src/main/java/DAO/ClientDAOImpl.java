package DAO;

import DatabaseUtility.DBConnectionHandler;
import Entity.User;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ClientDAOImpl implements ClientDAOInterface {
    DBConnectionHandler database = DBConnectionHandler.getInstance ();
    @Override
    public boolean addClient(String name, String email, String trader) {
        try{
            User tempClient = new User ();
            PreparedStatement statement;
                statement = database.setDBConnection ().prepareStatement ("select Name from clients where  Name=? ");
                statement.setString (1, name);
                ResultSet rs = statement.executeQuery ();
                if(!rs.next ()){
                    tempClient.setName (name);
                    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
                    Pattern pattern = Pattern.compile (regex);
                    Matcher matcher = pattern.matcher (email);
                    if(matcher.matches ()){
                        tempClient.setEmail (email);
                    }else{
                        JOptionPane.showMessageDialog (new JPanel (), "Invalid email input");
                    }
                    if(addClientToDB (tempClient, trader)) {
                        return true;
                    }else{
                        JOptionPane.showMessageDialog (new JPanel (), "Update failed");
                        return false;
                    }
                }
                else if (name.equals (rs.getString (1))) {
                    JOptionPane.showMessageDialog (new JPanel (), "There is already such a client");
                    return false;
                }
        }catch (SQLException A){
            JOptionPane.showMessageDialog (new JPanel (), "Error connecting to database");
            A.printStackTrace ();
            return false;
        }
        return true;
    }

    public boolean redactTradeRepName(String name, String  newEmail){
        try {
            PreparedStatement result = database.setDBConnection ().prepareStatement ("select Name from clients where Name=? ");
            result.setString (1, name);
            ResultSet rs = result.executeQuery ();
            if(!rs.next ()){
                JOptionPane.showMessageDialog (new JPanel (), "No such client");
                return false;
            }
            result = database.setDBConnection ().prepareStatement ("update clients set NameOfTradeRep =? where Name=?");
            result.setString (1, newEmail);
            result.setString (2, name);
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
    public boolean redactEmail(String username, String email){
        try {
            PreparedStatement result = database.setDBConnection ().prepareStatement ("select Name from clients where Name=? ");
            result.setString (1, username);
            ResultSet rs = result.executeQuery ();
            if(!rs.next ()){
                JOptionPane.showMessageDialog (new JPanel (), "No such client");
                return false;
            }
            String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
            Pattern pattern = Pattern.compile (regex);
            Matcher matcher = pattern.matcher (email);
            result = database.setDBConnection ().prepareStatement ("update clients set email =? where Name=?");
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
    public boolean redactName(String username, String name){
        try {
            PreparedStatement result = database.setDBConnection ().prepareStatement ("select Name from clients where Name=?");
            result.setString (1, username);
            ResultSet rs = result.executeQuery ();
            if(!rs.next ()){
                JOptionPane.showMessageDialog (new JPanel (), "No such client");
                return false;
            }
            result = database.setDBConnection ().prepareStatement ("update clients set Name =? where Name=?");
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
    public boolean removeClient(String name) {
        try {
                PreparedStatement result = database.setDBConnection ().prepareStatement ("select Name from clients where  Name=? ");
                result.setString (1, name);
                ResultSet rs = result.executeQuery ();
                if(!rs.next ()){
                    JOptionPane.showMessageDialog (new JPanel (), "Client not found");
                    return false;
                }
                else if (name.equals (rs.getString (1))) {
                    result = database.setDBConnection ().prepareStatement ("delete from clients where  Name=? ");
                    result.setString (1, name);
                    result.execute ();
                    JOptionPane.showMessageDialog (new JPanel (), "Client deleted");
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
    private boolean addClientToDB(User temp, String trader){
        try {
            PreparedStatement statement = database.setDBConnection ().prepareStatement ("select Name from tradereps where Name=? ");
            statement.setString (1, trader);
            ResultSet rs = statement.executeQuery ();
            if(!rs.next ()){
                JOptionPane.showMessageDialog (new JPanel (), "No TradeRep has this name");
                return false;
            }else {
                statement = database.setDBConnection ().prepareStatement ("insert into clients(Id, Name, email,NameOfTradeRep) values(NULL,?,?,?)");
                statement.setString (1, temp.getName ());

                statement.setString (2, temp.getEmail ());
                statement.setString (3, trader);
                statement.executeUpdate ();
                database.shutDB ();
                return true;
            }
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog (new JPanel (), "Error connecting to database");
            sqle.printStackTrace ();
            return false;
        }
    }

}

