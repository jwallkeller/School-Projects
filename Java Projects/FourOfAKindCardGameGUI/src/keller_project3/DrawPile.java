package keller_project3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Jack Keller
 */
public class DrawPile {

    Queue<Card> deck = new LinkedList<>();

    public DrawPile() {
        ArrayList<Card> list = new ArrayList<>();

        String suit = "Hearts";

        for (int i = 0; i < 4; i++) {
            if (i == 1) {
                suit = "Diamonds";
            } else if (i == 2) {
                suit = "Clubs";
            } else if (i == 3) {
                suit = "Spades";
            }
            for (int j = 0; j < 13; j++) {
                if (j == 0) {
                    Card card = new Card("Ace", suit);
                    list.add(card);
                } else if (j == 1) {
                    Card card = new Card("Two", suit);
                    list.add(card);
                } else if (j == 2) {
                    Card card = new Card("Three", suit);
                    list.add(card);
                } else if (j == 3) {
                    Card card = new Card("Four", suit);
                    list.add(card);
                } else if (j == 4) {
                    Card card = new Card("Five", suit);
                    list.add(card);
                } else if (j == 5) {
                    Card card = new Card("Six", suit);
                    list.add(card);
                } else if (j == 6) {
                    Card card = new Card("Seven", suit);
                    list.add(card);
                } else if (j == 7) {
                    Card card = new Card("Eight", suit);
                    list.add(card);
                } else if (j == 8) {
                    Card card = new Card("Nine", suit);
                    list.add(card);
                } else if (j == 9) {
                    Card card = new Card("Ten", suit);
                    list.add(card);
                } else if (j == 10) {
                    Card card = new Card("Jack", suit);
                    list.add(card);
                } else if (j == 11) {
                    Card card = new Card("Queen", suit);
                    list.add(card);
                } else if (j == 12) {
                    Card card = new Card("King", suit);
                    list.add(card);
                }
            }
        }

        Collections.shuffle(list);

        deck = new LinkedList<>(list);

    }

    public Queue<Card> getDeck() {
        return deck;
    }

    public Card drawFromDeck() {
        return deck.poll();
    }

    public void shuffleDeck(ArrayDeque<Card> discard) {
        ArrayList<Card> list = new ArrayList<>(discard);

        Collections.shuffle(list);

        deck = new LinkedList<>(list);
    }
}
