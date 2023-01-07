public class Hand{
    private Card [] hand;
    private int numCards;
    private int handTotal;

    public Hand(int size){
        hand = new Card[size];
        numCards = 0;
        handTotal = 0;
    }

    public void display(){
        System.out.println("\n\nYour Hand:");
        for(int i = 0; i < numCards; i++){
            System.out.print(hand[i].toString() + " ");
        }
    }
    
    public void addCard(Card card){
        if(numCards < hand.length){
            hand[numCards] = card;
            numCards++;
        } else {
            System.out.println("Error");
        }
    }

    public int getValue(){
        handTotal = 0;
        for(int i = 0; i < numCards; i++){
            char rank = (hand[i].toString()).charAt(0);
            if(rank == 'J' || rank == 'Q' || rank == 'K' || rank == '1'){
                handTotal += 10;
            } else if (rank == 'A'){
                handTotal += 1;
            } else {
                switch(rank){
                    case '2':
                    handTotal += 2;
                    break;
                    case '3':
                    handTotal += 3;
                    break;
                    case '4':
                    handTotal += 4;
                    break;
                    case '5':
                    handTotal += 5;
                    break;
                    case '6':
                    handTotal += 6;
                    break;
                    case '7':
                    handTotal += 7;
                    break;
                    case '8':
                    handTotal += 8;
                    break;
                    case '9':
                    handTotal += 9;
                    break;

                }
            }
        }
        return handTotal;
    }
}