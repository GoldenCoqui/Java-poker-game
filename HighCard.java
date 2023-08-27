import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * File:            HighCard.java
 * Author:          Joel De La Torre Cruz
 * Programming:     1st Hour
 * Last Modified:   October 2018
 * 
 * Description: Two cards are drawn and the one with the higher value 
 * wins. This program will create a High Card game.
 */

public class HighCard extends JFrame implements ActionListener
{
    /* 
     * Frame which is the window with borders, title bar, min/max/exit 
     * buttons and panel.
     */
    private static JFrame f;

    // panel that will huld the contents (i.e. all the components)
    private        JPanel p;

    /*****************************  These are all components */
    // buttons
    private JButton     cardButton1;
    private JButton     cardButton2;
    private JButton     playButton;

    // text field
    private JTextField  text1;
    private JTextField  text2;
    private JTextField  winnerText;
    
    // creates card and deck objects
    private Deck        gameDeck;
    private Card        cardOnTable1;
    private Card        cardOnTable2;
    /*****************************  Ending the components */

    /** 
     * this is where we all start
    */
    public static void main(String arg[])
    {
        // this will really do all the work!
        // it declares and creates a new application
        HighCard app = new HighCard();

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
     * constructor that creates or instatiates the frame, panel,
     * layout, etc.
    */
    public HighCard()
    {
        gameDeck     = new Deck();
        cardOnTable1 = new Card();
        cardOnTable1 = new Card();
        gameDeck.shuffle();
        // Create the overall window for the application
        f = new JFrame("High Card Game");

        // create the content panel to be put in the frame
        p = new JPanel();

        /*
         * Set the layout which will be in a grid measuring 
         * 3 rows x 2 culumns
         */
        GridLayout layout = new GridLayout(2,3);

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
    *  create, add, and attach events for the buttons to the 
    *  content panel
    */
    public void addButtonsToContentPanel()
    {
        // create a fancy button with pictures
        ImageIcon back    = new ImageIcon("yugioh.gif");
        
        // crate buttons for the game
        cardButton1       = new JButton("First Card", back);
        cardButton2       = new JButton("Second Card", back);
        playButton        = new JButton("Press me to play!");
        
        // add the button to the content pane then listen for clicks
        p.add(cardButton1);
        p.add(cardButton2);
        p.add(playButton);
        playButton.addActionListener(this);
    }

    /** 
    * create,add, and attach events for the text fields to the
    * content panel
    */
    public void addFieldToContentPanel()
    {
        // create the textfield & set size to 10
        text1           = new JTextField(10); 
        text2           = new JTextField(10);
        winnerText      = new JTextField(10);
        // add it to the content
        p.add(text1);                       
        p.add(text2); 
        p.add(winnerText); 
    }

    /** 
    * handle the actions were taken in the application window
    */
    public void actionPerformed(ActionEvent e)
    {
        // if button was pressed change the text field
        if (e.getSource() == playButton)
        {
            // deals 2 cards
            cardOnTable1 = gameDeck.dealACard();
            cardOnTable2 = gameDeck.dealACard();
            // displays a card on the string
            cardButton1.setIcon(cardOnTable1.getFrontImage());
            cardButton2.setIcon(cardOnTable2.getFrontImage());
            // Tells the player what card they see
            text1.setText(cardOnTable1.toString());
            text2.setText(cardOnTable2.toString());
            
            // Determines and tells the winner
            if(cardOnTable1.getValue() > cardOnTable2.getValue())
            {
                winnerText.setText("Card 1 wins!");
            }

            else
            {
                if(cardOnTable1.getValue() == cardOnTable2.getValue())
                {
                    winnerText.setText("Draw!");
                }
                else
                {
                    winnerText.setText("Card 2 wins!");
                }
            }    
        }
        repaint();
    }

} // HighCard
