import CommandPattern.*;
import DAO.*;

public class Main {
    public static void main(String[] args) {
        AnalysisByProductCommand prod = new AnalysisByProductCommand(new AnalysisProdDAOImpl ());
        prod.execute ();
    }
}
