package CommandPattern.ClientsCommandPattern;

import DAO.ClientDAOImpl;

public class RedactTradeNameRepClientCommand {
    private final ClientDAOImpl client;
    public RedactTradeNameRepClientCommand(ClientDAOImpl client){
        this.client = client;
    }

    public boolean execute(String nameOfClient, String newNameOfTrader) {
        return  client.redactTradeRepName (nameOfClient, newNameOfTrader);
    }
}
