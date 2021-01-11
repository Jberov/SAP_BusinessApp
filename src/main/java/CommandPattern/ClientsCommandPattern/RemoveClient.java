package CommandPattern.ClientsCommandPattern;

import CommandPattern.DeleteUsersCommandInterface;
import DAO.ClientDAOImpl;


public class RemoveClient implements DeleteUsersCommandInterface {
    private final ClientDAOImpl client;
    public RemoveClient(ClientDAOImpl client){
        this.client = client;
    }

    @Override
    public boolean execute(String name) {
        return client.removeClient (name);
    }
}
