package src.week9;

import src.week9.people.Person;

public class Student extends Person {

    private String[] courses;
    private int gradeAverage;

    public Student(String name, int age) {
       super(name, age);
       this.courses = new String[10];
       this.gradeAverage = 0;
    }

    @Override
    public String getName(){
//        return "Student: " + super.getName();
        return "Student: " + this.name;
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

    public void setGradeAverage(int gradeAverage) {
        this.gradeAverage = gradeAverage;
    }

    public int getGradeAverage() {
        return gradeAverage;
    }
}
