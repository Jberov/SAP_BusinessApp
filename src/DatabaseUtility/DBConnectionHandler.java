package DatabaseUtility;

import DAO.Console;

import java.sql.*;

public class DBConnectionHandler {
    private static final DBConnectionHandler database = new DBConnectionHandler();

    public static Connection getConnection() {
        return connection;
    }

    private static Connection connection;
    Console console = Console.getInstance ();
    private DBConnectionHandler() {

    }
    public static DBConnectionHandler getInstance(){
        return  database;
    }
    public Connection setDBConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection ("jdbc:mysql://localhost/shopdatabase", "root", "");
        }catch (SQLException sqle){
            console.printLine ("Failure to create a connection");
        }catch (ClassNotFoundException CNFE) {
            console.printLine ("Database driver not found");
        }
        return connection;
    }


    public void shutDB(){
        try {
            connection.close ();
        }catch (SQLException DBConnExc){
            console.printLine ("Failure to close the connection");
        }
    }
}


