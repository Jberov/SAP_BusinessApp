package DAO;

import DatabaseUtility.DBConnectionHandler;
import Entity.Administrator;
import org.apache.commons.codec.digest.DigestUtils;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AdministratorDAOImpl implements AdministratorDAOInterface {
    DBConnectionHandler database = DBConnectionHandler.getInstance ();
    public AdministratorDAOImpl(){

    }
    @Override
    public boolean addAdmin(String username, String email, String password, String name)  {
        try {
            Administrator admin = new Administrator ();
            PreparedStatement statement;
                    statement = database.setDBConnection ().prepareStatement ("select Username from administrators where  Username=? ");
                    statement.setString (1, username);
                    ResultSet rs = statement.executeQuery ();
                if (!rs.next ()) {
                    admin.setUsername (username);
                    admin.setPassword (hashPassword (password));
                    admin.setName (name);
                    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
                    Pattern pattern = Pattern.compile (regex);
                    Matcher matcher = pattern.matcher (email);
                    if(matcher.matches ()){
                        admin.setEmail (email);
                    }else{
                        JOptionPane.showMessageDialog (new JPanel (), "Invalid email input");
                    }
                    addAdminToDB (admin);
                } else if (username.equals (rs.getString (1))) {
                    JOptionPane.showMessageDialog (new JPanel (), "Username is already taken.");
                }
            }catch(SQLException A){
            JOptionPane.showMessageDialog (new JPanel (), "Error connecting to database");
            A.printStackTrace ();
        }
        return true;
    }


    @Override
    public boolean removeAdmin(String username) {
        try {
                PreparedStatement result = database.setDBConnection ().prepareStatement ("select Username from administrators where  Username=? ");
                result.setString (1, username);
                ResultSet rs = result.executeQuery ();
                if(!rs.next ()){
                    JOptionPane.showMessageDialog (new JPanel (),"No such admin.Try again");
                    return false;
                }
                else if (username.equals (rs.getString (1))) {
                        result = database.setDBConnection ().prepareStatement ("delete from administrators where  Username=? ");
                        result.setString (1, username);
                        result.execute ();
                        JOptionPane.showMessageDialog (new JPanel (),"Admin deleted");
                        database.shutDB ();
                        return true;
                    }
            } catch (SQLException SQLEx) {
        JOptionPane.showMessageDialog (new JPanel (),"Error connecting to database");
            SQLEx.printStackTrace ();
        }
        return true;
    }
    private void addAdminToDB(Administrator temp){
        try {
            PreparedStatement pstmt =database.setDBConnection ().prepareStatement ("insert into administrators(AdminID, Name, Username, Password, email) values(NULL,?,?,?,?)");
            pstmt.setString (1, temp.getName ());
            pstmt.setString (2, temp.getUsername ());
            pstmt.setString (3, temp.getPassword ());
            pstmt.setString (4, temp.getEmail ());
            pstmt.executeUpdate ();
            database.shutDB ();
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog (new JPanel (), "Cannot connect to the database");
            sqle.printStackTrace ();
        }
    }
        @Override
        public boolean redactUsername(String oldUsername, String  newUsername){
            try {
            PreparedStatement result = database.setDBConnection ().prepareStatement ("select Username from administrators where  Username=? ");
            result.setString (1, oldUsername);
            ResultSet rs = result.executeQuery ();
            if(!rs.next ()){
                JOptionPane.showMessageDialog (new JPanel (), "No such admin");
                return false;
            }
                result = database.setDBConnection ().prepareStatement ("update administrators set Username =? where Username=?");
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
                PreparedStatement result = database.setDBConnection ().prepareStatement ("select Username from administrators where  Username=? ");
                result.setString (1, username);
                ResultSet rs = result.executeQuery ();
                if(!rs.next ()){
                    JOptionPane.showMessageDialog (new JPanel (), "No such admin");
                    return false;
                }
                result = database.setDBConnection ().prepareStatement ("update administrators set Password =? where Username=?");
                result.setString (1, hashPassword (newPassword));
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
            PreparedStatement result = database.setDBConnection ().prepareStatement ("select Username from administrators where  Username=? ");
            result.setString (1, username);
            ResultSet rs = result.executeQuery ();
            if(!rs.next ()){
                JOptionPane.showMessageDialog (new JPanel (), "No such admin");
                return false;
            }
            result = database.setDBConnection ().prepareStatement ("update administrators set email =? where Username=?");
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
    public boolean redactName(String username, String name){
        try {
            PreparedStatement result = database.setDBConnection ().prepareStatement ("select Username from administrators where  Username=? ");
            result.setString (1, username);
            ResultSet rs = result.executeQuery ();
            if(!rs.next ()){
                JOptionPane.showMessageDialog (new JPanel (), "No such admin");
                return false;
            }
            result = database.setDBConnection ().prepareStatement ("update administrators set Name =? where Username=?");
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
    private String hashPassword(String password){
        return DigestUtils.sha256Hex(password);
    }
}

