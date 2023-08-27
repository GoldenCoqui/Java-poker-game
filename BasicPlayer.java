import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * File:            BasicPlayer.java
 * Author:          Joel De La Torre Cruz
 * Programming:     1st Hour
 * Last Modified:   November 13, 2018
 * Description:     Makes a player with a 
 * hand of cards that can be dealt a card
 * and the cards can be taken away. It will
 * also sort the hand by suit, rank, value.
 */
public class BasicPlayer
{
    // card array for the players hand
    private Card[]  cardHand;
    
    //players name is player 1
    private String  name;
    
    // tells number of cards in the array (or hand)
    private int    numberCardsInHand;
   
    /**
     * Constructor for objects of class BasicPlayer
     */
    public BasicPlayer()
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
        /*
        // decreases the number in hand everytime you
        // take a card away
        numberCardsInHand--;
        
        // returns the card that is taken from the hand
        return cardHand[numberCardsInHand];*/
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
}
