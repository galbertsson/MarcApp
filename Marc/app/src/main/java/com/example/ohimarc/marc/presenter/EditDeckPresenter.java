package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.view.editDeckView.BasicNoteViewHolder;
import com.example.ohimarc.marc.view.editDeckView.EditDeckActivity;
import com.example.ohimarc.marc.view.editDeckView.EditDeckContract;


/**
 * @author Mathias Forsman (Sorchar on github)
 * <p>
 * This is the presenter that is the middleman that handles
 * communication between the model and editDeckActivity.
 */

public class EditDeckPresenter implements EditDeckContract.Presenter {
    private final Deck deck;
    private final EditDeckActivity editDeckActivity;
    private final int deckIndex;

    /**
     * Constructs a EditDeckPresenter
     *
     * @param a         the view that is constructing this presenter
     * @param deckIndex the index of a specific deck from the active user
     */
    public EditDeckPresenter(EditDeckActivity a, int deckIndex) {
        this.editDeckActivity = a;
        this.deckIndex = deckIndex;
        this.deck = MemorizationTrainingTool.getInstance().getActiveUser().getDeck(deckIndex);
    }

    /**
     * calls updateDeckList in the view when called upon
     */
    @Override
    public void start() {
        editDeckActivity.updateDeckList();
    }

    /**
     * handles setting up rows in the recyclerView
     *
     * @param rowView  holds everything regarding the object in a row
     * @param position is the index/position of a row in the recyclerView
     */
    @Override
    public void onBindBasicNoteRowViewAtPosition(BasicNoteViewHolder rowView, int position) {
        String[][] cardsCopies = deck.getCardCopies();
        rowView.setBasicNoteText(cardsCopies[position][0], cardsCopies[position][1]);
    }

    /**
     * Used when the needed to get the amount of objects inside of deck(size)
     *
     * @return the amount of cards in deck
     */
    @Override
    public int getCardRowsCount() {
        return deck.getDeckSize();
    }

    /**
     * calls editCardInDeck with the index of the card that has been clicked
     *
     * @param adapterPosition is the index in the recyclerView that the user clicked at
     */
    @Override
    public void onUserClickedAtPosition(int adapterPosition) {
        editDeckActivity.editCardInDeck(deck.getNoteIndexFromCardIndex(adapterPosition), deckIndex);
    }

    /**
     * calls promptForDeletion with the index of the card that has been longClicked
     *
     * @param adapterPosition is the index in the recyclerView that the user long clicked at
     */
    @Override
    public void onUserLongClickedAtPosition(int adapterPosition) {
        editDeckActivity.promptForDeletion(deck.getNoteIndexFromCardIndex(adapterPosition));
    }

    /**
     * gets the deckTitle from deck and returns it
     *
     * @return the title of the deck that is currently in "editing mode"
     */
    public String getDeckTitle() {
        return deck.getTitle();
    }

    /**
     * Deletes a specific note when given an index
     *
     * @param index is the card in the list that will get deleted
     */
    public void confirmDeletion(int index) {
        deck.deleteNote(index);
    }


}
