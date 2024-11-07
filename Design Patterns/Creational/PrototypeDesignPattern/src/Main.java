public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Student obj = new Student(20, 75, "Ram");
        Student cloneObj = (Student) obj.clone();
    }
}