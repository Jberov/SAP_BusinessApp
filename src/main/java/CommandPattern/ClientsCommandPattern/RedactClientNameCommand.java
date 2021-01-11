package CommandPattern.ClientsCommandPattern;

import DAO.ClientDAOImpl;

public class RedactClientNameCommand {
    private final ClientDAOImpl client;
    public RedactClientNameCommand(ClientDAOImpl client){
        this.client = client;
    }

    public boolean execute(String oldName, String newName) {
        return client.redactName (oldName, newName);
    }
}
