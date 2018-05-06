package beauisbarbie.scl;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GameHomeActivity extends AppCompatActivity {
    int lv_1 = 3, lv_2 = 0, lv_3 = 0, lv_4 = 0, lv_5 = 0, lv_6 = 0;
    ImageButton lv1,lv2,lv3,lv4,lv5,lv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_home);

        final ImageView l2 = findViewById(R.id.lv2);
        final ImageView l3 = findViewById(R.id.lv3);
        final ImageView l4 = findViewById(R.id.lv4);
        final ImageView l5 = findViewById(R.id.lv5);
        final ImageView l6 = findViewById(R.id.lv6);

        //Level 1
        lv1 = (ImageButton) findViewById(R.id.lv1);
        lv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn=new Intent(GameHomeActivity.this,QuizHomeActivity.class);
                startActivity(btn);
            }
        });

        //Level 2
        lv2 = (ImageButton) findViewById(R.id.lv2);
        if (lv_1 < 1){
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/etc.%2Fpadlock.png?alt=media&token=cfb2d5a4-2bcf-4cdd-856d-d29e81e7f8da")
                    .into(l2);
        } else {
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/etc.%2Fghome.png?alt=media&token=5d44d2f5-c53c-48e5-b4b7-bfb14a3ab8f7")
                    .into(l2);
            lv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent btn=new Intent(GameHomeActivity.this,HomeQuizLv2Activity.class);
                    startActivity(btn);
                }
            });
        }

        //Level 3
        lv3 = (ImageButton) findViewById(R.id.lv3);
        if (lv_2 < 1){
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/etc.%2Fpadlock.png?alt=media&token=cfb2d5a4-2bcf-4cdd-856d-d29e81e7f8da")
                    .into(l3);
        } else {
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/etc.%2Fghome.png?alt=media&token=5d44d2f5-c53c-48e5-b4b7-bfb14a3ab8f7")
                    .into(l3);
            lv3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent btn=new Intent(GameHomeActivity.this,HomeQuizLv3Activity.class);
                    startActivity(btn);
                }
            });
        }

        //Level 4
        lv4 = (ImageButton) findViewById(R.id.lv4);
        if (lv_3 < 1){
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/etc.%2Fpadlock.png?alt=media&token=cfb2d5a4-2bcf-4cdd-856d-d29e81e7f8da")
                    .into(l4);
        } else {
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/etc.%2Fghome.png?alt=media&token=5d44d2f5-c53c-48e5-b4b7-bfb14a3ab8f7")
                    .into(l4);
            lv4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent btn=new Intent(GameHomeActivity.this,HomeQuizLv4Activity.class);
                    startActivity(btn);
                }
            });
        }

        //Level 5
        lv5 = (ImageButton) findViewById(R.id.lv5);
        if (lv_4 < 1){
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/etc.%2Fpadlock.png?alt=media&token=cfb2d5a4-2bcf-4cdd-856d-d29e81e7f8da")
                    .into(l5);
        } else {
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/etc.%2Fghome.png?alt=media&token=5d44d2f5-c53c-48e5-b4b7-bfb14a3ab8f7")
                    .into(l5);
            lv5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent btn=new Intent(GameHomeActivity.this,HomeQuizLv5Activity.class);
                    startActivity(btn);
                }
            });
        }

        //Level 6
        lv6 = (ImageButton) findViewById(R.id.lv6);
        if (lv_5 < 1){
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/etc.%2Fpadlock.png?alt=media&token=cfb2d5a4-2bcf-4cdd-856d-d29e81e7f8da")
                    .into(l6);
        } else {
            Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/etc.%2Fghome.png?alt=media&token=5d44d2f5-c53c-48e5-b4b7-bfb14a3ab8f7")
                    .into(l6);
            lv6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent btn=new Intent(GameHomeActivity.this,HomeQuizLv6Activity.class);
                    startActivity(btn);
                }
            });
        }

    }

}
