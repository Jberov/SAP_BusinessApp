import java.util.HashMap;
import java.util.Scanner;

public class TradeRep extends User implements Operations{
    String username, password;
    HashMap<String, User> clients = new HashMap<> ();
    HashMap<String, TradeRep> TradeReps = new HashMap<> ();
    Scanner scan = new Scanner(System.in);
    @Override
    //Adds a client
    public void add() {
        User tempClient = new User ();

        System.out.println("You wish to add a new client. Very well");
        System.out.println("Please enter the name of the client");
        tempClient.Name = scan.nextLine().toLowerCase();
        clients.put (Name, tempClient);
    }

    @Override
    //Removes a client
    public void remove() {
        System.out.println("Enter the name of the client you wish to remove");
        String name = scan.nextLine();
        if(!clients.containsKey (name)){
            System.out.println ("No such Trade representative");

        }else {
            try {
                clients.remove (name);
            } catch (IndexOutOfBoundsException iobe) {
                System.out.println ("No such client found");
            } finally {
                System.out.println ("Client has been successfully removed");
            }
        }
    }

    @Override
    //Redacts a client
    public void redact() {
        System.out.println("Enter the name of the client you wish to redact");
        try {
            String User = scan.nextLine ();
            if (!clients.containsKey (User)) {
                System.out.println ("No such Administrator");

            } else {
                User temp = clients.get (User);
                System.out.println ("Choose what to change");
                String choice = scan.nextLine ().toLowerCase ();
                if ("name".equals (choice)) {
                    System.out.println ("Enter new name of the trade representative:");
                    temp.Name = scan.nextLine ();
                    clients.put (User, temp);
                } else {
                    System.out.println ("No such command. Please enter a valid value to be changed");
                }
            }
        }catch(IndexOutOfBoundsException iobe){
            System.out.println ("No such product found");
        }finally{
            System.out.println ("Client has been changed");
        }
    }
}
