import java.util.HashMap;
import java.util.Scanner;

public class Administrator extends User implements Operations{
    public Administrator(){
        super();
    }
    Scanner scan = new Scanner(System.in);
    HashMap<String, TradeRep> TradeReps = new HashMap<> ();
    HashMap<String, Administrator> Administrators = new HashMap<> ();
    String username, password;
    //TODO Save the information to a DB
    @Override
    //Adds a new Admin
    public void add() {
        Administrator temp = new Administrator ();
        System.out.println("You wish to add a new administrator. Very well");
        System.out.println("Please enter the username of the administrator");
        temp.username = scan.nextLine();
        if(Administrators.containsKey (temp.username)){
            System.out.println ("An admin with such a username already exists. Please, choose another username.");
            return;
        }
        System.out.println("Please enter the password of the administrator");
        temp.password = scan.nextLine();
        System.out.println("Please enter the name of the administrator");
        temp.Name = scan.nextLine();
        Administrators.put (temp.username, temp);
        System.out.println (Administrators.get(temp.username).username + " " + Administrators.get(temp.username).password + " " + Administrators.get(temp.username).Name);
    }

    @Override
    //Redacts an Admin
    public void redact() {
        System.out.println ("Enter the name of the trade representative you wish to redact");
        String Administrator = scan.nextLine ();
        if(!Administrators.containsKey (Administrator)){
            System.out.println ("No such Administrator");

        }else{
            Administrator temp = Administrators.get (Administrator);
            System.out.println ("Choose what to change");
            String choice = scan.nextLine ().toLowerCase ();
            switch (choice) {
                case "username" -> {
                    System.out.println ("Enter new username of the trade representative:");
                    temp.username = scan.nextLine ();
                    Administrators.put (Administrator, temp);
                }
                case "password" -> {
                    System.out.println ("Enter new password of the trade representative:");
                    temp.password = scan.nextLine ();
                    Administrators.put (Administrator, temp);
                }
                case "name" -> {
                    System.out.println ("Enter new name of the trade representative:");
                    temp.Name = scan.nextLine ();
                    Administrators.put (Administrator, temp);
                }
                default -> System.out.println ("No such command. Please enter a valid value to be changed");
            }

        }
    }

    @Override
    //Removes an Admin
    public void remove() {
        System.out.println("You wish to remove an administrator. Very well");
        System.out.println("Please enter the username of the administrator");
        String userName = scan.nextLine();
        if(!Administrators.containsKey (userName)){
            System.out.println ("No such Trade representative");

        }else{
            Administrators.remove (userName);
            System.out.println ("Administrator removed");
        }
    }

    public void addTradeRep(){
        TradeRep temp = new TradeRep ();
        System.out.println("You wish to add a new trade representative. Very well");
        System.out.println("Please enter the username of the trade representative");
        temp.username = scan.nextLine();
        if(TradeReps.containsKey (temp.username)){
            System.out.println ("A trade rep with such a username already exists. Please, choose another username.");
            return;
        }
        System.out.println("Please enter the password of the trade representative");
        temp.password = scan.nextLine();
        System.out.println("Please enter the name of the trade representative");
        temp.Name = scan.nextLine();
        TradeReps.put (temp.username, temp);

    }
    public void redactTradeReps(){
        System.out.println ("Enter the name of the trade representative you wish to redact");
        String TradeRep = scan.nextLine ();
        if(!TradeReps.containsKey (TradeRep)){
            System.out.println ("No such Trade representative");
            
        }else{
            TradeRep temp = TradeReps.get (TradeRep);
            System.out.println ("Choose what to change");
            String choice = scan.nextLine ().toLowerCase ();
            switch (choice) {
                case "username" -> {
                    System.out.println ("Enter new username of the trade representative:");
                    temp.username = scan.nextLine ();
                    TradeReps.put (TradeRep, temp);
                }
                case "password" -> {
                    System.out.println ("Enter new password of the trade representative:");
                    temp.password = scan.nextLine ();
                    TradeReps.put (TradeRep, temp);
                }
                case "name" -> {
                    System.out.println ("Enter new name of the trade representative:");
                    temp.Name = scan.nextLine ();
                    TradeReps.put (TradeRep, temp);
                }
                default -> System.out.println ("No such command. Please enter a valid value to be changed");
            }

        }
    }
    public void removeTradeReps (){
        System.out.println("You wish to remove a trade representative. Very well");
        System.out.println("Please enter the username of the trade representative");
        String userName = scan.nextLine();
        if(!TradeReps.containsKey (userName)){
            System.out.println ("No such Trade representative");

        }else{
            TradeReps.remove (userName);
            System.out.println ("Trade representative removed");
        }
    }
}
