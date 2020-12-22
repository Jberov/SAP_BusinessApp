package DAO;

import DatabaseUtility.DBConnectionHandler;
import Entity.Administrator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdministratorDAOImpl implements AdministratorDAOInterface {
    Console console = Console.getInstance ();
    DBConnectionHandler database = DBConnectionHandler.getInstance ();
    public AdministratorDAOImpl(){

    }
    @Override
    public void addAdmin() {
        try{
            Administrator admin = new Administrator ();
            console.printLine ("You wish to add a new admin. Very well");
            PreparedStatement statement;
            while(true){
                console.printLine ("Enter the username of the admin :");
                String adminUsername= console.readLine ();
                statement = database.setDBConnection ().prepareStatement ("select Username from administrators where  Username=? ");
                statement.setString (1, adminUsername);
                ResultSet rs = statement.executeQuery ();
                if(!rs.next ()){
                    console.printLine ("Username is free. Please proceed");
                    admin.setUsername (adminUsername);
                    console.printLine ("Enter his password");
                    admin.setPassword (console.readLine ());
                    console.printLine ("Enter his name");
                    admin.setName (console.readLine ());
                    console.printLine ("Please enter the email of the admin");
                    admin.setEmail (console.readLine ());
                    addAdminToDB (admin);
                    break;
                }
                else if (adminUsername.equals (rs.getString (1))) {
                    console.printLine ("There is already such an administrators");

                }
            }


        }catch (SQLException A){
            console.printLine ("Error connecting to database");
            A.printStackTrace ();
        }

    }

    @Override
    public void redactAdmin() {
    try{
        Entity.Administrator temp = new Administrator ();
        while (true) {
            console.printLine ("What is his username: ");
            String AdminUsername= console.readLine ();
            PreparedStatement result = database.setDBConnection ().prepareStatement ("select Username from administrators where  Username=? ");
            result.setString (1, AdminUsername);
            ResultSet rs = result.executeQuery ();
            if(!rs.next ()){
                console.printLine ("No such admin.Try again");
            }
            else if (AdminUsername.equals (rs.getString (1))) {
                redactMenu (temp, AdminUsername);
                break;
            }
        }
        } catch (SQLException SQLEx) {
            console.printLine ("Error connecting to database");
            SQLEx.printStackTrace ();
        }catch (IndexOutOfBoundsException iobe) {
            console.printLine("No such product found");
        } finally {
            console.printLine("Product successfully redacted");
        }
    }
    @Override
    public void removeAdmin() {
        console.printLine ("You wish to remove an administrator. Very well");
        try {
            while (true) {
                console.printLine ("Enter the username of the admin :");
                String admin= console.readLine ();
                PreparedStatement result = database.setDBConnection ().prepareStatement ("select Username from administrators where  Username=? ");
                result.setString (1, admin);
                ResultSet rs = result.executeQuery ();
                if(!rs.next ()){
                    console.printLine ("No such admin.Try again");
                }
                else if (admin.equals (rs.getString (1))) {
                    console.printLine ("Client found. Do you want to DELETE the client? Yes or no");
                    String choice = console.readLine ().toLowerCase ();
                    if(choice.equals ("yes")){
                        result = database.setDBConnection ().prepareStatement ("delete from administrators where  Username=? ");
                        result.setString (1, admin);
                        result.execute ();
                        console.printLine ("Administrator " + admin + " has been successfully deleted.");
                        database.shutDB ();
                        break;
                    }else{
                        console.printLine ("Successfully cancelled");
                        return;
                    }
                }
            }
        } catch (SQLException SQLEx) {
            console.printLine ("Error connecting to database");
            SQLEx.printStackTrace ();
        }
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
            console.printLine ("Error connecting to the database");
            sqle.printStackTrace ();
        }
    }
    private void redactMenu(Administrator temp, String name){
        console.printLine ("Choose what to change");
        String choice = console.readLine ().toLowerCase ();
        PreparedStatement result;
        switch (choice) {
            case "email" -> {
                console.printLine ("Enter new email of the admin:");
                try {
                    result = database.setDBConnection ().prepareStatement ("update administrators set email =? where Username=?");
                    temp.setEmail (console.readLine ());
                    result.setString (1, temp.getEmail ());
                    result.setString (2, name);
                    result.execute ();
                }catch(SQLException sqle){
                    console.printLine ("Failure to connect to DB");
                    sqle.printStackTrace ();
                }
            }
            case "password" -> {
                console.printLine ("Enter new password of the trade representative:");
                temp.setPassword (console.readLine ());
                try {
                    result = database.setDBConnection ().prepareStatement ("update administrators set Password =? where Username=?");
                    result.setString (1, temp.getPassword ());
                    result.setString (2, name);
                    result.execute ();
                }catch(SQLException sqle){
                    console.printLine ("Failure to connect to DB");
                }
            }
            case "name" -> {
                console.printLine ("Enter new name of the client:");
                temp.setName (console.readLine ());
                try {
                    result = database.setDBConnection ().prepareStatement ("update administrators set Name =? where Username=?");
                    result.setString (1, temp.getName ());
                    result.setString (2, name);
                    result.execute ();
                }catch(SQLException sqle){
                    console.printLine ("Failure to connect to DB");
                }
            }
            case "username" -> {
                console.printLine ("Enter new username of the client:");
                temp.setUsername (console.readLine ());
                try {
                    result = database.setDBConnection ().prepareStatement ("update administrators set Username =? where Username=?");
                    result.setString (1, temp.getUsername ());
                    result.setString (2, name);
                    result.execute ();
                }catch(SQLException sqle){
                    console.printLine ("Failure to connect to DB");
                }}
            default -> console.printLine ("No such command. Please enter a valid value to be changed");
        }
    }
}
