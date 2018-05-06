package beauisbarbie.scl;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartActivity extends AppCompatActivity {
    private Button Register;

    TextView t1,t2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //Font

        t1 = (TextView) findViewById(R.id.textView4);
        Typeface myFont1 = Typeface.createFromAsset(getAssets(),"fonts/SanamDeklen_chaya.ttf");
        t1.setTypeface(myFont1);

        t2 = (TextView) findViewById(R.id.textView2);
        Typeface myFont2 = Typeface.createFromAsset(getAssets(),"fonts/SanamDeklen_chaya.ttf");
        t2.setTypeface(myFont2);


        Register = (Button) findViewById(R.id.btn_Register);
        Typeface myFont3 = Typeface.createFromAsset(getAssets(),"fonts/SanamDeklen_chaya.ttf");
        Register.setTypeface(myFont3);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent btn = new Intent(StartActivity.this,RegisterActivity.class);
                startActivity(btn);
            }
        });
    }
}
