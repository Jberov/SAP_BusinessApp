package DAO;

import java.util.Scanner;

public class Console {
    private final Scanner read;
    private static final Console instance = new Console ();
    private Console(){
        read = new Scanner (System.in);
    }
    public static Console getInstance(){
        return instance;
    }

    public String readLine(){
        return read.nextLine ();
    }
    public int readInt(){
        int value = read.nextInt ();
        readLine ();
        return value;
    }
    public double readDouble(){
        double value = read.nextDouble ();
        readLine ();
        return value;
    }
    public void printLine(String arg){
        System.out.println (arg);
    }
}
