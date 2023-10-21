package src.week5;

public class DeckOfCard {
    public static void main(String[] args) {
        int[] deck = new int[52]; // 0-51
        String[] suits = {"Spades","Hearts","Diamonds","Clubs"};
        String[] ranks = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};

        dealFourCards(deck,suits,ranks);
    }

    public static void dealFourCards(int[] deck, String[] suits, String[] ranks) {
        //pick the card in the deck
        String[] dealtCards = {"","","",""};
//        String[] dealtCards = new String[4]; [null,null,null,null]


        for (int i = 0; i < dealtCards.length; i++) {
            int cardIndex = (int)(Math.random() * deck.length);
            String suit = "";
            String card = "";

            //o-12 spades, 13-25 hearts, 26-38 Diamonds, 39-51 Clubs
            if(cardIndex >= 0 && cardIndex <= 12) {
                suit = suits[0];
            }
            if(cardIndex >= 13 && cardIndex <= 25) {
                suit = suits[1];
            }
            if(cardIndex >= 26 && cardIndex <= 38) {
                suit = suits[2];
            }
            if(cardIndex >= 39 && cardIndex <= 51) {
                suit = suits[3];
            }

            card = ranks[cardIndex % 13];

            String finalCard = String.format("%s of %s", card, suit); // 3 of spades

            boolean isDuplicate = false;
            for (int j = 0; j < dealtCards.length; j++) {
                if(dealtCards[j].equals(finalCard)) {
                    isDuplicate = true;
                    break;
                }
            }
            if(isDuplicate) {
                i--;
            }
            else {
                dealtCards[i] = finalCard;
            }

        }

//        for (int i = 0; i < dealtCards.length; i++) {
//            System.out.println(dealtCards[i]);
//        }
        for (String myCard : dealtCards) {
            System.out.println(myCard);
        }

    }
}
