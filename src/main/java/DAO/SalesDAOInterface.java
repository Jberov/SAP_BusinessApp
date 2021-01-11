package DAO;

 interface SalesDAOInterface {
    boolean addSale(String product, String client, int quantity, String trader);
}
