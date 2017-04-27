/**
 *  This is the Third version of the GUI for the SER 215 Blackjack game, group 12. Should be complete.
 *  
 *  @author Paul Traxler, Michael Essary
 *  @version 3.0
 *  @date 4/27/2017
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Blackjack extends JFrame{
	// Initialize all the components
	private JLabel StartGameText = new JLabel("Blackjack");
	private JLabel Text2 = new JLabel("Starting cash: ");
	private JLabel namePrompt = new JLabel("Player name: ");
	private JLabel dealerText = new JLabel("Dealer");
	private JLabel playerText = new JLabel("Player");
	private JLabel createPlayer = new JLabel("Create new player:");
	private static JLabel TotalCash = new JLabel("Cash: ");
	private JLabel TotalBet = new JLabel("Bet: ");
	private JLabel betPlaceText = new JLabel("Place your bet:  ");
	private static JLabel winnerText = new JLabel();
	private static JLabel dealerHandValue = new JLabel("Hand Value: 0");
	private static JLabel playerHandValue = new JLabel("Hand Value: 0");
	private static JLabel dealerStatus = new JLabel();
	
	private JButton startGame = new JButton("Start");
	private JButton leaveGame = new JButton("Quit");
	private static JButton hit = new JButton("Hit");
	private static JButton stand = new JButton("Stand");
	private static  JButton leave = new JButton("Leave Table");
	private JButton PlaceBetButton = new JButton("Place Bet");
	private JButton WalkAway = new JButton("Walk Away");
	private static JButton NewRound = new JButton("Play Again?");
	private static JButton SaveButton = new JButton("Save Player");
	private JButton LoadButton = new JButton("Load Player");
	
	private static JTextField startingCash = new JTextField("");
	private JTextField betPlacer = new JTextField("");
	private static JTextField playerName = new JTextField("");
	
	private JPanel CashPrompt = new JPanel();
	private JPanel StartGamePanel = new JPanel();
	private JPanel Buttons = new JPanel();
	private JPanel DealerInfo = new JPanel();
	private JPanel MainHeader = new JPanel();
	private JPanel cashTab = new JPanel();
	private JPanel BetPanel = new JPanel();
	private JPanel BetPanelButtons = new JPanel();
	private JPanel GamePanel = new JPanel();
	private static JPanel DealerCardPanel = new JPanel();
	private static JPanel PlayerCardPanel = new JPanel();
	private JPanel PlayerTextPanel = new JPanel();
	private JPanel MainButtonPanel = new JPanel();
	private JPanel WinButtonPanel = new JPanel();
	
	private JDialog BetFrame = new JDialog();
	
	private static JFrame frame = new Blackjack();

	// variables for various places
	private static int bet;
	private static int money = 0;
	private static String directory = System.getProperty("user.dir");
	
	// Create the dealer and player objects
	private static Player player = new Player();
	private static Dealer dealer = new Dealer();
	
	// Constructor 
	public Blackjack(){
		
		// Initialize all our panels
		
		///////////////////  START GAME PANEL //////////////////////////
		
		// Setting the font and alignment for the Blackjack text on the start screen. 
		StartGameText.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 24));
		StartGameText.setAlignmentX(Component.CENTER_ALIGNMENT);
		StartGameText.setBorder(BorderFactory.createEmptyBorder(10,10,25,10));
		
		// Setting the Layout of the StartGamePanel 
		StartGamePanel.setLayout(new BoxLayout(StartGamePanel, BoxLayout.Y_AXIS));

		// Set up the prompt for starting cash
		CashPrompt.add(namePrompt);
		CashPrompt.add(playerName);
		playerName.setPreferredSize(new Dimension(100,25));
		CashPrompt.add(Text2);
		Text2.setAlignmentX(Component.CENTER_ALIGNMENT);
		CashPrompt.add(startingCash);
		startingCash.setPreferredSize(new Dimension(100,25));
		//CashPrompt.setBorder(BorderFactory.createEmptyBorder(25,10,10,10));
		
		// Add the start and quit buttons
		Buttons.add(startGame);
		Buttons.add(leaveGame);
		
		// Add the pieces to the panel
		StartGamePanel.add(StartGameText, BorderLayout.NORTH);
		StartGamePanel.add(LoadButton);
		StartGamePanel.add(createPlayer);
		createPlayer.setAlignmentX(Component.CENTER_ALIGNMENT);
		createPlayer.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		LoadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
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
    	BetFrame.setLocationRelativeTo(null);
    	BetFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		////////////////////////// MAIN GAME PANEL //////////////////////////
		
		// GamePanel is the container for the main game
		GamePanel.setLayout(new BoxLayout(GamePanel, BoxLayout.Y_AXIS));
		
		// Holds the dealer title, card value, and status
		DealerInfo.setLayout(new BoxLayout(DealerInfo, BoxLayout.Y_AXIS));
		DealerInfo.add(dealerText);
		DealerInfo.add(dealerHandValue);
		DealerInfo.add(dealerStatus);
		
		// The Main Header has the dealer label and the Cash/Bet tab
	    MainHeader.setLayout(new BoxLayout(MainHeader, BoxLayout.X_AXIS));
	    MainHeader.add(DealerInfo, GamePanel.getWidth()/2);
	    MainHeader.add(Box.createHorizontalGlue());
	    MainHeader.add(cashTab, Component.RIGHT_ALIGNMENT);
	    
	    // Dealer label setup
	    dealerText.setFont(new Font("Serif", Font.BOLD, 16));
	    dealerText.setBorder(BorderFactory.createEmptyBorder(10, 255, 0, 20));
	    dealerStatus.setBorder(BorderFactory.createEmptyBorder(0, 250, 10, 20));
	    dealerHandValue.setBorder(BorderFactory.createEmptyBorder(0, 230, 0, 20));
	    
	    // Cash tab as the total cash and total bet for the hand
	    cashTab.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
	    cashTab.setLayout(new BoxLayout(cashTab, BoxLayout.Y_AXIS));
	    cashTab.add(TotalCash);
	    cashTab.add(TotalBet);
	    
	    // Dealer Card panel right now is just a placeholder. Cards will go here
	    DealerCardPanel.setPreferredSize(new Dimension(550,120));;
		DealerCardPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		// See Dealer Card Panel description
		PlayerCardPanel.setPreferredSize(new Dimension(550,120));
		PlayerCardPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		// Player text panel just has the Player label
		PlayerTextPanel.setLayout(new BoxLayout(PlayerTextPanel, BoxLayout.Y_AXIS));
		PlayerTextPanel.add(playerText);
		playerText.setAlignmentX(Component.CENTER_ALIGNMENT);
		PlayerTextPanel.add(playerHandValue);
		playerHandValue.setAlignmentX(Component.CENTER_ALIGNMENT);
		playerText.setFont(new Font("Serif", Font.BOLD, 16));
		
		// Main Button Panel has the Hit, Stand, and Leave table buttons for the game panel
		// These buttons are initially disabled until a bet is placed.
		MainButtonPanel.add(hit);
		MainButtonPanel.add(stand);
		MainButtonPanel.add(leave);
    	hit.setEnabled(false);
    	stand.setEnabled(false);
    	leave.setEnabled(false);
		
    	//Winner Text is the label that holds "House wins" or "Player wins"
    	winnerText.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
    	winnerText.setAlignmentX(Container.CENTER_ALIGNMENT);
    	winnerText.setFont(new Font("Serif", Font.BOLD, 18));
    	
    	//Buttons for new round or save after round is over
    	NewRound.setVisible(false);
    	SaveButton.setVisible(false);
    	
    	//For displaying the new round and save button
    	WinButtonPanel.add(NewRound);
    	//WinButtonPanel.add(SaveButton);
    	WinButtonPanel.setAlignmentX(Container.CENTER_ALIGNMENT);
    	
		// Main Game panel combines everything together.
    	GamePanel.add(MainHeader, BorderLayout.NORTH);
    	GamePanel.add(DealerCardPanel);
    	GamePanel.add(winnerText);
    	GamePanel.add(WinButtonPanel);
    	GamePanel.add(PlayerCardPanel);
    	GamePanel.add(PlayerTextPanel);
    	GamePanel.add(MainButtonPanel,BorderLayout.PAGE_END);
		
    	//////////////////////// ACTION LISTENERS /////////////////////////////
    	
    	// Listener for when the start button on the start screen is pressed
	    startGame.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	boolean fault = false;
        		GamePanel.setVisible(false); // had bug where GamePanel would show up too early
        		
        		//Check to see if a valid number was entered or loaded for the starting cash
	        	try{Integer.parseInt(startingCash.getText());}
	        	catch(NumberFormatException a){
	        		JOptionPane.showMessageDialog(frame, "Please enter or load a whole number starting cash value.");
	        		fault = true;
	        	}
	        	//Check to make sure a name was entered
	        	if((!fault) && playerName.getText().isEmpty()){
	        		fault = true;
	        		JOptionPane.showMessageDialog(frame, "Please enter or load player name.");
	        	}
	        	//Call to newRound displays the game screen and starts the round
	        	if(!fault){
	        		player.setMoney(Integer.parseInt(startingCash.getText()));
	        		player.setName(playerName.getText());
	        		dealer.reset();
	        		
	        		savePlayer(player.getMoney(), player.getName());
	        		
	        		newRound();
	        	}
	        }
	      });
	    // Listener for the new round button on the main game screen, displayed after the round is over.
	    NewRound.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	newRound(); // starts new round
	        	savePlayer(player.getMoney(), player.getName());
	        }
	      });
	    // Listener for the leave game button on the start screen
	    leaveGame.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          savePlayer(player.getMoney(), player.getName());
	          frame.dispose(); // closes the game
	        }
	      });
	    
	    // Listener for the walk away button on the bet screen
	    WalkAway.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
            // Get rid of the bet screen and show the start screen
	        	savePlayer(player.getMoney(), player.getName());
	        	BetFrame.dispose();
	        	frame.setSize(280,280);
	        	frame.setLocationRelativeTo(null);
	        	StartGamePanel.setVisible(true);
	        	startingCash.setText("");
	        	playerName.setText("");
	        }
	      });
	    
	    // Listener for the Place Bet button on the bet screen. Validates the bet.
	    PlaceBetButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          boolean betFault = false;
	          
	          try{ // validate the bet
	        	 bet =  Integer.parseInt(betPlacer.getText());
	          }catch(NumberFormatException a){
	        		JOptionPane.showMessageDialog(BetFrame, "Please make a bet.");
	        		betFault = true;
	          }
	          
	          // Check for enough money
	          if(player.getMoney() < bet){
	        	  JOptionPane.showMessageDialog(BetFrame, "Insufficient funds.");
	        	  betFault = true;
	          }
	       
	          // if the bet is good, enable the hit, stand, and enable buttons and get rid of the bet frame. 
	          if(!betFault){
	        	  hit.setEnabled(true);
		    	  stand.setEnabled(true);
		    	  leave.setEnabled(true);
		          BetFrame.dispose();
		          TotalBet.setText("Bet: " + betPlacer.getText());
				  player.hit(Deck.dealCard(player));
				  player.hit(Deck.dealCard(player));
				  playerHandValue.setText("Hand Value: " + player.getTotal());
				  checkWinner();

				  dealer.hit(Deck.dealCard(dealer));
				  dealerHandValue.setText("Hand Value: " + dealer.getTotal());
	          }
	        }
	      });
	    
	    // Listener stub for Hit button. Calls the player hit method and updates the GUI hand value
	    hit.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	player.hit(Deck.dealCard(player));
	        	playerHandValue.setText("Hand Value: " + player.getTotal());
	        	checkWinner();
	        }
	      });
	    
	   // Listener stub for stand button
	   stand.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	player.stand();
	        	checkWinner();
	        }
	      });
	   
	   // Listener stub for leave table button on game screen
	   leave.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            // Get rid of the game screen and show the start screen
	        	frame.setSize(280,280);
	        	frame.setLocationRelativeTo(null);
	        	StartGamePanel.setVisible(true);
	        	GamePanel.setVisible(false);
	        	savePlayer(player.getMoney(), player.getName());
	        }
	      });
	   
	   // Brings up a dialog to load a player
	   LoadButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            // Get rid of the game screen and show the start screen
	        	loadPlayer(JOptionPane.showInputDialog(StartGamePanel, "Load a previously saved player: "));
	        	GamePanel.setVisible(false);
	        }
	      });
	}

	/**
	 * This method creates the card object in it's rightful place, for the dealer or player.
	 * 
	 * @param player Identifier for the dealer or player. 0 = dealer, 1 = player.
	 * @param card The Card object to display.
	 */
	public static void dealCard(int plyr, Card card){
		if(plyr == 0){
			DealerCardPanel.add(new DrawCard(card));
			DealerCardPanel.validate();
			DealerCardPanel.repaint();
		}else if(plyr == 1){
			PlayerCardPanel.add(new DrawCard(card));
			PlayerCardPanel.validate();
			PlayerCardPanel.repaint();
		}
	}
	/**
	 * Sets up a new round. Removes the cards from the dealer and player.
	 */
	public void newRound(){
		
		Deck deck = new Deck();

		//Get rid of the winner text and buttons
		dealerHandValue.setText("Hand Value: 0");
		playerHandValue.setText("Hand Value: 0");
		NewRound.setVisible(false);
		SaveButton.setVisible(false);
		winnerText.setText("");
    	TotalCash.setText("Cash: " + player.getMoney());
		dealerStatus.setText("");
    	
		//Removes the cards from both dealer and player hands
    	DealerCardPanel.removeAll();
    	PlayerCardPanel.removeAll();
    	
    	// Hide the start panel and resize the frame
    	StartGamePanel.setVisible(false);
    	frame.setSize(550,450);
    	frame.setLocationRelativeTo(null);
    	
    	// Show the Bet dialog
    	TotalBet.setText("Bet: ");
    	BetFrame.setVisible(true);
    	
    	// Add the Main Game panel to the frame
    	frame.add(GamePanel);
    	GamePanel.setVisible(true);
    	
    	playerText.setText(playerName.getText());


	}

	/**
	 * Checks for a win condition. If Blackjack is achieved, the player or dealer is bust, declare the other entity a winner.
	 * Declares the winner and allows the user to choose to save the player and start a new game. 
	 * Disables the hit, stand and leave button until a new round is begun.
	 */
	public static void checkWinner(){
		boolean gameOver = false;
		
		TotalCash.setText("Cash: " + Integer.toString(player.getMoney()));
		if(player.isStanding && dealer.isStanding)
			gameOver = true;
		
		if(player.getTotal() == 21 || dealer.getTotal() > 21 || (player.getTotal() > dealer.getTotal()) && gameOver == true){
			winnerText.setText("Player wins!");
			NewRound.setVisible(true);
			SaveButton.setVisible(true);
			
			//Disable buttons
        	hit.setEnabled(false);
        	stand.setEnabled(false);
 	
        	player.setMoney(player.getMoney() + bet);
        	TotalCash.setText("Cash: " + Integer.toString(player.getMoney()));
        	
        	//Clears the player and dealer hand, value, and bust flag
        	player.reset();
        	dealer.reset();
		}
		else if(dealer.getTotal() == 21 || player.isBust() || (dealer.getTotal() > player.getTotal() && gameOver == true)){
			winnerText.setText("House Wins!");
			NewRound.setVisible(true);
			SaveButton.setVisible(true);
			
			//Disable buttons
        	hit.setEnabled(false);
        	stand.setEnabled(false);
        	
        	player.setMoney(player.getMoney() - bet);
        	TotalCash.setText("Cash: " + Integer.toString(player.getMoney()));
        	
        	//Clears the player and dealer hand, value, and bust flag
        	player.reset();
        	dealer.reset();
		}
		else if((dealer.getTotal() == player.getTotal()) && gameOver == true){
			winnerText.setText("Tie!");
			NewRound.setVisible(true);
			SaveButton.setVisible(true);
			
			//Disable buttons
        	hit.setEnabled(false);
        	stand.setEnabled(false);
        	
        	//Clears the player and dealer hand, value, and bust flag
        	player.reset();
        	dealer.reset();
		}else if(!dealer.isStanding){
			dealer.chooseAction();
		}
	}
	/**
	 * Calls the hit method of the dealer and passes them a card.
	 * Also sets the GUI hand value and status 
	 */
	public static void dealToDealer(){
		dealer.hit(Deck.dealCard(dealer));
		
		dealerHandValue.setText("Hand Value: " + dealer.getTotal());
		
		if(dealer.isBust())
			dealerStatus.setText("Bust!");
		else if(dealer.getTotal() >= 17)
			dealerStatus.setText("Standing");

		// So that the dealer finishes if the player stands. 
		if(player.isStanding)
			checkWinner();
	}
	

/**
 * Saves the player
 * @param money The cash the player has
 * @param name The name of the Player
 */
public static void savePlayer(int money, String name){
		File file = new File(directory + File.separator +  "playerdata" + name);

		try {
			if(!file.exists())
				file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		pw.println(money);
		pw.close();

	}

/**
 * Loads a player 
 * @param name The name of the player to load
 */
	public static int loadPlayer(String name){
		File file = new File(directory + File.separator + "playerdata" + name);
		if(file.exists()){
			FileReader fr = null;
			try {
				fr = new FileReader(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			BufferedReader br = new BufferedReader(fr);
			String mon = null;
			try {
				mon = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			player.setName(name);
			playerName.setText(name);
			player.setMoney(Integer.parseInt(mon));
			startingCash.setText(mon);
		}
		else{
			playerName.setText(name);
		}

		return money;
	}
	
	
	
	// MAIN METHOD
	
	public static void main(String[] args){
		// Set the title, location, size, and close operation.
		frame.setTitle("Blackjack");
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(280, 280);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
	}
}
