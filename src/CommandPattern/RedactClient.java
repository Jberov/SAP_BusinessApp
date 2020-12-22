package CommandPattern;

import DAO.ClientDAOImpl;

public class RedactClient implements Command {
        private ClientDAOImpl client;
        public RedactClient(ClientDAOImpl client){
            this.client = client;
        }

        @Override
        public void execute() {
            client.redactClient ();
        }
    }

