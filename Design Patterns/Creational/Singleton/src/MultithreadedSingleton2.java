public class MultithreadedSingleton2 {

    private String x;


    //This way we are creationg the object during server startup which is using early initialization
    private static MultithreadedSingleton2 instance = new MultithreadedSingleton2();

    private MultithreadedSingleton2(){

    }

    public static MultithreadedSingleton2 getInstance() {
        return  instance;
    }


}
