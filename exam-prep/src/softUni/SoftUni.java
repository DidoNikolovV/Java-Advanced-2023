package softUni;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SoftUni {
    List<Student> students;
    private int capacity;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return this.students.size();
    }

    public String insert(Student student) {

        if(studentExists(student.getFirstName(), student.getLastName())) {
            return "Student is already in the hall.";
        }

        if(students.size() >= capacity) {
            return "The hall is full";
        }

        this.students.add(student);
        return "Added student " + student.getFirstName() + " " + student.getLastName() +".";
    }

    public Student getStudent(String firstName, String lastName) {
        return this.students.stream().filter(s -> s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)).collect(Collectors.toList()).get(0);
    }

    public String remove(Student student) {
        if(studentExists(student.getFirstName(), student.getLastName())) {
            this.students.remove(student);
            return "Removed student " + student.getFirstName() + " " + student.getLastName() + ".";
        }

        return "Student not found.";
    }

    public String getStatistics() {
        return String.format("Hall size: %d%n%s",
                this.students.size(),
                getInfoForEachStudent()
        );
    }

    public boolean studentExists(String firstName, String lastName) {
        Student foundStudent = null;
        for (int i = 0; i < students.size(); i++) {
            Student currentStudent = students.get(i);
            if(currentStudent.getFirstName().equals(firstName) && currentStudent.getLastName().equals(lastName)) {
                foundStudent = currentStudent;
            }
        }

        return foundStudent != null;

    }

    public String getInfoForEachStudent() {
        StringBuilder sb = new StringBuilder();
        for (Student student : this.students) {
            sb.append(student.toString());
        }
        return sb.toString();
    }
}
