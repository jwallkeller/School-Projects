
package keller_project3;

import java.util.ArrayList;

/**
 *
 * @author Jack Keller
 */
public class Player {
    private String name;
    private ArrayList<Card> hand;
    private boolean turn;
    
    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
        turn = true;
    }
    
    public void AddToHand(Card card) {
        hand.add(card);
    }
    
    public void removeFromHand(Card card) {
        hand.remove(card);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
    
    public boolean getTurn() {
        return turn;
    }
    
    public void changeTurn() {
        if(turn) {
            turn = false;
        } else {
            turn = true;
        }
    }
    
    public char checkStatus() {
        String value = hand.get(0).getValue();
        for(Card c : hand) {
            if(!value.equals(c.getValue())) {
                return 'n';
            }
        }
        return 'p';
    }
    
    
}
