import javax.swing.*;

/**
 * File:            Card.java
 * Author:          Daniel Searcy
 * Last Modified:   9-26-18
 * Description:     This class will create the foundation for a playing 
 *                  card.
 */

public class Card
{
    private int       rank;  // 0 = 2c, 1 = 3c, 51 = As
    private int       suit;  // 0=club, 1=diamond, 2=heart, 3=spade
    private int       value; // 2 = 2, 3 = 3, J = 11, Q = 12, A = 14
    private ImageIcon frontImage;
    private ImageIcon backImage;
    private boolean   isRed; // checks to see if the card is red

    /**
     * This method can be used as a wild card.
     */
    public Card()
    {
        rank       =  -1;
        suit       =  -1;
        value      =  -1;
        frontImage = null;
        backImage  = null;
        isRed      = false;
    }

    /**
     * This method can make any card in a standard deck.
     */
    public Card(int r)
    {
        this.rank  = r;          
        suit       = r/13;       
        value      = 2 + r % 13;
        frontImage = new ImageIcon(rank+".gif");
        backImage  = new ImageIcon("backV1.png");
        if(suit == 1 || suit == 2)
        {
            isRed = true;
        }
        else
        {
            isRed = false;
        }
    }

    /**
     * These are get and set methods for a card's rank,
     * suit, value, frontImage, backImage, and isRed.
     */
    public int getRank()
    {
        return rank;
    }

    public int getSuit()
    {
        return suit;
    }

    public int getValue()
    {
        return value;
    }

    public ImageIcon getFrontImage()
    {
        return frontImage;
    }

    public void setFrontImage(ImageIcon f)
    {
        frontImage = f;
    }

    public ImageIcon getBackImage()
    {
        return backImage;
    }

    public void setBackImage(ImageIcon b)
    {
        backImage = b;
    }

    public boolean getIsRed()
    {
        return isRed;
    }

    public void setIsRed(boolean i)
    {
        isRed = i;
    }
    
    /**
    * The toString() method returns the English name of the card's value 
    * and suit
    */
    public String toString()
    {
        String temp = "The card is a ";
        if (value == 14) { temp = temp + "Ace of ";}
        if (value == 13) { temp = temp + "King of ";}
        if (value == 12) { temp = temp + "Queen of ";}
        if (value == 11) { temp = temp + "Jack of ";}
        if (value <= 10) { temp = temp + value + " of ";}
        if (suit == 3)   { temp += "spades";}
        if (suit == 2)   { temp += "hearts";}
        if (suit == 1)   { temp += "diamonds";}
        if (suit == 0)   { temp += "clubs";}

        return temp;
    }
}   // end Card class
