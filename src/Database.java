import java.sql.*;


class Database{
    private static Statement statement;
    private static ResultSet result;
    /*Administrator admin = new Administrator ();
    TradeRep trader = new TradeRep ();
    User client;
    Product product;
    Sales sale;*/
    public void openDBConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost/shopdatabase", "root", "");
            statement= conn.createStatement();
        }catch(SQLException s){
            s.printStackTrace ();
        }catch (ClassNotFoundException cnfe)
        {
            System.out.println ("Drivers....");
        }
    }
    private void loadAdmins(){
        try {
            result = statement.executeQuery ("select * from administrators");
            while(result.next()) {
                admin.Name = result.getString (2);
                admin.ID = result.getLong (1);
                admin.username = result.getString (3);
                admin.password = result.getString (4);
                admin.Administrators.put ( admin.Name, admin);
            }
        }catch(SQLException sqle){
            sqle.printStackTrace ();
        }
    }
    private void loadTradeReps(){
        try {
            result = statement.executeQuery ("select * from tradereps");
            while(result.next()) {
                trader.Name =  result.getString (2);
                trader.ID = result.getLong (1);
                trader.username = result.getString (3);
                trader.password = result.getString (4);
                admin.TradeReps.put (trader.Name, trader);
            }
        }catch(SQLException sqle){
            sqle.printStackTrace ();
        }
    }
    private void loadClients(){
        client = new User ();
        try {
            result = statement.executeQuery ("select * from clients");
            while(result.next()) {
                client.Name =  result.getString (1);
                client.ID = result.getLong (2);
                System.out.println (client.ID + " " + client.Name);
                trader.clients.put (client.Name, client);
            }
        }catch(SQLException sqle){
            sqle.printStackTrace ();
        }
    }
    private void loadProducts(){
         product = new Product ();
        try {
            result = statement.executeQuery ("select * from products");
            while(result.next()) {
                product.ID =  result.getLong (1);
                product.name = result.getString (2);
                product.price = result.getDouble ("Price");
                product.products.put (product.name, product);
            }
        }catch(SQLException sqle){
            sqle.printStackTrace ();
        }
    }
    private void loadSales(){
        sale = new Sales ();
        try {
            result = statement.executeQuery ("select * from sales");
            while(result.next()) {
                sale.ID =  result.getLong (1);
                sale.time_of_sale = result.getTimestamp (2);
                sale.quantity = result.getInt ("Quantity");
                sale.TotalPrice = result.getDouble (5);
               sale.sales.add (sale);
            }
        }catch(SQLException sqle){
            sqle.printStackTrace ();
        }
    }


}
