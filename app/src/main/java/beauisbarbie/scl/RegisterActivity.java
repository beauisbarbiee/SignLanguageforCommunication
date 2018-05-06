package beauisbarbie.scl;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    private Button Save;
    private EditText email;
    private EditText password;
    private EditText name;
    private RadioGroup radioGroup;
    private RadioButton radioButton,m,g;


    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private ProgressDialog mProgres;

    TextView t1,t2,t3,t4,t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Fonts
        t1 = (TextView) findViewById(R.id.textView);
        Typeface myFont1 = Typeface.createFromAsset(getAssets(),"fonts/SanamDeklen_chaya.ttf");
        t1.setTypeface(myFont1);

        t2 = (TextView) findViewById(R.id.textView3);
        Typeface myFont2 = Typeface.createFromAsset(getAssets(),"fonts/SanamDeklen_chaya.ttf");
        t2.setTypeface(myFont2);

        t3 = (TextView) findViewById(R.id.textView7);
        Typeface myFont3 = Typeface.createFromAsset(getAssets(),"fonts/SanamDeklen_chaya.ttf");
        t3.setTypeface(myFont3);

        t4 = (TextView) findViewById(R.id.textView9);
        Typeface myFont4 = Typeface.createFromAsset(getAssets(),"fonts/SanamDeklen_chaya.ttf");
        t4.setTypeface(myFont4);

        t5 = (TextView) findViewById(R.id.textView10);
        Typeface myFont5 = Typeface.createFromAsset(getAssets(),"fonts/SanamDeklen_chaya.ttf");
        t5.setTypeface(myFont5);


        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
        mProgres = new ProgressDialog(this);

        email = (EditText) findViewById(R.id.text_email);
        Typeface myFont6 = Typeface.createFromAsset(getAssets(),"fonts/SanamDeklen_chaya.ttf");
        email.setTypeface(myFont6);

        password = (EditText) findViewById(R.id.text_password);
        Typeface myFont7 = Typeface.createFromAsset(getAssets(),"fonts/SanamDeklen_chaya.ttf");
        password.setTypeface(myFont7);

        name = (EditText) findViewById(R.id.text_name);
        Typeface myFont8 = Typeface.createFromAsset(getAssets(),"fonts/SanamDeklen_chaya.ttf");
        name.setTypeface(myFont8);


        radioGroup = (RadioGroup) findViewById(R.id.radio);
        m = (RadioButton) findViewById(R.id.radioMale);
        Typeface myFont9 = Typeface.createFromAsset(getAssets(),"fonts/SanamDeklen_chaya.ttf");
        m.setTypeface(myFont9);

        g = (RadioButton) findViewById(R.id.radioFemale);
        Typeface myFont10 = Typeface.createFromAsset(getAssets(),"fonts/SanamDeklen_chaya.ttf");
        g.setTypeface(myFont10);



        Save = (Button) findViewById(R.id.btn_Save);
        Typeface myFont11 = Typeface.createFromAsset(getAssets(),"fonts/SanamDeklen_chaya.ttf");
        Save.setTypeface(myFont11);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String re_email = email.getText().toString();
                String re_password = password.getText().toString();
                String re_name = name.getText().toString().trim();

                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);

                if ((TextUtils.isEmpty(re_email)) | (TextUtils.isEmpty(re_name)) | (TextUtils.isEmpty(re_password))) {
                    Toast.makeText(RegisterActivity.this,
                            "กรุณากรอกข้อมูลให้ครบ!", Toast.LENGTH_SHORT).show();
                }else {

                    RegisterAccount(re_email, re_password, re_name);

                }
            }
        });
    }



    private void RegisterAccount(final String email, String password, final String name) {

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(name)) {
            mProgres.setMessage("บันทึกข้อมูล...");
            mProgres.show();

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                String user_id = mAuth.getCurrentUser().getUid();
                                mDatabase = FirebaseDatabase.getInstance().getReference()
                                        .child("Users").child(user_id);

                                mDatabase.child("name").setValue(name);
                                mDatabase.child("email").setValue(email);

                                String sex = radioButton.getText().toString();
                                mDatabase.child("sex").setValue(sex);
                                mProgres.dismiss();

                                mDatabase.child("total").setValue("0");



                                Intent mainIntent = new Intent(RegisterActivity.this, HomeActivity.class);
                                mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(mainIntent);
                            }
                        }
                    });
        }else {
            Toast.makeText(RegisterActivity.this,
                    "เกิดข้อผิดพลาด " , Toast.LENGTH_SHORT).show();

        }

    }
}
