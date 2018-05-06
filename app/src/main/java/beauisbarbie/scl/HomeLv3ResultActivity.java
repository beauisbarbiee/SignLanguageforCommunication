package beauisbarbie.scl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by beauisbarbie on 26/3/2018 AD.
 */

public class HomeLv3ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_lv2_result);

        TextView resultLabel = (TextView) findViewById(R.id.resultLabel);
        //TextView totalscoreLabel = (TextView) findViewById(R.id.totalscoreLabel);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT",0);

        SharedPreferences setting = getSharedPreferences("quizApp", Context.MODE_PRIVATE);
        int totalScore = setting.getInt("totalScore",0);
        totalScore +=score;

        resultLabel.setText(score+ " / 9");
        //totalscoreLabel.setText("Total Score : " + totalScore);

        SharedPreferences.Editor editor = setting.edit();
        editor.putInt("totalScore", totalScore);
        editor.commit();
    }

    public void returnTop(View view) {
        Intent intent = new Intent(getApplicationContext(), GameHomeActivity.class);
        startActivity(intent);
    }

    public void nextLv(View view){
        Intent intent = new Intent(getApplicationContext(),HomeQuizLv4Activity.class);
        startActivity(intent);
    }
}
