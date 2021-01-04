package DAO;

import DatabaseUtility.DBConnectionHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;


 public class LoginDAO {
    Console console = Console.getInstance ();
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

     String username;
    String password;

     public boolean isAdmin() {
         return isAdmin;
     }

     public void setAdmin(boolean admin) {
         isAdmin = admin;
     }

     public boolean isTradeRep() {
         return isTradeRep;
     }

     public void setTradeRep(boolean tradeRep) {
         isTradeRep = tradeRep;
     }
    boolean isTradeRep,isAdmin;
    public void roleSetter(){
        console.printLine ("Enter your role: admin or trade rep");
        String role = console.readLine ().toLowerCase ();
        if(role.equals ("admin")){
            setAdmin (true);
            setTradeRep (false);
        }else if(role.equals ("trade rep")){
            setTradeRep (true);
            setAdmin (false);
        }
    }
    public void loginAdmin(){
        try{
            DBConnectionHandler database = DBConnectionHandler.getInstance ();
            console.printLine ("Please enter your username: ");
            setUsername (console.readLine ());
            console.printLine ("Please, enter your password");
            setPassword (console.readLine ());
            PreparedStatement statement = database.setDBConnection ().prepareStatement ("select Username from administrators where Username=?");
            statement.setString (1,getUsername ());
            ResultSet rs = statement.executeQuery ();
            if(!rs.next ()){
                console.printLine ("Wrong username");
            }
            statement = database.setDBConnection ().prepareStatement ("select Password from administrators where Password=?");
            statement.setString (1, getPassword ());
            rs = statement.executeQuery ();
            if(!rs.next ()){
                console.printLine ("Wrong password");
            }else{
                console.printLine ("Login successful. Welcome");
            }
            database.shutDB ();
        }catch(SQLException heresy){
           heresy.printStackTrace ();
        }catch(NullPointerException nptr){
            System.out.println ("No such user" + nptr.getMessage ());
        }catch(InputMismatchException ime){
            System.out.println ("Enter valid letters");
        }

    }
    public void loginTradeRep(){
        try{
            DBConnectionHandler database = DBConnectionHandler.getInstance ();
            console.printLine ("Please enter your username: ");
            setUsername (console.readLine ());
            console.printLine ("Please, enter your password");
            setPassword (console.readLine ());
            PreparedStatement statement = database.setDBConnection ().prepareStatement ("select Username from tradereps where Username=?");
            statement.setString (1,getUsername ());
            ResultSet rs = statement.executeQuery ();
            if(!rs.next ()){
                console.printLine ("Wrong username");
            }
            statement = database.setDBConnection ().prepareStatement ("select Password from tradereps where Password=?");
            statement.setString (1, getPassword ());
            rs = statement.executeQuery ();
            if(!rs.next ()){
                console.printLine ("Wrong password");
            }else{
                console.printLine ("Login successful. Welcome");
            }
            database.shutDB ();
        }catch (NullPointerException npe){
            System.out.println ("No such user");
        }catch (InputMismatchException ime){
            System.out.println ("Enter your credentials, using the approved characters");
        }catch (SQLException SQLExc){
            System.out.println ("Error connecting to database");
        }
    }
    public void logout(){
       setUsername ("");
       setPassword ("");
      setAdmin (false);
       setTradeRep (false);
    }
}
