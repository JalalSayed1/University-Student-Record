package grades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * class container for printCourseAverages method.
 * 
 * @author Jalal Sayed - 30/11/2021
 */
public class CampusRecords {
    /**
     * Prints the average result students have achieved in each course.
     * @param studentRecords => list of student records.
     */
    public static void printCourseAverages(List<StudentRecord> studentRecords){ // map studentRecord has course => grade

        // Map: course name => grade weight:
        Map<String, ArrayList<Integer>> courses = new HashMap<>();

        for(StudentRecord student: studentRecords){
            for(Course course: student.studentRecord.keySet()){
                // if course is not in the map:
                if(!courses.containsKey(course.getName())){
                    courses.put(course.getName(), new ArrayList<>());
                }
                // add grade weight to the list of this course:
                courses.get(course.getName()).add(student.studentRecord.get(course).getWeight());
            }
        }

        for(String course: courses.keySet()){
            int sum = courses.get(course).stream().mapToInt(i -> i.intValue()).sum();
            int length = courses.get(course).size();
            float average = sum/(float)length;
            System.out.println(course + ": " + average);
        }

    }
}
