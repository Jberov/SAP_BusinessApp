package CommandPattern;

import DAO.ClientDAOImpl;


public class RemoveClient implements Command {
    private ClientDAOImpl client;
    public RemoveClient(ClientDAOImpl client){
        this.client = client;
    }

    @Override
    public void execute() {
        client.removeClient ();
    }
}
