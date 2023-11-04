package src.week7;

public class CST {
    public static void main(String[] args) {

        Instructor[] cstInstructors = new Instructor[5];

        cstInstructors[0] = new Instructor("Bryce", 28);
        cstInstructors[1] = new Instructor("Ben", 28);
        cstInstructors[2] = new Instructor("Michael", 28);
        cstInstructors[3] = new Instructor("Coralee", 28);
        cstInstructors[4] = new Instructor("Donovyn", 28);

        Student[] cstStudents = new Student[4];
        cstStudents[0] = new Student("Nick", 21);
        cstStudents[1] = new Student("Jackson", 45);
        cstStudents[2] = new Student("Andrew", 7);
        cstStudents[3] = new Student("Donavyn", 19);

        School saskPoly = new School("SaskatchewanPolyTechnic", cstInstructors, cstStudents);

        System.out.println(saskPoly.getStudentNames());
        saskPoly.addStudent(new Student("Bill", 27));
        System.out.println(saskPoly.getStudentNames());

        saskPoly.addInstructor(new Instructor("Dave", 42));


    }
}
