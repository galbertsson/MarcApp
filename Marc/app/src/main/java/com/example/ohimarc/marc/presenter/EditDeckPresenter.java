package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.BasicNote;
import com.example.ohimarc.marc.model.Deck;
import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.view.editdeck.BasicNoteViewHolder;
import com.example.ohimarc.marc.view.editdeck.EditDeckActivity;
import com.example.ohimarc.marc.view.editdeck.EditDeckContract;

public class EditDeckPresenter implements EditDeckContract.Presenter {
    private Deck deck;
    private EditDeckActivity editDeckActivity;

    public EditDeckPresenter(EditDeckActivity a, int deckIndex) {
        this.editDeckActivity = a;
        this.deck = MemorizationTrainingTool.getInstance().getActiveUser().getDeck(deckIndex);
    }

    @Override
    public void start() {
        editDeckActivity.updateDeckList();
    }

    @Override
    public void onBindBasicNoteRowViewAtPosition(BasicNoteViewHolder rowView, int position) {
        BasicNote basicNote = (BasicNote) deck.getNotes().get(position);
        rowView.setBasicNoteText(basicNote.getFront(), basicNote.getBack());
    }

    /**
     * @return the amount of cards in deck
     */
    @Override
    public int getCardRowsCount() {
        return deck.getDeckSize();
    }

    @Override
    public void onUserClickedAtPosition(int adapterPosition) {
        editDeckActivity.editCardInDeck(deck.getNoteIndexFromCardIndex(adapterPosition));
    }

    @Override
    public void onUserLongClickedAtPosition(int adapterPosition) {
        editDeckActivity.promptForDeletion(deck.getNoteIndexFromCardIndex(adapterPosition), deck);
    }

    /**
     * @param index is the card in the list that will get deleted
     */
    public void confirmDeletion(int index) {
        deck.deleteNote(index);
    }

}
