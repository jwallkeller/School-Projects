
package keller_project3;

import java.util.ArrayDeque;

/**
 *
 * @author Jack Keller
 */
public class DiscardPile {
    ArrayDeque<Card> discard = new ArrayDeque<>();
    
    public DiscardPile() {
        
    }
    
    public Card drawFromDiscard() {
        return discard.pollLast();
    }
    
    public void addToDiscard(Card toAdd) {
        discard.push(toAdd);
    }
    
    public Card view() {
        return discard.peek();
    }

    public ArrayDeque<Card> getDiscard() {
        return discard;
    }
    
    public void clearDiscard() {
        discard.clear();
    }
}
