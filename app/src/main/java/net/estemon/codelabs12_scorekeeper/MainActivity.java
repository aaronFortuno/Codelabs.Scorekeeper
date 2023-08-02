package net.estemon.codelabs12_scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Member variables for holding the score
    private int mScore1;
    private int mScore2;

    // Member variables for showing the score
    private TextView mScoreText1;
    private TextView mScoreText2;

    private ImageButton decTeam1;
    private ImageButton incTeam1;
    private ImageButton decTeam2;
    private ImageButton incTeam2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find TextViews by ID
        mScoreText1 = findViewById(R.id.score_1);
        mScoreText2 = findViewById(R.id.score_2);

        // Find ImageViews by ID
        decTeam1 = findViewById(R.id.decreaseTeam1);
        incTeam1 = findViewById(R.id.increaseTeam1);
        decTeam2 = findViewById(R.id.decreaseTeam2);
        incTeam2 = findViewById(R.id.increaseTeam2);

        // Set onClickListeners to each Imagebutton
        decTeam1.setOnClickListener(this::decreaseScore);
        incTeam1.setOnClickListener(this::increaseScore);
        decTeam2.setOnClickListener(this::decreaseScore);
        incTeam2.setOnClickListener(this::increaseScore);

    }

    /**
     * Method that handles the behavior of both the decrement buttons
     * @param view The button view that was clicked
     */
    public void decreaseScore(View view) {
        // Get the ID of the button that was clicked.
        int viewID = view.getId();
        if (viewID == R.id.decreaseTeam1) { // If it was on Team 1
            // Decrement the score and update the TextView
            mScore1--;
            mScoreText1.setText(String.valueOf(mScore1));
        } else if (viewID == R.id.decreaseTeam2) { // If it was on Team 2
            // Decrement the score and update the TextView
            mScore2--;
            mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    /**
     * Method that handles the behavior of both the increment buttons
     * @param view The button view that was clicked
     */
    public void increaseScore(View view) {
        // Get the ID of the button that was clicked.
        int viewID = view.getId();
        if (viewID == R.id.increaseTeam1) { // If it was on Team 1
            // Increment the score and update the TextView
            mScore1++;
            mScoreText1.setText(String.valueOf(mScore1));
        } else if (viewID == R.id.increaseTeam2) { // If it was on Team 2
            // Increment the score and update the TextView
            mScore2++;
            mScoreText2.setText(String.valueOf(mScore2));
        }
    }
}