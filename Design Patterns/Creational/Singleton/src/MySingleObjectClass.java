public class MySingleObjectClass {

    private String x;
    private static MySingleObjectClass instance;

    private MySingleObjectClass() {

    }

    public static MySingleObjectClass getInstance() {
        if (instance == null){
            instance = new MySingleObjectClass();
        }
        return instance;
    }
}

/* This approach will work fine in a single threaded env. But in case of multithreaded env it will cause issues.*/
