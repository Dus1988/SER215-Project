/**
 *  This is the first version of the GUI for the SER 215 Blackjack game, group 12. 
 *  There is no input validation yet. This is just a user interface with no guts to it as of yet.
 *  All buttons do function except the Hit and stand button, and there are no cards yet. 
 *  
 *  @author Paul Traxler
 *  @version 1.0
 *  @date 4/17/2017
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Blackjack extends JFrame{
	// Initialize all the components
	private JLabel StartGameText = new JLabel("Blackjack");
	private JLabel Text2 = new JLabel("Please enter starting cash: ");
	private JLabel dealerText = new JLabel("Dealer");
	private JLabel playerText = new JLabel("Player");
	private JLabel TotalCash = new JLabel("Cash: ");
	private JLabel TotalBet = new JLabel("Bet: ");
	private JLabel betPlaceText = new JLabel("Place your bet:  ");
	
	private JButton startGame = new JButton("Start");
	private JButton leaveGame = new JButton("Quit");
	private JButton hit = new JButton("Hit");
	private JButton stand = new JButton("Stand");
	private JButton leave = new JButton("Leave Table");
	private JButton PlaceBetButton = new JButton("Place Bet");
	private JButton WalkAway = new JButton("Walk Away");
	
	private JTextField startingCash = new JTextField("");
	private JTextField betPlacer = new JTextField("");
	
	private JPanel CashPrompt = new JPanel();
	private JPanel StartGamePanel = new JPanel();
	private JPanel Buttons = new JPanel();
	private JPanel MainHeader = new JPanel();
	private JPanel cashTab = new JPanel();
	private JPanel BetPanel = new JPanel();
	private JPanel BetPanelButtons = new JPanel();
	private JPanel GamePanel = new JPanel();
	private JPanel DealerCardPanel = new JPanel();
	private JPanel PlayerCardPanel = new JPanel();
	private JPanel PlayerTextPanel = new JPanel();
	private JPanel MainButtonPanel = new JPanel();
	
	private JDialog BetFrame = new JDialog();
	
	private static JFrame frame = new Blackjack();
	
	public Blackjack(){
		// Initialize all our panels
		
		///////////////////  START GAME PANEL //////////////////////////
		
		// Setting the font and alignment for the Blackjack text on the start screen. 
		StartGameText.setFont(new Font("Serif", Font.BOLD, 18));
		StartGameText.setAlignmentX(Component.CENTER_ALIGNMENT);
		StartGameText.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		// Setting the Layout of the StartGamePanel 
		StartGamePanel.setLayout(new BoxLayout(StartGamePanel, BoxLayout.Y_AXIS));

		// Set up the prompt for starting cash
		CashPrompt.add(Text2);
		Text2.setAlignmentX(Component.CENTER_ALIGNMENT);
		CashPrompt.add(startingCash);
		startingCash.setPreferredSize(new Dimension(100,25));
		CashPrompt.setBorder(BorderFactory.createEmptyBorder(25,10,10,10));
		
		// Add the start and quit buttons
		Buttons.add(startGame);
		Buttons.add(leaveGame);
		
		// Add the pieces to the panel
		StartGamePanel.add(StartGameText, BorderLayout.NORTH);
		StartGamePanel.add(CashPrompt, BorderLayout.CENTER);
		StartGamePanel.add(Buttons, BorderLayout.SOUTH);
		this.add(StartGamePanel);

		////////////////////////// BET PANEL SETUP ///////////////////////////
		
		// Sets up the Bet Panel, shown when before every had to collect bets
		BetPanel.add(betPlaceText); 
		BetPanel.add(betPlacer);
		betPlacer.setPreferredSize(new Dimension(100,25));
		
		// Add Bet Panel Buttons
		BetPanelButtons.add(PlaceBetButton);
		BetPanelButtons.add(WalkAway);
		
		// Add the pieces to the frame.
		BetFrame.add(BetPanel);
		BetFrame.add(BetPanelButtons, BorderLayout.PAGE_END);
    	BetFrame.setResizable(false);
    	BetFrame.setSize(250,100);
    	BetFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		////////////////////////// MAIN GAME PANEL //////////////////////////
		
		// GamePanel is the container for the main game
		GamePanel.setLayout(new BoxLayout(GamePanel, BoxLayout.Y_AXIS));
		
		// The Main Header has the dealer label and the Cash/Bet tab
	    MainHeader.setLayout(new BoxLayout(MainHeader, BoxLayout.X_AXIS));
	    MainHeader.add(dealerText, Component.CENTER_ALIGNMENT);
	    MainHeader.add(Box.createHorizontalGlue());
	    MainHeader.add(cashTab, Component.RIGHT_ALIGNMENT);
	    
	    // Dealer label setup
	    dealerText.setFont(new Font("Serif", Font.BOLD, 16));
	    dealerText.setBorder(BorderFactory.createEmptyBorder(10, 200, 10, 20));
	    
	    // Cash tab as the total cash and total bet for the hand
	    cashTab.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
	    cashTab.setLayout(new BoxLayout(cashTab, BoxLayout.Y_AXIS));
	    cashTab.add(TotalCash);
	    cashTab.add(TotalBet);
	    
	    // Dealer Card panel right now is just a placeholder. Cards will go here
		DealerCardPanel.add(new JLabel("Dealer Cards will go here"));
		DealerCardPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		// See Dealer Card Panel description
		PlayerCardPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		PlayerCardPanel.add(new JLabel("Player Cards will go here"));
		
		// Player text panel just has the Player label
		PlayerTextPanel.add(playerText);
		playerText.setFont(new Font("Serif", Font.BOLD, 16));
		
		// Main Button Panel has the Hit, Stand, and Leave table buttons for the game panel
		MainButtonPanel.add(hit);
		MainButtonPanel.add(stand);
		MainButtonPanel.add(leave);
		
		// Main Game panel combines everything together.
    	GamePanel.add(MainHeader, BorderLayout.NORTH);
    	GamePanel.add(DealerCardPanel);
    	GamePanel.add(Box.createRigidArea(new Dimension(25, 25)));
    	GamePanel.add(PlayerCardPanel);
    	GamePanel.add(PlayerTextPanel);
    	GamePanel.add(MainButtonPanel,BorderLayout.PAGE_END);
		
    	//////////////////////// ACTION LISTENERS /////////////////////////////
    	
    	// Listener for when the start button on the start screen is pressed
	    startGame.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	// Set the Cash value entered by user
	        	TotalCash.setText("Cash: " + startingCash.getText());
	        	
	        	// Hide the start panel and resize the frame
	        	StartGamePanel.setVisible(false);
	        	frame.setSize(450,350);
	        	
	        	// Show the Bet dialog
	        	BetFrame.setLocationRelativeTo(frame);
	        	BetFrame.setVisible(true);
	        	
	        	// Add the Main Game panel to the frame
	        	frame.add(GamePanel);
	        	GamePanel.setVisible(true);
	        }
	      });
	    
	    // Listener for the leave game button on the start screen
	    leaveGame.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          frame.dispose(); // closes the game
	        }
	      });
	    
	    // Listener for the walk away button on the bet screen
	    WalkAway.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	
	          // Get rid of the bet screen and show the start screen
	        	BetFrame.dispose();
	        	frame.setSize(300,200);
	        	StartGamePanel.setVisible(true);
	        }
	      });
	    
	    // Listener for the Place Bet button on the bet screen
	    PlaceBetButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          // Get rid of the bet screen and update the Bet text on main screen
	          BetFrame.dispose();
	          TotalBet.setText("Bet: " + betPlacer.getText());
	        }
	      });
	    
	    // Listener stub for Hit button
	    hit.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	//TODO: Implement hit button
	        }
	      });
	    
	   // Listener stub for stand button
	   stand.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	//TODO: Implement stand button
	        }
	      });
	   
	   // Listener stub for leave table button on game screen
	   leave.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            // Get rid of the game screen and show the start screen
	        	GamePanel.setVisible(false);
	        	frame.setSize(300,200);
	        	StartGamePanel.setVisible(true);
	        }
	      });
	    
	}

	
	// Main method to set it all in motion
	public static void main(String[] args){
		// Set the title, location, size, and close operation.
		frame.setTitle("Blackjack");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setVisible(true);
	}
}
