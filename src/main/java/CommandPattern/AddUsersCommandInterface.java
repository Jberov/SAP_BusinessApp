package CommandPattern;

public interface AddUsersCommandInterface {
    boolean execute(String username, String email, String password, String name);
}
