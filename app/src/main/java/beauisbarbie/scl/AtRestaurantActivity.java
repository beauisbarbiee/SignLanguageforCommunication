package beauisbarbie.scl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AtRestaurantActivity extends AppCompatActivity {
    ImageButton Learning,playGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at_restaurant);

        Learning = (ImageButton) findViewById(R.id.btn_learning);
        Learning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn=new Intent(AtRestaurantActivity.this,ViewHomeActivity.class);
                startActivity(btn);
            }
        });


        playGame = (ImageButton) findViewById(R.id.btn_playgame);
        playGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn=new Intent(AtRestaurantActivity.this,GameRestaurantActivity.class);
                startActivity(btn);
            }
        });
    }
}
