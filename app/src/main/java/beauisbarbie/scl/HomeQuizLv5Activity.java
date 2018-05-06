package beauisbarbie.scl;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class HomeQuizLv5Activity extends AppCompatActivity {
    private TextView countLabel;
    private GifImageView questionLabel;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;


    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int questionCount = 1;
    static final private int QUIZ_COUNT = 13;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            // คำถาม , คำตอบ , ช้อย1 , ช้อย2 , ช้อย3
            {"https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/VocubHome%2Fh1.gif?alt=media&token=e33d0913-8acf-4b85-aa89-c516afa77e16", "เตารีด", "กุญแจ", "พัดลม", "แม่"},
            {"https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/VocubHome%2Fh2.gif?alt=media&token=bd6c73e7-b363-4d05-87b3-b11ebdfcbef3", "กุญแจ", "ตุ๊กตา", "สบู่", "ช้อน"},
            {"https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/VocubHome%2Fh3.gif?alt=media&token=5bd40dd9-c9b4-4aa1-ace1-81e958c565c2", "พัดลม", "ตุ๊กตา", "เครื่องปรับอากาศ", "มีด"},
            {"https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/VocubHome%2Fh4.gif?alt=media&token=b152d5e2-ba36-4153-8d10-1b423b939719", "ตุ๊กตา", "แปลงสีฟัน", "เตารีด", "แม่"},
            {"https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/VocubHome%2Fh5.gif?alt=media&token=f76adb59-7161-4ad5-9a3d-fd7fbf4c4b51", "มีด", "แปลงสีฟัน", "โทรศัพท์", "เครื่องปรับอากาศ"},
            {"https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/VocubHome%2Fh6.gif?alt=media&token=d453ff48-a49b-4a24-9871-0d073f94b33f", "สบู่", "Havana", "ช้อน", "เครื่องปรับอากาศ"},
            {"https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/VocubHome%2Fh7.gif?alt=media&token=d6ddf0e2-16f1-40d0-b814-e13fc7cb1869", "แปลงสีฟัน", "สบู่", "กุญแจ", "เครื่องปรับอากาศ"},
            {"https://firebasestorage.googleapis.com/v0/b/myapp-8eb1f.appspot.com/o/Vocab%2Fair.gif?alt=media&token=9f691b44-b123-419d-8bbf-02b3aa60706c", "เครื่องปรับอากาศ", "พัดลม", "กุญแจ", "แม่"},
            {"https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/VocubHome%2Fair.gif?alt=media&token=0d9e719b-46c0-4619-87f4-f6881ada6661", "ประตู", "เตารีด", "โทรศัพท์", "หน้าต่าง"},
            {"https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/VocubHome%2Fhome.gif?alt=media&token=1096270b-0558-4254-9ecf-798f9b9a85c7", "บ้าน", "ตุ๊กตา", "กุญแจ", "มีด"},
            {"https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/VocubHome%2Fdoor.gif?alt=media&token=bb0a898d-792e-4cfa-9a60-f8ff7adb2b3e", "ประตู", "แปลงสีฟัน", "เตารีด", "แม่"},
            {"https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/VocubHome%2Fspoon.gif?alt=media&token=01210eb7-8f12-4da6-9345-b92a18c54db9", "ช้อน", "กุญแจ", "ตุ๊กตา", "สบู่"},
            {"https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/VocubHome%2Fwindown.gif?alt=media&token=3414e6be-8606-41da-b901-253814341ab4", "หน้าต่าง", "พ่อ", "จาน", "สบู่"},
            {"https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/VocubHome%2Ftv.gif?alt=media&token=22d0a522-db33-4aa4-b346-1e696a889ba2", "โทรทัศน์", "โทรศัพท์", "แปรงสีฟัน", "พัดลม"},
            {"https://firebasestorage.googleapis.com/v0/b/signlanguageforcommunication.appspot.com/o/VocubHome%2Fmom.gif?alt=media&token=2885b043-1a5e-41d2-93b4-564795c00f1a", "แม่", "หม้อ", "เตียงนอน", "ตู้เสื้อผ้า"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_quiz_lv5);

        countLabel = (TextView)findViewById(R.id.countLabel);
        questionLabel = (GifImageView)findViewById(R.id.questionLabel);
        answerBtn1 = (Button)findViewById(R.id.answerBtn1);
        answerBtn2 = (Button)findViewById(R.id.answerBtn2);
        answerBtn3 = (Button)findViewById(R.id.answerBtn3);
        answerBtn4 = (Button)findViewById(R.id.answerBtn4);



        //int quizCategory = getIntent().getIntExtr0a("QUIZ_CATEGORY",0);

        //Log.v("CARTEGORY_TAG",quizCategory + "");

        for (int i =0; i< quizData.length;i++){
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]);
            tmpArray.add(quizData[i][1]);
            tmpArray.add(quizData[i][2]);
            tmpArray.add(quizData[i][3]);
            tmpArray.add(quizData[i][4]);

            quizArray.add(tmpArray);
        }

        showNextQuiz();
    }

    public void showNextQuiz(){
        countLabel.setText(questionCount+" / 13");

        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        ArrayList<String> quiz = quizArray.get(randomNum);

        Glide.with(this).load(quiz.get(0))
                .into(questionLabel);

        rightAnswer = quiz.get(1);

        quiz.remove(0);
        Collections.shuffle(quiz);

        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        quizArray.remove(randomNum);
    }

    public void checkAnswer(View view){

        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if (btnText.equals(rightAnswer)){
            alertTitle = "ถูกต้อง!";
            rightAnswerCount++;
        } else {
            alertTitle = "ผิด...";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("คำตอบที่ถูก : " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (questionCount == QUIZ_COUNT){
                    Intent intent = new Intent(getApplicationContext(),HomeLv2ResultActivity.class);
                    intent.putExtra("RIGHT_ANSWER_COUNT",rightAnswerCount);
                    startActivity(intent);

                }else {
                    questionCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}
