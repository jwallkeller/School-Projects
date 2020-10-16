
package project4_keller;

/**
 *
 * @author Jack
 */
public class Batter {
    private String name;
    private double average;
    
    public Batter(String name, double average) {
        this.name = name;
        this.average = average;
    }
    
    // The hit function dtermines whether the batter hits or misses the ball 
    // depending on their average.
    
    public boolean hit() {
        if((((double)(Math.random() *  100.00)) / 100.00) <= average) {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }
    
}
