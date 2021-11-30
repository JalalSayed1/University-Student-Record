package grades;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Course c1 = new Course("CS1", 3);
        Course c2 = new Course("CS2", 2);
        Course c3 = new Course("CS1", 3);

        System.out.println("course 1 name: " + c1.getName());
        System.out.println("course 1 credit: " + c1.getCredits());
        System.out.println("course 1 toString: " + c1.toString());
        System.out.println("course 1 == course 2 (false?): " + (c1.equals(c2)));
        System.out.println("course 1 == course 3 (true?): " + (c1.equals(c3)));

        StudentRecord s1 = new StudentRecord("01");
        StudentRecord s2 = new StudentRecord("02");
        StudentRecord s3 = new StudentRecord("03");

        s1.studentRecord.put(c1, Grade.B); //! instead of A
        s1.studentRecord.put(c2, Grade.C);
        s2.studentRecord.put(c1, Grade.B);
        s3.studentRecord.put(c2, Grade.F);

        System.out.println("student 1 id: " + s1.getStudentId());
        System.out.println("student 1 course 1 grade (B?): " + s1.getGrade(c1));
        s1.removeGrade(c1);
        System.out.println("student 1 course 1 grade (null?): " + s1.getGrade(c1));
        s1.setGrade(c1, Grade.A);
        System.out.println("student 1 course 1 grade (A?): " + s1.getGrade(c1));
        s1.updateGrade(c1, Grade.C);
        System.out.println("student 1 course 1 grade (did not change form A?): " + s1.getGrade(c1));
        System.out.println("student 1 GPA: " + s1.computeGPA());

        List<StudentRecord> l = new ArrayList<>();
        l.add(s1);
        l.add(s2);
        l.add(s3);
        CampusRecords.printCourseAverages(l);
 }  
}
