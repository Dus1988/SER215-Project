import java.util.ArrayList;

public class Hand {
    /*------------------------------------------
    INSTANCE VARIABLES
    ------------------------------------------*/
    private int total;
    private ArrayList<Card> cards;
    /*
    ------------------------------------------
    END INSTANCE VARIABLES
    ------------------------------------------
    ------------------------------------------
    START CONSTRUCTORS
    ------------------------------------------*/
    public Hand() {
        total = 0;
        cards = new ArrayList<Card>(0);
    }
    /*
    ------------------------------------------
    END CONSTRUCTORS
    ------------------------------------------
    ------------------------------------------
    START METHODS
    ------------------------------------------*/
    public void addCard(Card card){
        this.cards.add(card);
        this.calcTotal();
    }

    /*This method will calculate the total.
    * It will begin by making sure Ace cards are handled properly.
    * From there it will handle face cards and their respective 10 value.
    * from there it will handle any non face cards.
    * Finally it will take the sum of all cards and store it in the hands total value.*/
    public void calcTotal(){
        int tempTotal = 0;
        for (Card card : cards){
            String cardValue = card.getValue();
            if (cardValue.equals("A") && tempTotal < 10)
                tempTotal += 11;
            else if (cardValue.equals("A") && tempTotal > 10)
                tempTotal += 1;
            else if (cardValue.equals("J") || cardValue.equals("Q") || cardValue.equals("K"))
                tempTotal +=10;
            else
                tempTotal += card.getNumValue();
            }
        this.total = tempTotal;
        }


        public int getTotal() {
            return total;
        }

    /*
    ------------------------------------------
    END METHODS
    ------------------------------------------*/
}
