package DAO;

  public interface TraderDAOInterface {
     boolean addTrader(String username, String email, String password, String name);
     boolean redactUsername(String username, String newUsername);
     boolean redactPassword(String username, String pass);
     boolean redactEmail(String username, String email);
     boolean redactName(String username, String name);
     boolean removeTrader(String username);
}
