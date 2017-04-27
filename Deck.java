/**
 * Represents the full deck, composed of 52 Card objects.
 * 
 * @author Zack Valentine
 * @version 1.0
 */
public class Deck
{
    // instance variables - replace the example below with your own
    public ArrayList deck = new ArrayList();

    /**
     * Generic constructor
     */
    public Deck()
    {
    }

    /**
     * Constructor
     */
    public Deck()
    {
        String suitsArray = new String[];
        suitsArray = "hearts","diamonds","spades","clubs";
        
        // Loop over the suits to create cards
        for (int i = 0; i < 4; i++) {
            int total = i;
            // Loop over the numbers 1-13 to create cards in the suit
            for (int j = 1; j < 14; j++) {
                String suit = suitsArray[i];
                if (j = 1) {
                    String value = "A";
                }
                else if (j = 11) {
                    String value = "J";
                }
                else if (j = 12) {
                    String value = "Q";
                }
                else if (j = 13) {
                    String value = "K";
                }
                else {
                    String value = j.toString();
                }
                Card nextCard = new Card(j,value,suit);
                deck.add(newCard);
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
        shuffle(deck,rand);
    }
    

    public void refresh() {
        // generate a new Deck object to get a freshly shuffled deck
        deck = new Deck();
    }
