package grades;

import java.util.Objects;

/**
 * Represents a single course that students can take.
 * name is the name of the course.
 * credits is how many credits students can get when completing the course.
 * 
 * @author Jalal Sayed - 30/11/2021
 */
public class Course {

    private String name;
    private int credits;

    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public String getName() {
        return this.name;
    }

    public int getCredits() {
        return this.credits;
    }
    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Course)) {
            return false;
        }
        Course courses = (Course) o;
        return Objects.equals(name, courses.name) && credits == courses.credits;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, credits);
    }


    @Override
    public String toString() {
        return "Course name is " + getName() + " which has credits equals to " + getCredits();
    }

}
