public class NewStudent {

    public static void main(String[] args) {
        StudentBuilder studentBuilder = new StudentBuilder();
        studentBuilder.setName("Rahul");
        studentBuilder.setUniversity("VIT");

        Student st = new Student(studentBuilder);

        System.out.println(st.toString());

        /*OR
        StudentBuilder studentBuilder2 = Student.getBuilder();
        studentBuilder2.setName("Rahul");
        studentBuilder2.setUniversity("VIt");
        studentBuilder2.build();

        Note: In case we wantg to do chaining while using the builder we will have
                to return a StudentBuilder type after setting each parameter
        */


    }
}
