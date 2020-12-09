import java.util.Scanner;

public class Login{
    Scanner scan = new Scanner (System.in);
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername() {
        System.out.println ("Welcome. Please enter your username");
        this.username = scan.nextLine ();
    }

    public void setPassword() {
        System.out.println ("Welcome. Please enter your password");
        this.password = scan.nextLine ();
    }

    String username;
    String password;
    boolean isAdmin = false;
    boolean isTradeRep = false;
    public void loginAdmin(Administrator admin){
        try{
            setUsername ();
            setPassword ();
            if((getUsername ().equals(admin.Administrators.get(username).username)) && (getPassword ().equals(admin.Administrators.get (username).password))){
                isAdmin = true;
            }else {
                System.out.println ("Invalid username or password");
            }
        }catch (NullPointerException nptr){
            System.out.println ("No such user");
        }

    }
    public void loginTradeRep(Administrator admin){
        try{
            setUsername ();
            setPassword ();
            if (( getUsername ().equals (admin.TradeReps.get (username).username)) && (getPassword ().equals (admin.TradeReps.get (username).password))) {
                isTradeRep = true;
            }else {
                System.out.println ("Invalid username or password");
            }
        }catch (NullPointerException npe){
            System.out.println ("No such user");
        }
    }
    public void logout(){
        username = " ";
        password = " ";
        isAdmin = false;
        isTradeRep = false;
    }
}
