package grades;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a student record.
 * studentId is a unique ID identifies a student.
 * studentRecord has a map of all courses and grades this student has done or currently doing.
 * 
 * @author Jalal Sayed - 30/11/2021
 */
public class StudentRecord {

    private String studentId;
    protected Map<Course, Grade> studentRecord; //! protected?

    public StudentRecord(String studentId) {
        this.studentId = studentId;
        this.studentRecord = new HashMap<>();
    }

    public String getStudentId(){
        return this.studentId;
    }

    public void setGrade(Course course, Grade grade){
        studentRecord.put(course, grade);
    }

    public Grade getGrade(Course course){
        return studentRecord.get(course); //! does this return null if course not achieved?
    }

    public void removeGrade(Course course){
        studentRecord.put(course, null); //! does this null work?
    }

    /**
     * Computes GPA from a student record.
     * 
     * @return float number GPA result
     */
    public double computeGPA(){
        int creditWeight = 0;
        int totalPoints = 0;

        // if student has no grade for any of the courses, return 0.0:
        if(!studentRecord.values().isEmpty()){
            for(Course course: studentRecord.keySet()){
                creditWeight += course.getCredits();
                // totalPoints = sum of (credit * grade weight)
                totalPoints += course.getCredits() * studentRecord.get(course).getWeight(); //! does getWeight work?
            }
            return (totalPoints/(float)creditWeight);

        }else{
            return (0.0);
        }
    }

    /**
     * Updates a course grade.
     * If course grade has not been set before, it will call setGrade.
     * If course grade has been set before, grade will be updated if:
     * 1. old grade is less than C.
     * 2. new grade is bigger than old grade.
     * NB: updated grade will never be more than grade C.
     * 
     * @param course
     * @param grade
     */
    public void updateGrade(Course course, Grade grade){
        // if no previous grade available:
        if(studentRecord.get(course) == null){
            this.setGrade(course, grade);

        }else{
            // if currently stored grade is less than C:
            if(studentRecord.get(course).getWeight() < Grade.C.getWeight()){
                // The new grade is greater than the stored grade:
                if(grade.getWeight() > studentRecord.get(course).getWeight()){
                    this.setGrade(course, Grade.C);
                }
            }
        }
    }
}
