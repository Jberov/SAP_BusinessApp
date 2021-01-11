package CommandPattern.ClientsCommandPattern;

import CommandPattern.Command;
import DAO.ClientDAOImpl;

public class AddClient{
    private ClientDAOImpl client;
    public AddClient(ClientDAOImpl client){
        this.client = client;
    }

    public boolean execute(String name, String email, String trader) {
        return client.addClient (name, email, trader);
    }
}
