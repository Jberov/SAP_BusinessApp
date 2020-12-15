
class Administrator extends User {
    private String username, password;
    private long ID;
    public Administrator(){

    }

    public Administrator(String username, String password, long ID) {
        super();
        this.username = username;
        this.password = password;
        this.ID = ID;
    }


    //TODO Save the information to a DB - in progress
    /*
    public void addTradeRep(){
        TradeRep temp = new TradeRep ();
        System.out.println("You wish to add a new trade representative. Very well");
        System.out.println("Please enter the username of the trade representative");
        temp.username = scan.readLine ();
        if(TradeReps.containsKey (temp.username)){
            System.out.println ("A trade rep with such a username already exists. Please, choose another username.");
            return;
        }
        System.out.println("Please enter the password of the trade representative");
        temp.password = scan.readLine ();
        System.out.println("Please enter the name of the trade representative");
        temp.Name = scan.readLine ();
        TradeReps.put (temp.username, temp);

    }
    public void redactTradeReps(){
        System.out.println ("Enter the name of the trade representative you wish to redact");
        String TradeRep = scan.readLine ();
        if(!TradeReps.containsKey (TradeRep)){
            System.out.println ("No such Trade representative");
            
        }else{
            TradeRep temp = TradeReps.get (TradeRep);
            System.out.println ("Choose what to change");
            String choice = scan.readLine ().toLowerCase ();
            switch (choice) {
                case "username" -> {
                    System.out.println ("Enter new username of the trade representative:");
                    temp.username = scan.readLine ();
                    TradeReps.put (TradeRep, temp);
                }
                case "password" -> {
                    System.out.println ("Enter new password of the trade representative:");
                    temp.password = scan.readLine ();
                    TradeReps.put (TradeRep, temp);
                }
                case "name" -> {
                    System.out.println ("Enter new name of the trade representative:");
                    temp.Name = scan.readLine ();
                    TradeReps.put (TradeRep, temp);
                }
                default -> System.out.println ("No such command. Please enter a valid value to be changed");
            }

        }
    }
    public void removeTradeReps (){
        System.out.println("You wish to remove a trade representative. Very well");
        System.out.println("Please enter the username of the trade representative");
        String userName = scan.readLine ();
        if(!TradeReps.containsKey (userName)){
            System.out.println ("No such Trade representative");

        }else{
            TradeReps.remove (userName);
            System.out.println ("Trade representative removed");
        }
    }*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
}
