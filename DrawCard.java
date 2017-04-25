/**
 * This class creates a card component that can be added to a JPanel. The constructor receives a
 * Card object as a parameter and obtains suit and value information from it.
 * 
 * @author Paul Traxler
 * @version 1.0
 * @date 4/24/17
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class DrawCard extends JComponent {

private String value;
private String suit;

//Constructor to initialize value and suit
public DrawCard(Card card){
	this.value = card.getValue();
	this.suit = card.getSuit();
}

// Paints the component on the screen
@Override
protected void paintComponent(Graphics g) {
	int placement;
	// Places the text dynamically based on the amount of letters, otherwise
	// the suit label would be off center for all of them
	switch(suit.length()){
		case 5: 
			placement = 18;
			break;
		case 6:
			placement = 15;
			break;
		case 8:
			placement = 5;
			break;
		default:
			placement = 10;
			break;
	}
	super.paintComponent(g);   
    g.drawRect(0, 0, 70,100);  
    
    // Tell them what it is
    g.drawString(value, 30, 30);
    g.drawString("of", 28, 50);
    g.drawString(suit, placement, 70);
}

//Need these for the Layout to be right.
@Override
public Dimension getPreferredSize() {
	return new Dimension(70, 100);
  }

@Override 
public Dimension getMinimumSize(){
	return new Dimension(70,100);
}
}