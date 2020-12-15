import java.sql.*;


public class AdministratorDBConnection extends DBConnectionHandler{
    ResultSet result;

    public AdministratorDBConnection() {
        super();
    }
    void setCompleteDBConnection(){
        connection = setDBConnection ();
        statement = setDBStatement ();
    }

    Connection setDBConnection(){
        try {
            connection = DriverManager.getConnection ("jdbc:mysql://localhost/shopdatabase", "root", "");
        }catch (SQLException sqle){
                //logger.log (Level.WARNING, "Database connection failure");
        }
        return connection;
    }
     Statement setDBStatement(){
        try {
            statement = connection.createStatement ();
        }catch (SQLException sqle){
            //logger.log (Level.WARNING, "Database statement failure");
        }

        return statement;
    }
}
