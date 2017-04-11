package hu.borde.goalkeeper;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class GoalKeeper extends AppCompatActivity {

    private Map<Integer, TextView> goals;
    private Map<Integer, TextView> penalties;
    private Map<Integer, TextView> results;

    private int[] goalNumber;
    private int[] penaltyNumber;
    private int[] resultValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        goals = new HashMap<>();
        penalties = new HashMap<>();
        results = new HashMap<>();

        goalNumber = new int[2];
        penaltyNumber = new int[2];
        resultValue = new int[2];

        setContentView(R.layout.activity_goal_keeper);

        goals.put(1, (TextView)findViewById(R.id.team1Goals));
        goals.put(2, (TextView)findViewById(R.id.team2Goals));
        penalties.put(1, (TextView)findViewById(R.id.team1Penalties));
        penalties.put(2, (TextView)findViewById(R.id.team2Penalties));
        results.put(1, (TextView)findViewById(R.id.team1OverallScore));
        results.put(2, (TextView)findViewById(R.id.team2OverallScore));
    }

    public void incrementGoal(View view) {
        goalNumber[getTeamNumber(view) - 1]++;
        updateView();
    }

    public void incrementPenalty(View view) {
        penaltyNumber[getTeamNumber(view) - 1]++;
        updateView();
    }

    public void resetResults(View view) {
        goalNumber = new int[2];
        penaltyNumber = new int[2];
        updateView();
    }

    private int getTeamNumber(View view) {
        String buttonId = getResources().getResourceEntryName(view.getId());
        return Integer.parseInt(buttonId.substring(buttonId.length() - 1));
    }

    private void updateView() {
        for (int i = 1;i <= 2;i++) {
            goals.get(i).setText(String.valueOf(goalNumber[i-1]));
            penalties.get(i).setText(String.valueOf(penaltyNumber[i - 1]));
            results.get(i).setText(String.valueOf(goalNumber[i - 1] + penaltyNumber[i - 1]));
        }
    }

}
