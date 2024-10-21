import java.util.Random;

enum Suite  {
    HEARTS("Corazones", "♥");

    final String suiteName;
    final String suiteSymbol;

    Suite(String suiteName, String suiteSymbol) {
        this.suiteName = suiteName;
        this.suiteSymbol = suiteSymbol;
    }

    String getSuiteName() {
        return suiteName;
    }

    String getSuiteSymbol() {
        return suiteSymbol;
    }
}

enum Figure {
    TWO("2", 2),
    THREE("3", 3),
    // ...
    JACK("J", 10),
    QUEEN("Q", 10),
    KING("K", 10),
    ACE("A", 11);

    final String figureName;
    final int figureValue;

    Figure(String figureName, int figureValue) {
        this.figureName = figureName;
        this.figureValue = figureValue;
    }

    String getFigureName() {
        return figureName;
    }

    int getFigureValue() {
        return figureValue;
    }
}

class Card {
    final Suite suite;
    final Figure figure;
    boolean isTaken = false;

    Card(Suite suite, Figure figure) {
        this.suite = suite;
        this.figure = figure;
    }

    String getCardName() {
        return figure.getFigureName() + suite.getSuiteSymbol();
    }

    int getCardValue() {
        return figure.getFigureValue();
    }
}

class Deck{
    Card[] cards;

    Deck(){
        cards = new Card[52];
        int index = 0;
        for(Suite suite : Suite.values()){
            for(Figure figure : Figure.values()){
                cards[index] = new Card(suite, figure);
                index++;
            }
        }
    }
}

void shuffle(){
    Random random = new Random();
    Object cards;
    for(int i = 0; i < cards.length; i++){
        int randomIndex = random.nextInt(cards.length);
        Card temp = cards [i];
        cards [i] = cards [randomIndex];
        cards [randomIndex] = temp;
    }
}

class Player{
    String name;
    ArrayList<Card> cards = new ArrayList<>();

    Player(String name){
        this.name = name;
    }
}

class Blackjack{
    Deck deck;
    Player player;
    Player dealer;

    Blackjack(String playerName){
        deck = new Deck();
        player = new Player(playerName);
        dealer = new Player("Dealer");
    }
}

