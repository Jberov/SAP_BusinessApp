import java.util.HashMap;

public class AdministratorDAOImpl implements AdministratorDAOInterface{
    HashMap<String, Administrator> Administrators;
    public AdministratorDAOImpl(){
        Administrators = new HashMap<> ();
        //TODO Perhaps add here an object for the specific Database DAO class
    }
    @Override
    public void addAdmin() {

        /*
        Administrator temp = new Administrator ();
        System.out.println("You wish to add a new administrator. Very well");
        System.out.println("Please enter the username of the administrator");
        temp.username = scan.readLine ();
        if(Administrators.containsKey (temp.username)){
            System.out.println ("An admin with such a username already exists. Please, choose another username.");
            return;
        }
        System.out.println("Please enter the password of the administrator");
        temp.password = scan.readLine ();
        System.out.println("Please enter the name of the administrator");
        temp.Name = scan.readLine ();
        Administrators.put (temp.username, temp);
        */
    }

    @Override
    public void redactAdmin() {
        /*
         System.out.println ("Enter the name of the administrator you wish to redact");
        String Administrator = scan.readLine ();
        if(!Administrators.containsKey (Administrator)){
            System.out.println ("No such Administrator");

        }else{
            Administrator temp = Administrators.get (Administrator);
            System.out.println ("Choose what to change");
            String choice = scan.readLine ().toLowerCase ();
            switch (choice) {
                case "username" -> {
                    System.out.println ("Enter new username of the trade representative:");
                    temp.username = scan.readLine ();
                    Administrators.put (Administrator, temp);
                }
                case "password" -> {
                    System.out.println ("Enter new password of the trade representative:");
                    temp.password = scan.readLine ();
                    Administrators.put (Administrator, temp);
                }
                case "name" -> {
                    System.out.println ("Enter new name of the trade representative:");
                    temp.Name = scan.readLine ();
                    Administrators.put (Administrator, temp);
                }
                default -> System.out.println ("No such command. Please enter a valid value to be changed");
            }

        }
         */
        //TODO Fix the AdminEntity, then uncomment them
    }

    @Override
    public void removeAdmin() {
        /*
         System.out.println("You wish to remove an administrator. Very well");
        System.out.println("Please enter the username of the administrator");
        String userName = scan.readLine ();
        if(!Administrators.containsKey (userName)){
            System.out.println ("No such Trade representative");

        }else{
            Administrators.remove (userName);
            System.out.println ("Administrator removed");
        }
         */
        //TODO Fix the AdminEntity, then uncomment them
    }
}
