import CommandPattern.*;
import DAO.AdministratorDAOImpl;
import DAO.ClientDAOImpl;
import DAO.ProductsDAOImpl;
import DAO.TraderDAOImpl;

public class Main {
    public static void main(String[] args) {
        RedactAdmin redact = new RedactAdmin (new AdministratorDAOImpl ());
        redact.execute ();
    }
}
