package beauisbarbie.scl;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeLv2ResultActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase,mTotal;
    private ProgressDialog mProgres;
    private FirebaseUser mCurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_lv2_result);

        TextView resultLabel = (TextView) findViewById(R.id.resultLabel);
        Typeface myFont1 = Typeface.createFromAsset(getAssets(),"fonts/SanamDeklen_chaya.ttf");
        resultLabel.setTypeface(myFont1);
        //TextView totalscoreLabel = (TextView) findViewById(R.id.totalscoreLabel);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT",0);

        SharedPreferences setting = getSharedPreferences("quizApp", Context.MODE_PRIVATE);
        int totalScore = setting.getInt("totalScore",0);
        totalScore +=score;

        resultLabel.setText(score+ " / 700");
        //totalscoreLabel.setText("Total Score : " + totalScore);

        SharedPreferences.Editor editor = setting.edit();
        editor.putInt("totalScore", totalScore);
        editor.commit();

        saveScoreLv2(score);

    }

    //บันทึกคะแนน
    private void saveScoreLv2(int score) {
        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();
        String lv_uid = mCurrentUser.getUid();
        mDatabase = FirebaseDatabase.getInstance().getReference()
                .child("Points").child(lv_uid);
        mDatabase.child("score").child("home").child("lv2").setValue(score);
    }


    public void returnTop(View view){
        Intent intent = new Intent(getApplicationContext(),GameHomeActivity.class);
        startActivity(intent);
    }

    public void nextLv(View view){
        Intent intent = new Intent(getApplicationContext(),HomeQuizLv3Activity.class);
        startActivity(intent);
    }
}
