package DAO;

 interface ClientDAOInterface {
    boolean addClient(String name, String email, String trader);
    boolean removeClient(String name);
}
