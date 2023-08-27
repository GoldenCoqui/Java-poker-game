import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * File:            PokerPlayer.java
 * Author:          Joel De La Torre Cruz
 * Programming:     1st Hour
 * Last Modified:   December 2, 2018
 * Description:     Makes a player with a 
 * hand of cards that can be dealt a card
 * and the cards can be taken away. It will
 * also sort the hand by suit, rank, value.
 */
public class PokerPlayer
{
    // card array for the players hand
    private Card[]  cardHand;
    
    //players name is player 1
    private String  name;
    
    // tells number of cards in the array (or hand)
    private int    numberCardsInHand;
   
    /**
     * Constructor for objects of class PokerPlayer
     */
    public PokerPlayer()
    {
        name = "Player 1";
        
        numberCardsInHand = 0;
        
        // instantiates 5 slots in an array
        cardHand = new Card[5];
    }
         
    /**
     * sets a card in the players hand
     */
    public void setACardInHand(Card c)
    { 
        if(numberCardsInHand < 5)
        {
            // sets the cardHand array a card object
            cardHand[numberCardsInHand] = c;
            
            //increases the numberCardsInHand by one 
            //everytime you add a card in the hand
            numberCardsInHand++;
        }
    }
    
    /**
     * gets a card from the player hands
     */
    public Card getACardInHand()
    {
        if( numberCardsInHand > 0 && numberCardsInHand <= 5)
        {
            numberCardsInHand--;
        }
        Card temp = cardHand[numberCardsInHand];
        cardHand[numberCardsInHand] = null;
        return temp;
    }
    
    /**
     * returns the players name
     */
    public String getName()
    {
        return name;
    }

    /**
     * sorts the cards by value
     */
    public void sortByValue()
    {
        for(int x = 0; x < 5; x++)
        {
            for(int leftIndex = 0; leftIndex < 4; leftIndex ++)
            {
                int rightIndex = leftIndex + 1;
                Card c1        = cardHand[leftIndex];
                Card c2        = cardHand[rightIndex];
                if(c1.getValue() > c2.getValue())
                {
                    Card temp            = cardHand[leftIndex];
                    cardHand[leftIndex]  = cardHand[rightIndex];
                    cardHand[rightIndex] = temp;
                }
            }
        }
    }
    
    /**
     * sorts the cards by suit
     */
    public void sortBySuit()
    {
       for(int x = 0; x < 5; x++)
        {
            for(int leftIndex = 0; leftIndex < 4; leftIndex ++)
            {
                int rightIndex = leftIndex + 1;
                Card c1        = cardHand[leftIndex];
                Card c2        = cardHand[rightIndex];
                if(c1.getSuit() > c2.getSuit())
                {
                    Card temp            = cardHand[leftIndex];
                    cardHand[leftIndex]  = cardHand[rightIndex];
                    cardHand[rightIndex] = temp;
                }
            }
        }
    }
    
    /**
     * sorts the cards by rank
     */
    public void sortByRank()
    {
        for(int x = 0; x < 5; x++)
        {
            for(int leftIndex = 0; leftIndex < 4; leftIndex ++)
            {
                int rightIndex = leftIndex + 1;
                Card c1        = cardHand[leftIndex];
                Card c2        = cardHand[rightIndex];
                if(c1.getRank() > c2.getRank())
                {
                    Card temp            = cardHand[leftIndex];
                    cardHand[leftIndex]  = cardHand[rightIndex];
                    cardHand[rightIndex] = temp;
                }
            }
        }
    }
    
    /**
     * Looks at the players hand and says 
     * if it is a Royal Flush
     */
    private boolean royalFlush()
    {
        sortByValue();
        if(cardHand[0].getValue() == 10 &&
           cardHand[0].getValue()+1 == cardHand[1].getValue() &&
           cardHand[1].getValue()+1 == cardHand[2].getValue() &&
           cardHand[2].getValue()+1 == cardHand[3].getValue() &&
           cardHand[3].getValue()+1 == cardHand[4].getValue() &&
           cardHand[0].getSuit() == cardHand[1].getSuit() &&
           cardHand[1].getSuit() == cardHand[2].getSuit() &&
           cardHand[2].getSuit() == cardHand[3].getSuit() &&
           cardHand[3].getSuit() == cardHand[4].getSuit())
        {
            return true;
        }
        return false;
    }    
    
    /**
     * Looks at the players hand and says 
     * if it is a Four of a Kind
     */
    private boolean fourOfKind()
    {
        sortByValue();
        if(cardHand[0].getValue() == cardHand[1].getValue() &&
           cardHand[1].getValue() == cardHand[2].getValue() &&
           cardHand[2].getValue() == cardHand[3].getValue())
        {
            return true;
        }
        if(cardHand[1].getValue() == cardHand[2].getValue() &&
           cardHand[2].getValue() == cardHand[3].getValue() &&
           cardHand[3].getValue() == cardHand[4].getValue())
        {
            return true;
        }
        return false;
    }
    
