import java.sql.*;


public class AdministratorDBConnection extends DBConnectionHandler{
    ResultSet result;
    AdministratorDAOInterface adminDAOInterface = new AdministratorDAOImpl();

    public AdministratorDBConnection() {
        super();
        setCompleteDBConnection ();
        loadAdminsFromDB ();
    }
    void loadAdminsFromDB(){
        try {
            Administrator admin = new Administrator ();
            long id;
            String username, password;
            result = statement.executeQuery ("select * from administrators");
            while(result.next()) {
                admin.Name = result.getString (2);
                id = result.getLong (1);
                admin.setID (id);//= result.getLong (1);
                username =  result.getString (3);
                admin.setUsername (username);
                password = result.getString (4);
                admin.setPassword (password);
                adminDAOInterface.getAdministrators ().put(admin.Name, admin);
            }
        }catch(SQLException sqle){
            sqle.printStackTrace ();
        }
    }
    void setCompleteDBConnection(){
        connection = setDBConnection ();
        statement = setDBStatement ();
    }
    Connection setDBConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection ("jdbc:mysql://localhost/shopdatabase", "root", "");
        }catch (SQLException sqle){
                //logger.log (Level.WARNING, "Database connection failure");
        }catch (ClassNotFoundException CNFE) {
            //logger.log (Level.WARNING, "Database driver not found");
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
