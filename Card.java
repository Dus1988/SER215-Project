
/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card
{
    // instance variables
    public int numValue;
    public String value;
    protected String suit;

    /**
     * Generic constructor
     */
    public Card()
    {
        // initialise instance variables
        this.numValue = 0;
        this.value = "A";
        this.suit = "hearts";
    }
    
    /**
     * Constructor for Deck construction
     */
    public Card(int number, String denomination, String cardSuit)
    {
        // initialise instance variables
        this.numValue = number;
        this.value = denomination;
        this.suit = cardSuit;
    }

    /*------------------------------------------------------------
    START GETTERS AND SETTERS
    ------------------------------------------------------------*/
    
    // numeric value getter
    public int getNumValue() {
        return numValue;
    }
    
    // numeric value setter
    public void setNumValue(int value) {
        this.numValue = value;
    }
    
    // value getter
    public String getValue() {
        return value;
    }
    
    // value setter
    public void setValue(String newValue) {
        this.value = newValue;
    }
    
    // suit getter
    public String getSuit() {
        return suit;
    }
    
    // suit setter
    public void setSuit(String newSuit) {
        this.suit = newSuit;
    }

    /*------------------------------------------------------------
    END GETTERS AND SETTERS
    ------------------------------------------------------------*/
}
