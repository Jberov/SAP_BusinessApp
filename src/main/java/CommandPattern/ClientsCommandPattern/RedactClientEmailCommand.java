package CommandPattern.ClientsCommandPattern;

import DAO.ClientDAOImpl;

public class RedactClientEmailCommand {
    private final ClientDAOImpl client;
    public RedactClientEmailCommand(ClientDAOImpl client){
        this.client = client;
    }

    public boolean execute(String name, String email) {
        return  client.redactEmail (name, email);
    }
}
