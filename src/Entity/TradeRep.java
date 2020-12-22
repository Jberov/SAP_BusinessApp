package Entity;

import Entity.User;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TradeRep extends User {
    private String username, password;
    private long ID;

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

    @Override
    public long getID() {
        return ID;
    }

    @Override
    public void setID(long ID) {
        this.ID = ID;
    }
    /*HashMap<String, User> clients = new HashMap<> ();
    Scanner scan = new Scanner (System.in);
    public void addClient() {
        User tempClient = new User ();

        System.out.println("You wish to add a new client. Very well");
        System.out.println("Please enter the name of the client");
        tempClient.Name = scan.nextLine ().toLowerCase();
        clients.put (Name, tempClient);
    }
    public void removeClient() {
        System.out.println("Enter the name of the client you wish to remove");
        try{
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
    }catch(InputMismatchException ime){
            System.out.println ("Enter a valid name with valid characters");
        }finally {
            System.out.println ("Client successfully removed");
        }
    }

    public void redactClient() {
        System.out.println("Enter the name of the client you wish to redact");
        try {
            String User = scan.nextLine ();
            if (!clients.containsKey (User)) {
                System.out.println ("No such Entity.Administrator");

            } else {
                User temp = clients.get (User);
                System.out.println ("Choose what to change");
                String choice = scan.nextLine().toLowerCase ();
                if ("name".equals (choice)) {
                    System.out.println ("Enter new name of the trade representative:");
                    temp.Name = scan.nextLine ();
                    clients.put (User, temp);
                } else {
                    System.out.println ("No such command. Please enter a valid value to be changed");
                }
            }
        }catch(IndexOutOfBoundsException iobe){
            System.out.println ("No such product found" + iobe.getMessage ());
        }finally{
            System.out.println ("Client has been changed");
        }
    }*/
}
