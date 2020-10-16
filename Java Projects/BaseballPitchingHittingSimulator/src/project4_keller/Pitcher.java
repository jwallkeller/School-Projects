
package project4_keller;

/**
 *
 * @author Jack
 */
public class Pitcher {
    private String name;
    private double average;
    
    public Pitcher(String name, double average) {
        this.name = name;
        this.average = average;
    }
    
    // The pitch function determines whether the pitcher throws a ball or a 
    // strike, depending on their average.
    
    public boolean pitch() {
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
