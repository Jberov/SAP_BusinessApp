
public class Main {
    public static void main(String[] args) {
        Database DB = new Database ();
        DB.DBConnection ();
        /*Scanner scan = new Scanner (System.in);
        Login Log = new Login ();
        Product product = new Product ();
        Administrator admin = new Administrator ();
        TradeRep trader = new TradeRep ();
        Sales sales = new Sales ();

        System.out.println ("Welcome to the beta business app.");
        System.out.println ("What are you:\n1.Admin\n2.TradeRep");
        byte role = scan.nextByte();
        scan.nextLine ();
        if(role==1){
            Log.loginAdmin (admin);
        }else if(role==2){
            Log.loginTradeRep (admin);
        }else{
            System.out.println ("Invalid role");
        }
        if(Log.isAdmin){
            System.out.println ("Welcome " + Log.getUsername () + " " + "What is your desire:\n1.Enter a new TradeRep \n2.Enter a new product\n3.Enter a new Admin\n4.Redact a TradeRep\n5.Redact a product\n6.Redact an admin\n7.Delete a TradeRep\n8.Delete a product\n9.Delete an admin");
            byte choice = scan.nextByte ();
            scan.nextLine ();
            switch (choice) {
                case 1 -> admin.addTradeRep ();
                case 2 -> product.add ();
                case 3 -> admin.add ();
                case 4 -> admin.redactTradeReps ();
                case 5 -> product.redact ();
                case 6 -> admin.redact ();
                case 7 -> admin.removeTradeReps ();
                case 8 -> product.remove ();
                case 9 -> admin.remove ();
                default -> System.out.println ("No such operation");
            }
            Log.logout ();
        }else if(Log.isTradeRep){
            System.out.println ("Welcome " + Log.getUsername () + " " +"What is your desire:\n1.Enter a new Client \n2.Redact a client\n3.Delete a client\n4.Enter a sale");
            byte choice = scan.nextByte ();
            scan.nextLine ();
            switch (choice) {
                case 1 -> trader.add ();
                case 2 -> trader.redact ();
                case 3 -> trader.remove ();
                case 4 -> sales.addSale ();
                default -> System.out.println ("No such operation");
            }
            Log.logout ();
        }

    }*/
    }
}
