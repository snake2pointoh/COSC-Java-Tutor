package src.week7;

public class School {
    private String name;
    private Instructor[] instructors;
    private Student[] students;

    private static final int STUDENT_COUNT = 50;
    private static final int INSTRUCTOR_COUNT = 10;
    private static final int ARRAY_GROW_SIZE = 10;

    public School(String name) {
        this(name, new Instructor[INSTRUCTOR_COUNT], new Student[STUDENT_COUNT]);
    }

    public School(String name, Instructor[] instructors) {
        this(name, instructors, new Student[STUDENT_COUNT]);
    }

    public School(String name, Instructor[] instructors, Student[] students) {
        this.name = name;
        this.instructors = instructors;
        this.students = students;
    }


    public void addStudent(Student stu) {

        // add the student to the end
        for (int i = 0; i < this.students.length; i++) {
            if(students[i] == null) {
                students[i] = stu;
                return;
            }
        }

        // if there is no room grow the array and try again
        this.students = growStudentArray(this.students);
        this.addStudent(stu);
    }

    public void addInstructor(Instructor inst) {

        for (int i = 0; i < this.instructors.length; i++) {
            if(instructors[i] == null) {
                instructors[i] = inst;
                return;
            }
        }

        this.growInstructorArray();
        this.addInstructor(inst);
    }

    private static Student[] growStudentArray(Student[] array) {
        Student[] newArray = new Student[array.length + ARRAY_GROW_SIZE];
        // copy old array
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        return newArray;
    }

    private void growInstructorArray() {
        Instructor[] newArray = new Instructor[this.instructors.length + ARRAY_GROW_SIZE];

        for (int i = 0; i < this.instructors.length; i++) {
            newArray[i] = this.instructors[i];
        }

        this.instructors = newArray;
    }

    public String getName() {
        return this.name;
    }

    public Instructor[] getInstructors() {
        return this.instructors;
    }

    public Student[] getStudents() {
        return this.students;
    }

    public String getStudentNames() {
        String names = "";
        for ( Student student : students ) {
            if(student == null) {
                break;
            }

            names += student.getName() + ", ";
        }

        names = names.substring(0,names.length()-2);

        return names;
    }

}
