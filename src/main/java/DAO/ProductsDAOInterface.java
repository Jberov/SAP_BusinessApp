package DAO;


 interface ProductsDAOInterface {
    boolean addProduct(String name, double price, int quantity, String email);
    boolean removeProduct(String name);

}
