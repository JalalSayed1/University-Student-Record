package grades;

/**
 * Represents grade that students can get in a course.
 * 
 * @author Jalal Sayed - 30/11/2021
 */
public enum Grade{
    A(4), B(3), C(2), D(1), F(0);

    private int weight;
    
    Grade(int weight){
        this.weight = weight;
    }

    public int getWeight(){
        return weight;
    }
} 