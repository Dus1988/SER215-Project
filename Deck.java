
/**
 * Represents the full deck, composed of 52 Card objects.
 * 
 * @author Zack Valentine
 * @version 1.0
 */
import java.util.*;
import java.util.ArrayList;

public class Deck
{
    // instance variables
    public ArrayList<Card> deck;

    /**
     * Generic constructor

    public Deck()
    {
    }
         */

    /**
     * Constructor
     */
    public Deck()
    {
        String suitsArray[] = new String[4];
        suitsArray[0] = "hearts";
        suitsArray[1] = "diamonds";
        suitsArray[2] = "spades";
        suitsArray[3] = "clubs";
        
        // Loop over the suits to create cards
        for (int i = 0; i < 4; i++) {
            int total = i;
            // Loop over the numbers 1-13 to create cards in the suit
            for (int j = 1; j < 14; j++) {
                String suit = suitsArray[i];
                String value;
                if (j == 1) {
                    value = "A";
                }
                else if (j == 11) {
                    value = "J";
                }
                else if (j == 12) {
                    value = "Q";
                }
                else if (j == 13) {
                    value = "K";
                }
                else {
                    value = String.valueOf(j);
                }
                Card nextCard = new Card(j,value,suit);
                deck.add(nextCard);
            }
    }
    this.Shuffle();
}

    
    /**
     * Shuffle method version 1
   
    public void Shuffle()
    {
        int newI;
        Card temp;
        Random rand = new Random();
        
        for (int i = 0; i < deck.length; i++) {
            
            newI = rand.nextInt(deck.length);
            temp = deck[i];
            deck[i] = deck[newI];
            deck[newI] = temp;
        }
    }
   */
  
    /*
     * Shuffle method version 2
     */
    public void Shuffle() {
        Random rand = new Random();
        Collections.shuffle(deck,rand);
    }
    

    public Deck refresh() {
        // generate a new Deck object to get a freshly shuffled deck
        return new Deck();
    }

    public Card dealCard(Player player) {
        // get the card to return
        Card nextCard = deck.get(0);
        deck.remove(0);
        return nextCard;
    }
}
