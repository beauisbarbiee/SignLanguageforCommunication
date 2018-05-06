package beauisbarbie.scl;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class AtHomeActivity extends AppCompatActivity {
    ImageButton Learning,playGame;
    TextView T1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at_home);

        T1 = (TextView) findViewById(R.id.textView6);
        Typeface myFont1 = Typeface.createFromAsset(getAssets(),"fonts/SanamDeklen_chaya.ttf");
        T1.setTypeface(myFont1);

        Learning = (ImageButton) findViewById(R.id.btn_learning);
        Learning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn=new Intent(AtHomeActivity.this,ViewHomeActivity.class);
                startActivity(btn);
            }
        });


        playGame = (ImageButton) findViewById(R.id.btn_playgame);
        playGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn=new Intent(AtHomeActivity.this,GameHomeActivity.class);
                startActivity(btn);
            }
        });
    }
}
