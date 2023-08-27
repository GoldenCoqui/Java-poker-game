import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * File:            PokerGame.java
 * Author:          Joel De La Torre Cruz
 * Programming:     1st Hour
 * Last Modified:   November 2, 2018
 * Description:     Displays ten cards one from
 * player one and one from player 2. Flips, sorts
 * and shuffles the cards and displays the image
 * on buttons.
 */
public class PokerGame extends JFrame implements ActionListener
{
    /* 
     * Frame which is the window with borders,
     * title bar, min/max/exit buttons and panel.
     */
    private static JFrame f;
    private static JFrame s;
   
    // panel that will huld the contents (i.e. all the components)
    private JPanel        p;
    private JPanel        b;
    
    // declare array of buttons
    private JButton[]     cardButton1;
    private JButton[]     cardButton2;
    
    // declare array of cards
    private Card[]        cardHand1;
    private Card[]        cardHand2;
    
    //declares buttons
    private JButton       dealButton;
    private JButton       sortButton;
    private JButton       flipButton;
    private JButton       shuffleButton;
    private JButton       playButton;

    //declares textfields
    private JTextField    text1;
    private JTextField    text2;
    private JTextField    text3;
    private JTextField    text4;
    private JTextField    text5;
        
    //deck for the Poker Game
    private Deck          gameDeck;
    
    //Poker Players
    private PokerPlayer   player1;
    private PokerPlayer   player2;
    
    /** 
     * constructor that creates or instatiates the frame, panel,
     * layout, etc.
    */
    public PokerGame()
    {
        //instantiates the 2 poker players
        player1 = new PokerPlayer();
        player2 = new PokerPlayer();
        
        //instantiats a new deck
        gameDeck = new Deck(); 
        
        //shuffles the deck
        gameDeck.shuffle();
        
        //instantiates the frame
        f = new JFrame("Poker Game");
        s = new JFrame("Starting Screen");
        
        // create the content panel to be put in the frame
        p = new JPanel();
        b = new JPanel();
        
        /*
         * Set the layout which will be in a grid 
         * measuring 3 rows x 5 culumns
         */
        GridLayout layout  = new GridLayout(3,6);

        // set whichever layout is chosen above
        p.setLayout(layout);
        

        // call the following methods so that they will
        // create & add each of the buttons & textfields
        // to the content panel
        addToContentPanel();
        
        // finally add the content to the windows
        f.setContentPane(p);
        s.setContentPane(b);        
    }
    
    /** 
     * this is where we all start
    */
    public static void main(String arg[])
    {
        // this will really do all the work!
        // it declares and creates a new application
        PokerGame app = new PokerGame();

        /* 
         * Needed at bottom to of main() to be able to close 
         * the application
         */
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // automatically resize window (use instead of setSize)
        f.pack();
        f.setVisible(false);
        s.pack();
        s.setVisible(true);
    } // main()

    /**
    *  create, add, and attach events for the buttons to the 
    *  content panel
    */
    public void addToContentPanel()
    {         
        //creates the text & sets the size to 10
        text1  = new JTextField(10);
       
        //adds the text fields to the jframe
        p.add(text1); 
       
        // sets the text in the textfield
        text1.setText("Player 1");
       
        //instantiates the 5 buttons for player 1
        cardButton1 = new JButton[5];
        for(int c=0; c<5; c++)
        {
            cardButton1[c] = new JButton();
            ImageIcon back = new ImageIcon("backV1.png");
            cardButton1[c].setIcon(back);
            p.add(cardButton1[c]);
            cardButton1[c].addActionListener(this);
            cardButton1[c].setSize(73,97);
        }
       
        //creates the text & sets the size to 10
        text2  = new JTextField(10);
        
        //adds the text fields to the jframe
        p.add(text2);
        
        // sets the text in the textfield
        text2.setText("Player 2");
       
        //instantiates the 5 buttons for player 2 
        cardButton2 = new JButton[5];
        for(int d=0; d<5; d++)
        {
            cardButton2[d] = new JButton();
            ImageIcon back = new ImageIcon("backV1.png");
            cardButton2[d].setIcon(back);  
            p.add(cardButton2[d]);
            cardButton2[d].addActionListener(this);
        }
       
        //instantiates a textfield       
        text5 = new JTextField(10);
        
        // add textfield 
        p.add(text5);
        
        //instantiates buttons
        flipButton        = new JButton("Flip deck");
        shuffleButton     = new JButton("Shuffle deck");
        dealButton        = new JButton("Deal");
        playButton        = new JButton("Play Poker!");     
                   
        // add the button to content panel
        p.add(shuffleButton);
        p.add(flipButton);
        p.add(dealButton);
        b.add(playButton);
       
        //creates the text & sets the size to 10
        text3 = new JTextField(10);
        text4 = new JTextField(10);
        
        //adds the text fields to the jframe
        p.add(text3);                       
        p.add(text4);
              
        // listens for click
        shuffleButton.addActionListener(this);
        flipButton.addActionListener(this);
        dealButton.addActionListener(this);
        playButton.addActionListener(this);
    }    
    
            
    /** 
    * handle the actions were taken in the application window
    */
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == shuffleButton)
        {
           // shuffle the game deck
           gameDeck.shuffle();
           
           //sets text in a textfield to say its shuffled
           text5.setText("Deck has been shuffled");
        }
        
        if (e.getSource() == dealButton)
        {
            //sets a card in player hand from gameDeck
            for( int a=0; a<5; a++)
            {
                player1.setACardInHand(gameDeck.dealACard());
            }
            
            //sets text in a textfield to say the player1 hand
            text3.setText("Player 1: " +player1.getHandType());
            
            // shows the card value and suit with a card
            // image on the buttons
            cardHand1 = new Card [5];
            for(int a=0; a<5; a++)
            {
                cardHand1[a] = player1.getACardInHand();
                cardButton1[a].setIcon(cardHand1[a].getFrontImage());  
            }
            
            //sets a card in player hand from gameDeck
            for(int a=0; a<5; a++)
            {
                player2.setACardInHand(gameDeck.dealACard());
            }
            
            //sets text in a textfield to say the player2 hand
            text4.setText("Player 2: " +player2.getHandType());
            
            // shows the card value and suit with a card
            // image on the buttons
            cardHand2 = new Card [5];
            for(int a=0; a<5; a++)
            {
                cardHand2[a] = player2.getACardInHand();    
                cardButton2[a].setIcon(cardHand2[a].getFrontImage());
            }
        }
        
        if (e.getSource() == flipButton)
        {
            // changes the card images of the buttons to the back image
            for(int a=0; a<5; a++)
            {
               cardButton1[a].setIcon(cardHand1[a].getBackImage());
            }
            
            for(int a=0; a<5; a++)
            {
                 cardButton2[a].setIcon(cardHand2[a].getBackImage());
            }    
            
            //sets text in textfield to say cards are flipped
            text5.setText("Cards have been flipped");
        }
      
        if (e.getSource() == playButton)
        {
            //sets the starting screen invisible
            s.setVisible(false);
            
            //sets the poker game visible 
            f.setVisible(true);
        }
    }
}
