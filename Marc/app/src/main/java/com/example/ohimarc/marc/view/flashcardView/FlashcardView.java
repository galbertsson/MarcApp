package com.example.ohimarc.marc.view.flashcardView;

public interface FlashcardView {
    void flipCardButton(String qOrA, String text);
    void initTexts(String deckTitleText, String cardText);
    void changeView();
}
