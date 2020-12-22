package CommandPattern;

import DAO.ClientDAOImpl;

public class AddClient implements Command {
    private ClientDAOImpl client;
    public AddClient(ClientDAOImpl client){
        this.client = client;
    }

    @Override
    public void execute() {
        client.addClient ();
    }
}
