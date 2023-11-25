package src.week9;

import src.week9.people.Person;

public class Instructor extends Person {

    private String[] courses;

    public Instructor(String name, int age) {
        super(name, age);
        this.courses = new String[10];
    }

    public void addCourse(String courseName) {
        for (int i = 0; i < courses.length; i++) {
            if(courses[i] == null) {
                courses[i] = courseName;
            }
        }
    }

    public String[] getCourses() {
        return courses;
    }
}
