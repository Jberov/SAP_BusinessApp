import java.util.Scanner;

public class Read {
    private final Scanner read;
    private static final Read instance = new Read ();
    private Read(){
        read = new Scanner (System.in);
    }
    public static Read getInstance(){
        return instance;
    }

    public String readLine(){
        return read.nextLine ();
    }
    public int readInt(){
        return read.nextInt ();
    }
    public double readDouble(){
        return read.nextDouble ();
    }
}
