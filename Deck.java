import java.util.Random;

public class Deck{

    private Card[] deck = new Card[52];
    private int nextCard;
    private Random rand;

    public Deck(){
        int i = 0;
        for(int suit = 0; suit < 4; suit++){
            for(int rank = 0; rank < 13; rank++){
                deck[i] = new Card(rank,suit);
                i++;
            }
        }
    }

    public void shuffle(){
        Random rand = new Random();
        int shuffledCard = 0;
        Card tempCard = new Card();
        boolean valid = true;
        for(int index = 0; index < deck.length; index++){
            do{
                shuffledCard = rand.nextInt(52);
                if(deck[shuffledCard] == deck[index]){
                    valid = false;
                } else {
                    tempCard = deck[index];
                    deck[index] = deck[shuffledCard];
                    deck[shuffledCard] = tempCard;
                    valid = true;
                }
            }while(valid == false);
        }
    }
    public void display(){
        int index = 0;
        for(int suit = 0; suit < 4; suit++){
            for(int rank = 0; rank < 13; rank++){
                System.out.print(deck[index].toString() + " ");
                index++;
            }
        }       
    }

    public Card dealCard(){
        Card cardDelt = new Card();
        for(int index = 0; index < 52; index++){
            if(index == nextCard){
                cardDelt = deck[index];
            }
        }
        nextCard++;
        return cardDelt;
    }
}