    /**
     * Looks at the players hand and says 
     * if it is a Straight Flush
     */
    private boolean straightFlush()
    {
        sortByValue();
        if(cardHand[0].getValue()+1 == cardHand[1].getValue() &&
           cardHand[1].getValue()+1 == cardHand[2].getValue() &&
           cardHand[2].getValue()+1 == cardHand[3].getValue() &&
           cardHand[3].getValue()+1 == cardHand[4].getValue() &&
           cardHand[0].getSuit() == cardHand[1].getSuit() &&
           cardHand[1].getSuit() == cardHand[2].getSuit() &&
           cardHand[2].getSuit() == cardHand[3].getSuit() &&
           cardHand[3].getSuit() == cardHand[4].getSuit())
        {
           return true;
        }           
        return false;
    }
    
    /**
     * Looks at the players hand and says 
     * if it is a Full House
     */
    private boolean fullHouse()
    {
        sortByValue();
        if((cardHand[0].getValue() == cardHand[1].getValue()) && 
           (cardHand[2].getValue() == cardHand[4].getValue()))
        {
               return true;
        }
        if((cardHand[0].getValue() == cardHand[2].getValue()) && 
           (cardHand[3].getValue() == cardHand[4].getValue()))  
        {
            return true;
        }
        return false;
    }
    
    /**
     * Looks at the players hand and says 
     * if it is a Flush
     */
    private boolean flush()
    {
        sortBySuit();
        if(cardHand[0].getSuit() == cardHand[1].getSuit() &&
           cardHand[1].getSuit() == cardHand[2].getSuit() &&
           cardHand[2].getSuit() == cardHand[3].getSuit() &&
           cardHand[3].getSuit() == cardHand[4].getSuit())
        {
            return true;
        }
        return false;
    }
    
    /**
     * Looks at the players hand and says 
     * if it is a Straight
     */
    private boolean straight()
    {
        sortByValue();
        if(cardHand[0].getValue()+1 == cardHand[1].getValue() &&
           cardHand[1].getValue()+1 == cardHand[2].getValue() &&
           cardHand[2].getValue()+1 == cardHand[3].getValue() &&
           cardHand[3].getValue()+1 == cardHand[4].getValue())
        {
            return true;
        }
          return false;
    }
    
    /**
     * Looks at the players hand and says 
     * if it is a Three of a Kind
     */
    private boolean threeOfKind()
    {
        sortByValue();
        if(cardHand[0].getValue() == cardHand[1].getValue() &&
           cardHand[0].getValue() == cardHand[2].getValue())
        {
            return true;
        }
        if(cardHand[1].getValue() == cardHand[1].getValue() &&
           cardHand[1].getValue() == cardHand[3].getValue())
        {
            return true;
        }
        if(cardHand[2].getValue() == cardHand[3].getValue() &&
           cardHand[2].getValue() == cardHand[4].getValue())
        {
            return true;
        }
        return false;
    }
    
    /**
     * Looks at the players hand and says 
     * if it is a Two of a Pair
     */
    private boolean twoPair()
    {
        sortByValue();
        if(cardHand[0].getValue() == cardHand[1].getValue() &&
           cardHand[2].getValue() == cardHand[3].getValue())
        {
           return true;
        }        
        if(cardHand[0].getValue() == cardHand[1].getValue() &&
           cardHand[3].getValue() == cardHand[4].getValue())
        {
           return true;
        }
        if(cardHand[1].getValue() == cardHand[2].getValue() &&
           cardHand[3].getValue() == cardHand[4].getValue())
        {
           return true;
        }        
        return false;
    }
    
    /**
     * Looks at the players hand and says 
     * if it is a Pair
     */
    private boolean pair()
    {
        sortByValue();
        if(cardHand[0].getValue() == cardHand[1].getValue() || 
           cardHand[1].getValue() == cardHand[2].getValue() ||  
           cardHand[2].getValue() == cardHand[3].getValue() || 
           cardHand[3].getValue() == cardHand[4].getValue())
        {
            return true;
        }
        return false;
    }

    /**
     * Looks at the players hand and says 
     * if it is a High Card
     */
    public boolean highCard()
    {
        sortByValue();
        if(cardHand[4].getValue() > cardHand[3].getValue() && 
           cardHand[4].getValue() > cardHand[2].getValue() && 
           cardHand[4].getValue() > cardHand[1].getValue() && 
           cardHand[4].getValue() > cardHand[0].getValue())
        {
            return true;
        }
        return false;
    }
    
    /**
     * It will tell the user what type of hand they have
     */
    public String getHandType()
    {
        if(royalFlush() == true)
        {
            return "You have a Royal Flush";
        }
        if(fourOfKind() == true)
        {
            return "You have a Four of a Kind";
        }
        if(straightFlush() == true)
        {
            return "You have a Straight Flush";
        }
        if(fullHouse() == true)
        {
            return "You have a Full House";
        }
        if(flush() == true)
        {
            return "You have a Flush";
        }
        if(straight() == true)
        {
            return "You have a Straight";
        }
        if(threeOfKind() == true)
        {
            return "You have a Three of a Kind";
        }
        if(twoPair() == true)
        {
            return "You have a Two Pairs";
        }
         if(pair() == true)
        {
            return "You have a Pair";
        }
        if(highCard() == true)
        {
            return "You have a High Card";
        }
        return "Nothing";
    }
}