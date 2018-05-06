package beauisbarbie.scl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class LocationActivity extends AppCompatActivity {
    ImageButton AtHome, AtSchool, AtHospital, AtRestaurant, AtMarket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        //เมนูบ้าน
        AtHome = (ImageButton) findViewById(R.id.btn_atHome);
        AtHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn=new Intent(LocationActivity.this,AtHomeActivity.class);
                startActivity(btn);
            }
        });

        AtSchool = (ImageButton) findViewById(R.id.btn_atSchool);
        AtSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn=new Intent(LocationActivity.this,AtSchoolActivity.class);
                startActivity(btn);
            }
        });


        AtHospital = (ImageButton) findViewById(R.id.btn_atHospital);
        AtHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn=new Intent(LocationActivity.this,AtHospitalActivity.class);
                startActivity(btn);
            }
        });


        AtRestaurant = (ImageButton) findViewById(R.id.btn_atRestaurant);
        AtRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn=new Intent(LocationActivity.this,AtRestaurantActivity.class);
                startActivity(btn);
            }
        });


        AtMarket = (ImageButton) findViewById(R.id.btn_atMarket);
        AtMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn=new Intent(LocationActivity.this,AtMarketActivity.class);
                startActivity(btn);
            }
        });
    }
}
