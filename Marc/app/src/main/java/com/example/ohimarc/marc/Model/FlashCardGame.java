package com.example.ohimarc.marc.models;

public class FlashCardGame extends Game {
    private int nextCard = 0;

    public FlashCardGame(Deck deck){
        super(deck,"Flashcard Game");
    }

    @Override
    public String[] peekNextCard() {
        return nextCard < cardCopies.length ? cardCopies[nextCard] : null;
    }
    @Override
    public void goToNextCard() {
        nextCard++;
    }

    public int getNextCard(){
        return nextCard;
    }

    public int getDecksize(){
        return deck.getDeckSize();
    }
}
