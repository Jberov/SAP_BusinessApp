import java.sql.Connection;
import java.sql.Statement;

public abstract class DBConnectionHandler {

    static Statement statement;
    static Connection connection;
    abstract Statement setDBStatement();
    abstract Connection setDBConnection();
}


