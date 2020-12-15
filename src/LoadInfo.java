public class LoadInfo implements Command {
    private Database loader;
    public LoadInfo(Database loader){
        this.loader = loader;
    }

    @Override
    public void execute() {
        loader.loadInfo ();
    }
}
