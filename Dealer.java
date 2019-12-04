/**
 *  This is the 2nd version of Player for SER215 project
 *
 *  @author Dustin Godin
 *  @version 2.0
 *  @date 4/27/2017
 */
public class Dealer extends Player {
    /*--------------------------------------
    START CONSTRUCTORS
    --------------------------------------*/
    public Dealer() {
        this.money = 0;
        this.total = 0;
        this.bust = false;
        this.isStanding = false;
        this.hand = new Hand();

    }

    /*--------------------------------------
    END CONSTRUCTORS
    --------------------------------------
    --------------------------------------
    START METHODS
    --------------------------------------*/

    /*This method should only be called if the player does not bust on their turn.
    * Dealer has to hit if their total is less than 17. If over or equal, they do not hit.*/
    public void chooseAction(){
        //get total at current time
        total = this.hand.getTotal();

        if (total < 17){
            Blackjack.dealToDealer();
        }
        else {
            this.stand();
            Blackjack.checkWinner();
        }
    }

    //Override the hit method so that it can visually deal a card to the dealer instead.
    @Override
    public void hit(Card card) {
        this.hand.addCard(card);
        Blackjack.dealCard(0, card);
        this.setTotal(hand.getTotal());
        if (this.total > 21)
            this.setBust(true);
    }

    /*--------------------------------------
    END METHODS
    --------------------------------------*/
}