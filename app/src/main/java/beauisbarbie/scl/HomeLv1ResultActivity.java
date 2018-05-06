package beauisbarbie.scl;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeLv1ResultActivity extends AppCompatActivity {

     DatabaseReference mDatabase,mTotal,mRef;
     FirebaseUser mCurrentUser;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_lv1_result);


        TextView resultLabel = (TextView) findViewById(R.id.resultLabel);
        Typeface myFont1 = Typeface.createFromAsset(getAssets(),"fonts/SanamDeklen_chaya.ttf");
        resultLabel.setTypeface(myFont1);

        //TextView totalscoreLabel = (TextView) findViewById(R.id.totalscoreLabel);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT", 0);

        SharedPreferences setting = getSharedPreferences("quizApp", Context.MODE_PRIVATE);
        int totalScore = setting.getInt("totalScore", 0);
        totalScore += score;

        resultLabel.setText(score+" / 500");
        //totalscoreLabel.setText("Total Score : " + totalScore);

        SharedPreferences.Editor editor = setting.edit();
        editor.putInt("totalScore", totalScore);
        editor.commit();

        saveScoreLv1(score);

        // ประเมินผลรูปแบบดาว
        final ImageView imageView1 = findViewById(R.id.star1);
        final ImageView imageView2 = findViewById(R.id.star2);
        final ImageView imageView3 = findViewById(R.id.star3);

        if (score > 400) {
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/etc.%2Fstar.png?alt=media&token=21331f0e-ac1c-4f7b-969d-0639dadc3830")
                    .into(imageView1);
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/etc.%2Fstar.png?alt=media&token=21331f0e-ac1c-4f7b-969d-0639dadc3830")
                    .into(imageView2);
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/etc.%2Fstar.png?alt=media&token=21331f0e-ac1c-4f7b-969d-0639dadc3830")
                    .into(imageView3);
        } else if (score > 200) {
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/etc.%2Fstar.png?alt=media&token=21331f0e-ac1c-4f7b-969d-0639dadc3830")
                    .into(imageView1);
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/etc.%2Fstar.png?alt=media&token=21331f0e-ac1c-4f7b-969d-0639dadc3830")
                    .into(imageView2);
        } else if (score > 0){
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/etc.%2Fstar.png?alt=media&token=21331f0e-ac1c-4f7b-969d-0639dadc3830")
                    .into(imageView1);
        } else {

        }
    }

    //บันทึกคะแนน
    private void saveScoreLv1(final int score) {


        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();
        final String current_uid = mCurrentUser.getUid();
        mDatabase = FirebaseDatabase.getInstance().getReference()
                .child("Points").child(current_uid);
        mDatabase.child("score").child("home").child("lv1").setValue(score);

        //รวมคะแนน
        mTotal = FirebaseDatabase.getInstance().getReference().child("Users").child(current_uid);
        mTotal.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //String total = dataSnapshot.child("total").getValue().toString();
                int total = dataSnapshot.getValue(int.class);
                Toast.makeText(HomeLv1ResultActivity.this,total,Toast.LENGTH_LONG).show();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }


    // Button Return
    public void returnTop(View view){
        Intent intent = new Intent(getApplicationContext(),GameHomeActivity.class);
        startActivity(intent);

    }

    // Button Next
    public void nextLv(View view){
        Intent intent = new Intent(getApplicationContext(),HomeQuizLv2Activity.class);
        startActivity(intent);
    }
}
