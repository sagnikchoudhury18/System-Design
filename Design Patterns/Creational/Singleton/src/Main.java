public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        MySingleObjectClass o1 = MySingleObjectClass.getInstance();
        MySingleObjectClass o2 = MySingleObjectClass.getInstance();
        System.out.println("DEBUG");

    }
}