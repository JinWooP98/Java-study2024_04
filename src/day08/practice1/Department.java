package day08.practice1;

public class Department {

    String departmentName;
    int studentCount;
    static int totalStudents;

    Department (String departmentName, int studentCount) {
        this.departmentName = departmentName;
        this.studentCount = studentCount;
        totalStudents += studentCount;
    }

    void addStudent (int num) {
        this.studentCount += num;
        totalStudents += num;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public static int getTotalStudents() {
        return totalStudents;
    }
}
