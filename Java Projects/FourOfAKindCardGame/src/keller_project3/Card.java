
package keller_project3;

/**
 *
 * @author Jack Keller
 */
public class Card {
    private String value;
    private String suit;
    
    public Card (String value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
    
    
}


