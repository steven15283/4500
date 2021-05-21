import java.util.ArrayList;
import java.util.List;

public class Card
{
    private int cardValue;
    private int cardId;
    private String cardSuit;
    private String cardName;
    private String cardColor;
    private boolean cardPurchased;

    int getCardValue()
    {
        return cardValue;
    }

    void setCardValue(int value)
    {
        this.cardValue = value;
    }

    int getCardId()
    {
        return cardId;
    }

    void setCardId(int value)
    {
        this.cardId = value;
    }

    String getCardSuit()
    {
        return cardSuit;
    }

    void setCardSuit(String suit)
    {
        this.cardSuit = suit;
    }

    String getCardName() {
        return cardName;
    }

    void setCardName(String name) {
        this.cardName = name;
    }

    String getCardColor() {
        return cardColor;
    }

    void setCardColor(String color) {
        this.cardColor = color;
    }

    boolean getCardPurchased() {
        return cardPurchased;
    }

    void setCardPurchased(boolean purchased) {
        this.cardPurchased = purchased;
    }
    
    @Override
    public String toString()
    {
        return((getCardName())+(getCardSuit())+getCardColor()+getCardValue()+ " Id:" + getCardId());
    }
}

class Two extends Card
{
    Two(String cardSuit,String cardColor, int id)
    {
        setCardValue(2);
        setCardId(id);
        setCardSuit(cardSuit);
        setCardColor(cardColor);
        setCardName("2");
        setCardPurchased(false);
    }
}
class Three extends Card
{
    Three(String cardSuit,String cardColor, int id)
    {
        setCardValue(3);
        setCardId(id);
        setCardSuit(cardSuit);
        setCardColor(cardColor);
        setCardName("3");
        setCardPurchased(false);
    }
}
class Four extends Card
{
    Four(String cardSuit,String cardColor, int id)
    {
        setCardValue(4);
        setCardId(id);
        setCardSuit(cardSuit);
        setCardColor(cardColor);
        setCardName("4");
        setCardPurchased(false);
    }
}
class Five extends Card
{
    Five(String cardSuit,String cardColor, int id)
    {
        setCardValue(5);
        setCardId(id);
        setCardSuit(cardSuit);
        setCardColor(cardColor);
        setCardName("5");
        setCardPurchased(false);
    }
}
class Six extends Card
{
    Six(String cardSuit,String cardColor, int id)
    {
        setCardValue(6);
        setCardId(id);
        setCardSuit(cardSuit);
        setCardColor(cardColor);
        setCardName("6");
        setCardPurchased(false);
    }
}
class Seven extends Card
{
    Seven(String cardSuit,String cardColor, int id)
    {
        setCardValue(7);
        setCardId(id);
        setCardSuit(cardSuit);
        setCardColor(cardColor);
        setCardName("7");
        setCardPurchased(false);
    }
}
class Eight extends Card
{
    Eight(String cardSuit,String cardColor, int id)
    {
        setCardValue(8);
        setCardId(id);
        setCardSuit(cardSuit);
        setCardColor(cardColor);
        setCardName("8");
        setCardPurchased(false);
    }
}
class Nine extends Card
{
    Nine(String cardSuit,String cardColor, int id)
    {
        setCardValue(9);
        setCardId(id);
        setCardSuit(cardSuit);
        setCardColor(cardColor);
        setCardName("9");
        setCardPurchased(false);
    }
}
class Ten extends Card
{
    Ten(String cardSuit,String cardColor, int id)
    {
        setCardValue(10);
        setCardId(id);
        setCardSuit(cardSuit);
        setCardColor(cardColor);
        setCardName("10");
        setCardPurchased(false);
    }
}
class Jack extends Card
{
    Jack(String cardSuit,String cardColor, int id)
    {
        setCardValue(11);
        setCardId(id);
        setCardSuit(cardSuit);
        setCardColor(cardColor);
        setCardName("J");
        setCardPurchased(false);
    }
}
class Queen extends Card
{
    Queen(String cardSuit,String cardColor, int id)
    {
        setCardValue(12);
        setCardId(id);
        setCardSuit(cardSuit);
        setCardColor(cardColor);
        setCardName("Q");
        setCardPurchased(false);
    }
}
class King extends Card
{
    King(String cardSuit,String cardColor, int id)
    {
        setCardValue(13);
        setCardId(id);
        setCardSuit(cardSuit);
        setCardColor(cardColor);
        setCardName("K");
        setCardPurchased(false);
    }
}
class Ace extends Card
{
    Ace(String cardSuit,String cardColor, int id)
    {
        setCardValue(14);
        setCardId(id);
        setCardSuit(cardSuit);
        setCardColor(cardColor);
        setCardName("A");
        setCardPurchased(false);
    }
}

class Deck
{
    static List<Card> CreateDeck()
    {
        List<Card> deck1 = new ArrayList<>();
        int id = 0;

        for(int i=0;i<4;i++)
        {
            String suit = null;
            String color = null;

            switch (i)
            {
                case 0:
                    color = "Red";
		            suit = "Heart";
                    break;
                case 1:
                    color = "Red";
		        	suit = "Diamond";
                    break;
                case 2:
                    color = "Black";
		        	suit = "Club";
                    break;
                case 3:
                    color = "Black";
		        	suit = "Spade";
                    break;
            }

            deck1.add(new Two(suit,color,id));
            id++;
            deck1.add(new Three(suit,color,id));
            id++;
            deck1.add(new Four(suit,color,id));
            id++;
            deck1.add(new Five(suit,color,id));
            id++;
            deck1.add(new Six(suit,color,id));
            id++;
            deck1.add(new Seven(suit,color,id));
            id++;
            deck1.add(new Eight(suit,color,id));
            id++;
            deck1.add(new Nine(suit,color,id));
            id++;
            deck1.add(new Ten(suit,color,id));
            id++;
            deck1.add(new Jack(suit,color,id));
            id++;
            deck1.add(new Queen(suit,color,id));
            id++;
            deck1.add(new King(suit,color,id));
            id++;
            deck1.add(new Ace(suit,color,id));
            id++;
        }

        return deck1;
    }
}

class GameDeck extends Deck
{
    static List<Card> CreateGameDeck()
    {
        List<Card> gameDeck;
        gameDeck = CreateDeck();

        return gameDeck;
    }

    static int getCardValue(Object o)
    {
        return ((Card) o).getCardValue();
    }
    static int getCardId(Object o)
    {
        return ((Card) o).getCardId();
    }
    static String getCardSuit(Object o)
    {
        return ((Card) o).getCardSuit();
    }
    static String getCardName(Object o)
    {
        return ((Card) o).getCardName();
    }
    static String getCardColor(Object o)
    {
        return ((Card) o).getCardColor();
    }
}
