package CommandPattern;

public interface LoginCommand {
    boolean execute(String username, String password);
}
