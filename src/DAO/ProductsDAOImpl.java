package DAO;

import DatabaseUtility.DBConnectionHandler;
import Entity.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.InputMismatchException;

public class ProductsDAOImpl implements ProductsDAOInterface{

    Console console = Console.getInstance ();
    DBConnectionHandler database = DBConnectionHandler.getInstance ();

    @Override
    public void addProduct() {
        try{
            Product product = new Product ();
            console.printLine ("You wish to add a new product. Very well");
            PreparedStatement statement;
            while(true){
                console.printLine ("Enter the name of the product :");
                String productName= console.readLine ();
                statement = database.setDBConnection ().prepareStatement ("select Name from products where  Name=? ");
                statement.setString (1, productName);
                ResultSet rs = statement.executeQuery ();
                if(!rs.next ()){
                    console.printLine ("There are no known products with that name, therefore your add query is valid. Please proceed");
                    product.setName (productName);
                    console.printLine ("Please enter the price of the product");
                    product.setPrice (console.readDouble ());
                    addProductToDB (product);
                    break;
                }
                else if (productName.equals (rs.getString (1))) {
                    console.printLine ("There is already such a product");

                }
            }
        }catch (SQLException A){
            console.printLine ("Error connecting to database");
            A.printStackTrace ();
        }catch (InputMismatchException imex){
            console.printLine ("Use coma for the decimal pointer");
            imex.printStackTrace ();
        }

    }

    @Override
    public void redactProduct() {
            try {
                Product prod = new Product ();
                while (true) {
                    console.printLine ("Enter the name of the product :");
                    String tempProd= console.readLine ();
                    PreparedStatement result = database.setDBConnection ().prepareStatement ("select Name from products where  Name=? ");
                    result.setString (1, tempProd);
                    ResultSet rs = result.executeQuery ();
                    if(!rs.next ()){
                        console.printLine ("No such product.Try again");
                    }
                    else if (tempProd.equals (rs.getString (1))) {
                        redactMenu (prod, tempProd);
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
    public void removeProduct() {
        try {
            while (true) {
                console.printLine ("Enter the name of the product :");
                String tempProd= console.readLine ();
                PreparedStatement result = database.setDBConnection ().prepareStatement ("select Name from products where  Name=? ");
                result.setString (1, tempProd);
                ResultSet rs = result.executeQuery ();
                if(!rs.next ()){
                   console.printLine ("No such product.Try again");
                }
                else if (tempProd.equals (rs.getString (1))) {
                    console.printLine ("Product found. Do you want to DELETE the product? Yes or no");
                    String choice = console.readLine ().toLowerCase ();
                    if(choice.equals ("yes")){
                        result = database.setDBConnection ().prepareStatement ("delete from products where  Name=? ");
                        result.setString (1, tempProd);
                        result.execute ();
                        console.printLine ("Product " + tempProd + " has been successfully deleted.");
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
    private void addProductToDB(Product temp){
        try {
            PreparedStatement pstmt =database.setDBConnection ().prepareStatement ("insert into products(Id, Name, Price) values(NULL,?,?)");
            pstmt.setString (1, temp.getName ());
            pstmt.setDouble (2, temp.getPrice ());
            pstmt.executeUpdate ();
            database.shutDB ();
        }catch(SQLException sqle){
            console.printLine ("Error connecting to the database");
            sqle.printStackTrace ();
        }
    }
    private void redactMenu(Product temp, String name){
        console.printLine ("Choose what to change");
        String choice = console.readLine ().toLowerCase ();
        PreparedStatement result;
        switch (choice) {
            case "price" -> {
                console.printLine ("Enter new price of the product:");
                try {
                    result = database.setDBConnection ().prepareStatement ("update products set Price =? where Name=?");
                    temp.setPrice (console.readDouble ());
                    result.setDouble (1, temp.getPrice ());
                    result.setString (2, name);
                    result.execute ();
                }catch(SQLException sqle){
                    console.printLine ("Failure to connect to DB");
                }
                break;
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
                console.printLine ("Enter new name of the trade representative:");
                temp.setName (console.readLine ());
                try {
                    result = database.setDBConnection ().prepareStatement ("update products set Name =? where Name=?");
                    result.setString (1, temp.getName ());
                    result.setString (2, name);
                    result.execute ();
                }catch(SQLException sqle){
                    console.printLine ("Failure to connect to DB");
                }
                break;
            }
            default -> console.printLine ("No such command. Please enter a valid value to be changed");
        }
    }
}

