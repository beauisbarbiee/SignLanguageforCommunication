package beauisbarbie.scl;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import pl.droidsonroids.gif.GifImageView;

public class HomeActivity extends AppCompatActivity {

    MediaPlayer myMusic;

    private DatabaseReference mUsername, mSex, mTotal;
    private FirebaseUser mCurrentUser;

    private TextView tUsername,tTotal;
    ImageButton Start,Setting;

    TextView T1,T2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        myMusic = MediaPlayer.create(this,R.raw.music);
        myMusic.start();
        myMusic.setLooping(true);

        //แสดงตัวละครวัดผล
        final GifImageView gifImageView = findViewById(R.id.gifActor);
        Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/Actor%2Funi.gif?alt=media&token=7805c25f-ce0a-4bb6-b7f1-b11d7a942ab5")
                .into(gifImageView);

        //ปุ่ม "เริ่ม"

        Start = (ImageButton) findViewById(R.id.btn_start);
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn=new Intent(HomeActivity.this,MenuActivity.class);
                startActivity(btn);
            }
        });

        //Setting
        ImageButton mShowDialog = (ImageButton) findViewById(R.id.settingBtn);
        mShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(HomeActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.setting, null);
                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });


        //แสดง Username
        tUsername = (TextView) findViewById(R.id.textUsername);
        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();
        String current_uid = mCurrentUser.getUid();
        mUsername = FirebaseDatabase.getInstance().getReference().child("Users").child(current_uid);
        mUsername.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String name = dataSnapshot.child("name").getValue().toString();
                tUsername.setText(name);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //คะแนน
        tTotal = (TextView) findViewById(R.id.textScore);
        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();
        String uid = mCurrentUser.getUid();
        mTotal = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);
        mTotal.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String total = dataSnapshot.child("total").getValue().toString();
                tTotal.setText(total);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        //Sex Type
        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();
        String Sex_uid = mCurrentUser.getUid();
        mSex = FirebaseDatabase.getInstance().getReference().child("Users").child(Sex_uid);
        mSex.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String sex = dataSnapshot.child("sex").getValue().toString();
                //Toast.makeText(HomeActivity.this,sex,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        //Font

        T1 = (TextView) findViewById(R.id.textUsername);
        Typeface myFont1 = Typeface.createFromAsset(getAssets(),"fonts/SanamDeklen_chaya.ttf");
        T1.setTypeface(myFont1);

        T2 = (TextView) findViewById(R.id.textScore);
        Typeface myFont = Typeface.createFromAsset(getAssets(),"fonts/SanamDeklen_chaya.ttf");
        T2.setTypeface(myFont);
    }
}
