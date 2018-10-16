package com.example.ohimarc.marc.view.achievementsView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.ohimarc.marc.R;

public class AchievementsActivity extends AppCompatActivity implements AchievementsView {


    private Button ach0;
    private Button ach1;
    private Button ach2;
    private Button ach3;
    private Button ach4;
    private Button ach5;
    private Button ach6;
    private Button ach7;
    private Button ach8;
    private Button[] buttons = new Button[9];
    private Drawable trophy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        initItems();
        assignButtons();
    }

    private void initItems() {
        trophy = ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_trophy);
        ach0 = findViewById(R.id.ach1);
        ach1 = findViewById(R.id.ach2);
        ach2 = findViewById(R.id.ach3);
        ach3 = findViewById(R.id.ach4);
        ach4 = findViewById(R.id.ach5);
        ach5 = findViewById(R.id.ach6);
        ach6 = findViewById(R.id.ach7);
        ach7 = findViewById(R.id.ach8);
        ach8 = findViewById(R.id.ach9);
    }

    private void assignButtons() {
        buttons[0] = ach0;
        buttons[1] = ach1;
        buttons[2] = ach2;
        buttons[3] = ach3;
        buttons[4] = ach4;
        buttons[5] = ach5;
        buttons[6] = ach6;
        buttons[7] = ach7;
        buttons[8] = ach8;
    }
    private void unlockAchievements() {
        for(Button b : buttons) {
            b.setBackground(trophy);
        }
    }

}
