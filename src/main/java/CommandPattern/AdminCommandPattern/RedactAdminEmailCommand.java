package CommandPattern.AdminCommandPattern;

import DAO.AdministratorDAOImpl;

public class RedactAdminEmailCommand implements RedactAdminCommandInterface {
        private  final AdministratorDAOImpl admin;

        public RedactAdminEmailCommand(AdministratorDAOImpl admin) {
            this.admin = admin;
        }
        @Override
        public boolean execute(String username, String email){
            return admin.redactEmail (username, email);
        }
}
