package DAO;

import DatabaseUtility.DBConnectionHandler;
import Entity.TradeRep;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TraderDAOImpl implements TraderDAOInterface{
    DBConnectionHandler database = DBConnectionHandler.getInstance ();

    Console console = Console.getInstance ();
    @Override
    public void addTrader() {

        Entity.TradeRep temp = new Entity.TradeRep ();
        console.printLine ("You wish to add a new trade representative. Very well");
        usernameChecker(temp);
        passwordValidator(temp);
        console.printLine("Please enter the name of the trade representative");
        temp.setName (console.readLine ());
        emailChecker (temp);
        addTraderToDB (temp);
    }

    @Override
    public void redactTrader() {
            Entity.TradeRep temp = new TradeRep ();
        try {
            while (true) {
                console.printLine ("Enter the username of the trade representative you wish to redact");
                String tempTrader = console.readLine ();
                PreparedStatement result = database.setDBConnection ().prepareStatement ("select Username from tradereps where  Username=? ");
                result.setString (1, tempTrader);
                ResultSet rs = result.executeQuery ();
                if(!rs.next ()){
                    console.printLine ("No such trader. Try again");
                }
                else if (tempTrader.equals (rs.getString (1))){
                    redactMenu (temp, tempTrader);
                    break;
                }else{
                    return;
                }
            }
        }
         catch (SQLException SQLEx) {
            console.printLine ("Error connecting to database");
            SQLEx.printStackTrace ();
        }

    }

    @Override
    public void removeTrader() {
        console.printLine("You wish to remove a trade representative. Very well");
        try {
            while (true) {
                console.printLine ("Enter the username you wish to give to the trader :");
                String tempTrader = console.readLine ();
                PreparedStatement result = database.setDBConnection ().prepareStatement ("select Username from tradereps where  Username=? ");
                result.setString (1, tempTrader);
                ResultSet rs = result.executeQuery ();
                if(!rs.next ()){
                    console.printLine ("No such trader");
                }
                else if (tempTrader.equals (rs.getString (1))) {
                    console.printLine ("Trader has been found. Do you wish to proceed with DELETING this trader? Yes or No");
                    String choice = console.readLine ().toLowerCase ();
                    if(choice.equals ("yes")){
                        result = database.setDBConnection ().prepareStatement ("delete from tradereps where  Username=? ");
                        result.setString (1, tempTrader);
                        result.execute ();
                        console.printLine ("Trader " + tempTrader + " has been successfully deleted.");
                        database.shutDB ();
                        break;
                    }else{
                        return;
                    }
                }else{
                    console.printLine ("No such trader.");
                }
            }
        } catch (SQLException SQLEx) {
            console.printLine ("Error connecting to database");
            SQLEx.printStackTrace ();
        }
    }
    private void usernameChecker(TradeRep temp){
        try {
            while (true) {
                console.printLine ("Enter the username of the trader :");
                String tempTrader = console.readLine ();
                PreparedStatement result = database.setDBConnection ().prepareStatement ("select Username from tradereps where  Username=? ");
                result.setString (1, tempTrader);
                ResultSet rs = result.executeQuery ();
                if(!rs.next ()){
                    temp.setUsername (tempTrader);
                    break;
                }
                else if (tempTrader.equals (rs.getString (1))) {
                    console.printLine ("Username taken");
                } else {
                    temp.setUsername (tempTrader);
                    break;
                }
            }
        } catch (SQLException SQLEx) {
            console.printLine ("Error connecting to database");
            SQLEx.printStackTrace ();
        }
    }
    private void passwordValidator(TradeRep temp){
        try {
            while (true) {
                console.printLine ("Enter the password you wish to give to the trader :");
                String tempTrader = console.readLine ();
                PreparedStatement result = database.setDBConnection ().prepareStatement ("select Password from tradereps where  Password=? ");
                result.setString (1, tempTrader);
                ResultSet rs = result.executeQuery ();
                if(!rs.next ()){
                    temp.setPassword (tempTrader);
                    break;
                }
                else if (tempTrader.equals (rs.getString (1))) {
                    console.printLine ("Password is already taken by another user");
                } else {
                    temp.setPassword (tempTrader);
                    break;
                }
            }
        } catch (SQLException SQLEx) {
            console.printLine ("Error connecting to database");
            SQLEx.printStackTrace ();
        }

    }
    private void emailChecker(TradeRep temp){
        try {
            while (true) {
                console.printLine ("Enter the email you wish to give to the trader :");
                String tempTrader = console.readLine ();
                PreparedStatement result = database.setDBConnection ().prepareStatement ("select email from tradereps where  email=? ");
                result.setString (1, tempTrader);
                ResultSet rs = result.executeQuery ();
                if(!rs.next ()){
                    temp.setEmail (tempTrader);
                    break;
                }
                else if (tempTrader.equals (rs.getString (1))) {
                    console.printLine ("Email used by another account");
                } else {
                    temp.setEmail (tempTrader);
                    break;
                }
            }
        } catch (SQLException SQLEx) {
            console.printLine ("Error connecting to database");
            SQLEx.printStackTrace ();
        }
    }

    private void addTraderToDB(TradeRep temp){
        try {
            PreparedStatement pstmt =database.setDBConnection ().prepareStatement ("insert into tradereps(TradeRepID, Name, email, Username, Password ) values(NULL,?,?,?,?)");
            pstmt.setString (1, temp.getName ());
            pstmt.setString (2, temp.getEmail ());
            pstmt.setString (3, temp.getUsername ());
            pstmt.setString (4, temp.getPassword ());
            pstmt.execute ();
            database.shutDB ();
        }catch(SQLException sqle){
            console.printLine ("Error connecting to the database");
            sqle.printStackTrace ();
        }
    }
    private void redactMenu(TradeRep temp, String name){
        console.printLine ("Choose what to change");
        String choice = console.readLine ().toLowerCase ();
        PreparedStatement result;
        switch (choice) {
            case "username" -> {
                console.printLine ("Enter new username of the trade representative:");
                try {
                    result = database.setDBConnection ().prepareStatement ("update tradereps set Username =? where Username=?");
                    temp.setUsername (console.readLine ());
                    result.setString (1, temp.getUsername ());
                    result.setString (2, name);
                    result.execute ();
                }catch(SQLException sqle){
                    console.printLine ("Failure to connect to DB");
                }
            }
            case "password" -> {
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
            }
            case "name" -> {
                console.printLine ("Enter new name of the trade representative:");
                temp.setName (console.readLine ());
                try {
                    result = database.setDBConnection ().prepareStatement ("update tradereps set Name =? where Username=?");
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