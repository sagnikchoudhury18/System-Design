public class Student {

    //attributes
    String name;
    int age;
    boolean isStudent;
    String university;
    double psp;
    int phone;
    String email;
    String batchName;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isStudent=" + isStudent +
                ", university='" + university + '\'' +
                ", psp=" + psp +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", batchName='" + batchName + '\'' +
                '}';
    }

    Student(StudentBuilder studentBuilder) {
        this.name = studentBuilder.getName();
        this.age = studentBuilder.getAge();

        //we are doing the validations in the constructor while creation of an object
        if (age<0){
            throw  new RuntimeException();
        }
        if (psp<0 || psp>100){
            throw  new RuntimeException();
        }
    }

    public  static  StudentBuilder getBuilder() {
        return  new StudentBuilder();
    }
}
