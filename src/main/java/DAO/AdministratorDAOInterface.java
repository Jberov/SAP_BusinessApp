package DAO;

 interface AdministratorDAOInterface {
    boolean addAdmin(String username, String email, String password, String name);
    boolean redactUsername(String username, String newUsername);
    boolean redactPassword(String username, String pass);
    boolean redactEmail(String username, String email);
    boolean redactName(String username, String name);
    boolean removeAdmin(String username);
}
