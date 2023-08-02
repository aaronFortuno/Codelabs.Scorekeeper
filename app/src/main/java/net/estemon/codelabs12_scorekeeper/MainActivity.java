package net.estemon.codelabs12_scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Find TextViews by ID
        mScoreText1 = findViewById(R.id.score_1);
        mScoreText2 = findViewById(R.id.score_2);

        // Find ImageViews by ID
        ImageButton decTeam1 = findViewById(R.id.decreaseTeam1);
        ImageButton incTeam1 = findViewById(R.id.increaseTeam1);
        ImageButton decTeam2 = findViewById(R.id.decreaseTeam2);
        ImageButton incTeam2 = findViewById(R.id.increaseTeam2);

        // Set onClickListeners to each Imagebutton
        decTeam1.setOnClickListener(this::decreaseScore);
        incTeam1.setOnClickListener(this::increaseScore);
        decTeam2.setOnClickListener(this::decreaseScore);
        incTeam2.setOnClickListener(this::increaseScore);

        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            // Set the score text views.
            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        // Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Check if the correct item was clicked
        if (item.getItemId() == R.id.night_mode) {
            // Get the night mode state of the app.
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            // Set the theme mode for the restarted activity
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            // Recreate the activity for the theme change to take effect
            recreate();
        }
        return true;
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save the scores
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }
}