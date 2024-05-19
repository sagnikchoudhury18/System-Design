public class MultithreadedSingleton1 {

    private String x;

    private static MultithreadedSingleton1 multithreadedSingleton1;

    private MultithreadedSingleton1(){

    }

    public  static MultithreadedSingleton1 getInstance(){
        if(multithreadedSingleton1 == null){
            synchronized (MultithreadedSingleton1.class){
                if(multithreadedSingleton1==null){
                    multithreadedSingleton1 = new MultithreadedSingleton1();
                }
            }
        }
        return multithreadedSingleton1;
    }

}
