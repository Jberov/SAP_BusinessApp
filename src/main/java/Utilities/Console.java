package Utilities;

public class Console {
    private static final Console instance = new Console ();
    private Console(){

    }
    public static Console getInstance(){
        return instance;
    }

    public void printLine(String arg){
        System.out.println (arg);
    }
}
