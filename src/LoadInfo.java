public class LoadInfo implements Load{
    private Database loader;
    public LoadInfo(Database loader){
        this.loader = loader;
    }

    @Override
    public void execute() {
        loader.loadInfo ();
    }
}
