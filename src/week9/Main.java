package src.week9;

import src.week9.people.Person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Nick", 22);
        Student student = new Student("Bryce",31);
        Person instructor = new Instructor("Donovyn", 21);

        Person[] people = new Person[3];
        people[0] = person;
        people[1] = student;
        people[2] = instructor;

        System.out.println(person);
        System.out.println(instructor);
        System.out.println(student.getName());

//         instructor.addCourse("CNET");
        Instructor inst1 = (Instructor) instructor;
        inst1.addCourse("CNET");

        if(people[1] instanceof Student) {
            System.out.println("is a student");
        }

    }
}
