import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * File:            TenCard.java
 * Author:          Joel De La Torre Cruz
 * Programming:     1st Hour
 * Last Modified:   November 2, 2018
 * Description:     Displays ten cards one from
 * player one and one from player 2. Flips, sorts
 * and shuffles the cards and displays the image
 * on buttons.
 */
public class TenCard extends JFrame implements ActionListener
{
    /* 
     * Frame which is the window with borders,
     * title bar, min/max/exit buttons and panel.
     */
    private static JFrame f;
   
    // panel that will huld the contents (i.e. all the components)
    private JPanel        p;
    
    // declare array of buttons
    private JButton[]     cardButton1;
    private JButton[]     cardButton2;
    
    // declare array of cards
    private Card[]        cardHand1;
    private Card[]        cardHand2;
    
    //buttons
    private JButton       playButton;
    private JButton       sortButton;
    private JButton       flipButton;
    private JButton       shuffleButton;

    //text fields
    private JTextField    text1;
    private JTextField    text2;
    
    //deck for Ten Card
    private Deck          gameDeck;

    /** 
     * constructor that creates or instatiates the frame, panel,
     * layout, etc.
    */
    public TenCard()
    {
        //instantiats a new deck
        gameDeck = new Deck();      
        
        //instantiates teh frame
        f = new JFrame("Ten Card Game");

        // create the content panel to be put in the frame
        p = new JPanel();

        /*
         * Set the layout which will be in a grid 
         * measuring 3 rows x 5 culumns
         */
        GridLayout layout = new GridLayout(3,5);

        // set whichever layout is chosen above
        p.setLayout(layout);

        // call the following methods so that they will
        // create & add each of the buttons & textfields
        // to the content panel
        addButtonsToContentPanel();
        addFieldToContentPanel();

        // finally add the content to the window
        f.setContentPane(p);
    }
    
    /** 
     * this is where we all start
    */
    public static void main(String arg[])
    {
        // this will really do all the work!
        // it declares and creates a new application
        TenCard app = new TenCard();

        /* 
         * Needed at bottom to of main() to be able to close 
         * the application
         */
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // automatically resize window (use instead of setSize)
        f.pack();
        f.setVisible(true);
    } // main()

    /**
    *  create, add, and attach events for the buttons to the 
    *  content panel
    */
    public void addButtonsToContentPanel()
    {         
       //instantiates the 5 buttons for player 1
        cardButton1 = new JButton[5];
       for(int c=0; c<5; c++)
       {
           cardButton1[c] = new JButton("Card player 1 "+c);
           ImageIcon back = new ImageIcon("back.gif");
           cardButton1[c].setIcon(back);
           p.add(cardButton1[c]);
           cardButton1[c].addActionListener(this);          
       }
       
       //instantiates the 5 buttons for player 2 
       cardButton2 = new JButton[5];
       for(int d=0; d<5; d++)
       {
           cardButton2[d] = new JButton("Card player 2 "+d);
           ImageIcon back = new ImageIcon("back.gif");
           cardButton2[d].setIcon(back);  
           p.add(cardButton2[d]);
           cardButton2[d].addActionListener(this);                     
       }
       
       //instantiates buttons
       sortButton        = new JButton("Sort cards");
       flipButton        = new JButton("Flip cards");
       shuffleButton     = new JButton("Shuffle cards");
       playButton        = new JButton("Play");
            
       // add the button to content panel
       p.add(sortButton);
       p.add(shuffleButton);
       p.add(flipButton);
       p.add(playButton);
       
       // listens for click
       sortButton.addActionListener(this);
       shuffleButton.addActionListener(this);
       flipButton.addActionListener(this);
       playButton.addActionListener(this);
    }

    /** 
    * create,add, and attach events for the text fields to the
    * content panel
    */
    public void addFieldToContentPanel()
    {
        // create the textfield & set size to 10
        text1  = new JTextField(10); 
        text2  = new JTextField(10);
        
        // add it to the content
        p.add(text1);                       
        p.add(text2); 
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
           text1.setText("The deck has been shuffled ");
        }
        
        if (e.getSource() == sortButton)
        {
            // sort the game deck 
            gameDeck.sort();
            text1.setText("The deck has ben sorted");
        }
        
         if (e.getSource() == playButton)
        {
            // shows the card value and suit with a card
            // image on the buttons
            cardHand1 = new Card [5];
            for(int a=0; a<5; a++)
            {
                cardHand1[a] = gameDeck.dealACard();
                cardButton1[a].setIcon(cardHand1[a].getFrontImage());
            }
            
            cardHand2 = new Card [5];
            for(int a=0; a<5; a++)
            {
                cardHand2[a] = gameDeck.dealACard();    
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
        }
    }
}



