package beauisbarbie.scl;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import beauisbarbie.scl.adapters.AdapterHomeActivity;

public class ViewHomeActivity extends AppCompatActivity {
    ViewPager pager;
    ImageButton ViewClose,ViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_home);

        ViewClose = (ImageButton) findViewById(R.id.View_close);
        ViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn=new Intent(ViewHomeActivity.this,AtHomeActivity.class);
                startActivity(btn);
            }
        });

        ViewList = (ImageButton) findViewById(R.id.View_list);
        ViewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn=new Intent(ViewHomeActivity.this,HomeRecyclewiewActivity.class);
                startActivity(btn);
            }
        });

        AdapterHomeActivity adapterHomeActivity = new AdapterHomeActivity(getSupportFragmentManager());
        pager = (ViewPager) findViewById(R.id.pagerHome);
        pager.setAdapter(adapterHomeActivity);
    }
}
