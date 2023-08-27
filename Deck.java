
/**
 * Description: This class will construct a standard deck of cards.
 * 
 * author:      Daniel Searcy 
 * version:     9-28-18
 */
public class Deck
{
    private int x;
    private Card[]  myDeck; //tells the computer an array will be used
    private int numberDealt;
    
    /*private Card twoOfClubs;
    private Card threeOfClubs;
    private Card fourOfClubs;
    private Card fiveOfClubs;
    private Card sixOfClubs;
    private Card sevenOfClubs;
    private Card eightOfClubs;
    private Card nineOfClubs;
    private Card tenOfClubs;
    private Card jackOfClubs;
    private Card queenOfClubs;
    private Card kingOfClubs;
    private Card aceOfClubs;*/
    
    /**
     * Constructor for objects of class Deck
     * This method creates Card objects for the Deck to use
     */
    public Deck()
    {
      //creates an array of 52 blank card objects
      myDeck      = new Card[52]; 
      numberDealt = 0;
      for(int i = 0; i < 52; i++) //sets the value of i 52 times
      {
          myDeck[i] = new Card(i); //creates a card with a value i
      }
      /*twoOfClubs      = new Card(0);
      threeOfClubs    = new Card(1);
      fourOfClubs     = new Card(2);
      fiveOfClubs     = new Card(3);
      sixOfClubs      = new Card(4);
      sevenOfClubs    = new Card(5);
      eightOfClubs    = new Card(6);
      nineOfClubs     = new Card(7);
      tenOfClubs      = new Card(8);
      jackOfClubs     = new Card(9);
      queenOfClubs    = new Card(10);
      kingOfClubs     = new Card(11);
      aceOfClubs      = new Card(12);*/
      
     /* System.out.println(twoOfClubs.toString());
      System.out.println(threeOfClubs.toString());
      System.out.println(fourOfClubs.toString());
      System.out.println(fiveOfClubs.toString());
      System.out.println(sixOfClubs.toString());
      System.out.println(sevenOfClubs.toString());
      System.out.println(eightOfClubs.toString());
      System.out.println(nineOfClubs.toString());
      System.out.println(tenOfClubs.toString());
      System.out.println(jackOfClubs.toString());
      System.out.println(queenOfClubs.toString());
      System.out.println(kingOfClubs.toString());
      System.out.println(aceOfClubs.toString());*/
    }
    
    /**
     * This method shuffles the deck of cards
     */
    public void shuffle()
    { 
        // shuffles 52 cards 14 times
        for(int k=0; k<728; k++)
        {
            // makes a random integer from 1 - 51
            int s1     = (int)((Math.random()*52)); 
            int s2     = (int)((Math.random()*52));
            //swaps two cards
            Card temp  = myDeck[s1];
            myDeck[s1] = myDeck[s2];
            myDeck[s2] = temp;
        }
    }
    
    /**
     * This method deals a card from the deck
     */
    public Card dealACard()
    {
        // if the cards dealt goes over the last card then it starts over
        if (numberDealt > 51)
        {
            numberDealt = 0;
            shuffle();
        }
        /* 
         * Makes a temporary card and assigns it to the number dealt
         * in the deck
         */
        Card temp = myDeck[numberDealt];
        numberDealt++; // adds one to the numberDealt
        return temp;
    }
    
    /**
     * This method puts the deck back in the correct order
     */
    public void sort()
    {
        for(int x = 0; x < 52; x++)
        {
            for(int leftIndex = 0; leftIndex < 51; leftIndex ++)
            {
                int rightIndex = leftIndex + 1;
                Card c1        = myDeck[leftIndex];
                Card c2        = myDeck[rightIndex];
                if(c1.getRank() > c2.getRank())
                {
                    Card temp          = myDeck[leftIndex];
                    myDeck[leftIndex]  = myDeck[rightIndex];
                    myDeck[rightIndex] = temp;
                }
            }
    
        }
    }
}
