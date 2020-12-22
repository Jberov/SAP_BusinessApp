package DAO;

import DatabaseUtility.DBConnectionHandler;
import Entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ClientDAOImpl implements ClientDAOInterface {
    Console console = Console.getInstance ();
    DBConnectionHandler database = DBConnectionHandler.getInstance ();
    @Override
    public void addClient() {
        try{
            User tempClient = new User ();
            console.printLine ("You wish to add a new client. Very well");
            PreparedStatement statement;
            while(true){
                console.printLine ("Enter the name of the client :");
                String client= console.readLine ();
                statement = database.setDBConnection ().prepareStatement ("select Name from clients where  Name=? ");
                statement.setString (1, client);
                ResultSet rs = statement.executeQuery ();
                if(!rs.next ()){
                    console.printLine ("Name is free. Please proceed");
                    tempClient.setName (client);
                    console.printLine ("Please enter the email of the client");
                    tempClient.setEmail (console.readLine ());
                    addClientToDB (tempClient);
                    break;
                }
                else if (client.equals (rs.getString (1))) {
                    console.printLine ("There is already such a client");

                }
            }


        }catch (SQLException A){
            console.printLine ("Error connecting to database");
            A.printStackTrace ();
        }

    }

    @Override
    public void redactClient() {

        try {
            User tempClient = new User ();
            while (true) {
                console.printLine ("What is his name: ");
                String clientName= console.readLine ();
                PreparedStatement result = database.setDBConnection ().prepareStatement ("select Name from clients where  Name=? ");
                result.setString (1, clientName);
                ResultSet rs = result.executeQuery ();
                if(!rs.next ()){
                    console.printLine ("No such client.Try again");
                }
                else if (clientName.equals (rs.getString (1))) {
                    redactMenu (tempClient, clientName);
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
    public void removeClient() {
        console.printLine ("Enter the name of the client you wish to remove");
        try {
            while (true) {
                console.printLine ("Enter the name of the client :");
                String client= console.readLine ();
                PreparedStatement result = database.setDBConnection ().prepareStatement ("select Name from clients where  Name=? ");
                result.setString (1, client);
                ResultSet rs = result.executeQuery ();
                if(!rs.next ()){
                    console.printLine ("No such client.Try again");
                }
                else if (client.equals (rs.getString (1))) {
                    console.printLine ("Client found. Do you want to DELETE the client? Yes or no");
                    String choice = console.readLine ().toLowerCase ();
                    if(choice.equals ("yes")){
                        result = database.setDBConnection ().prepareStatement ("delete from clients where  Name=? ");
                        result.setString (1, client);
                        result.execute ();
                        console.printLine ("Client " + client + " has been successfully deleted.");
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
    private void addClientToDB(User temp){
        try {
            PreparedStatement statement = database.setDBConnection ().prepareStatement ("insert into clients(Id, Name, email) values(NULL,?,?)");
            statement.setString (1, temp.getName ());
            statement.setString (2, temp.getEmail ());
            statement.executeUpdate ();
            database.shutDB ();
        }catch(SQLException sqle){
            console.printLine ("Error connecting to the database");
            sqle.printStackTrace ();
        }
    }
    private void redactMenu(User temp, String name){
        console.printLine ("Choose what to change");
        String choice = console.readLine ().toLowerCase ();
        PreparedStatement result;
        switch (choice) {
            case "email" -> {
                console.printLine ("Enter new email of the client:");
                try {
                    result = database.setDBConnection ().prepareStatement ("update clients set email =? where Name=?");
                    temp.setEmail (console.readLine ());
                    result.setString (1, temp.getEmail ());
                    result.setString (2, name);
                    result.execute ();
                }catch(SQLException sqle){
                    console.printLine ("Failure to connect to DB");
                    sqle.printStackTrace ();
                }
            }
            /*case "password" -> {
                console.printLine ("Enter new password of the trade representative:");
                temp.setPassword (console.readLine ());
                try {
                    result = database.setDBConnection ().prepareStatement ("update tradereps set Password =? where Username=?");
                    result.setString (1, temp.getPassword ());
                    result.setString (2, name);
                    result.execute ();
                }catch(SQLException sqle){
                    console.printLine ("Failure to connect to DB");
                }
            }*/
            case "name" -> {
                console.printLine ("Enter new name of the client:");
                temp.setName (console.readLine ());
                try {
                    result = database.setDBConnection ().prepareStatement ("update clients set Name =? where Name=?");
                    result.setString (1, temp.getName ());
                    result.setString (2, name);
                    result.execute ();
                }catch(SQLException sqle){
                    console.printLine ("Failure to connect to DB");
                }
            }
            default -> console.printLine ("No such command. Please enter a valid value to be changed");
        }
    }
}

