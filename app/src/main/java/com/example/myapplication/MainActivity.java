package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn, option2Btn, option3Btn, option4Btn;
    private ArrayList<QuizModal> quizModalArrayList;
    Random random;
        int currentScore = 0, questionAttempted = 1, currentPos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTV = findViewById(R.id.idTVQuestion);
        questionNumberTV = findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        random = new Random();
        quizModalArrayList = new ArrayList<>();
        getQuizQuestion(quizModalArrayList);
        currentPos = random.nextInt(quizModalArrayList.size());
        setDataToViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase(Locale.ROOT))) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
                }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase(Locale.ROOT))) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase(Locale.ROOT))) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase(Locale.ROOT))) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });
    }

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTvScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is\n"+currentScore + "/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizModalArrayList.size());
                questionAttempted = 1;
                currentScore = 0;
                setDataToViews(currentPos);
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
    private void setDataToViews(int currentPos){
        questionNumberTV.setText("Questions Attempted: "+questionAttempted + "/10");
        if(questionAttempted == 10){
            showBottomSheet();
        }
        else{
            questionTV.setText(quizModalArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModalArrayList.get(currentPos).getQuestion1());
            option2Btn.setText(quizModalArrayList.get(currentPos).getQuestion2());
            option3Btn.setText(quizModalArrayList.get(currentPos).getQuestion3());
            option4Btn.setText(quizModalArrayList.get(currentPos).getQuestion4());
        }

    }
    private void getQuizQuestion(ArrayList<QuizModal> quizModalArrayList) {
        quizModalArrayList.add(new QuizModal("What is Android Studio?", "A game engine", "An IDE for Android development", "A video editor", "A web server", "An IDE for Android development"));
        quizModalArrayList.add(new QuizModal("What is an Activity in Android?", "A background task", "A UI screen in an app", "An event listener", "A database object", "A UI screen in an app"));
        quizModalArrayList.add(new QuizModal("Which language is primarily used in Android development?", "Python", "C++", "Java/Kotlin", "Ruby", "Java/Kotlin"));
        quizModalArrayList.add(new QuizModal("What is an Intent in Android?", "A way to start an Activity or Service", "A data model", "An API", "A debugging tool", "A way to start an Activity or Service"));
        quizModalArrayList.add(new QuizModal("What is a Fragment in Android?", "A part of an Activity's UI", "A type of Intent", "A database model", "A thread", "A part of an Activity's UI"));
        quizModalArrayList.add(new QuizModal("What is the purpose of Gradle in Android Studio?", "Building and managing app dependencies", "Designing UI", "Testing code", "Debugging apps", "Building and managing app dependencies"));
        quizModalArrayList.add(new QuizModal("What is the use of 'RecyclerView' in Android?", "Displaying long lists efficiently", "Managing threads", "Connecting to APIs", "Handling background tasks", "Displaying long lists efficiently"));
        quizModalArrayList.add(new QuizModal("What is a 'Service' in Android?", "A task that runs in the background", "An Activity", "A database", "A UI element", "A task that runs in the background"));
        quizModalArrayList.add(new QuizModal("Which file specifies the permissions an app needs?", "MainActivity.java", "build.gradle", "AndroidManifest.xml", "styles.xml", "AndroidManifest.xml"));
        quizModalArrayList.add(new QuizModal("What is Logcat used for in Android Studio?", "Creating layouts", "Viewing logs and debugging", "Testing APIs", "Managing dependencies", "Viewing logs and debugging"));
        quizModalArrayList.add(new QuizModal("Which method is used to start a new Activity?", "onCreate()", "startActivity()", "onPause()", "onDestroy()", "startActivity()"));
        quizModalArrayList.add(new QuizModal("What does 'dp' stand for in Android UI design?", "Device Pixels", "Density-independent Pixels", "Display Pixels", "Dependent Pixels", "Density-independent Pixels"));
        quizModalArrayList.add(new QuizModal("What is the purpose of the 'onCreate()' method in an Activity?", "To create a database", "To initialize the Activity", "To start a Service", "To start a Fragment", "To initialize the Activity"));
        quizModalArrayList.add(new QuizModal("What is the role of the 'XML' files in Android?", "Writing logic code", "Defining layouts and resources", "Connecting to APIs", "Testing applications", "Defining layouts and resources"));
        quizModalArrayList.add(new QuizModal("What is a 'View' in Android?", "A background task", "A UI element", "A database model", "A type of Intent", "A UI element"));
        quizModalArrayList.add(new QuizModal("What is the role of the AndroidManifest.xml file?", "Defines app components", "Manages app resources", "Stores user data", "Contains code logic", "Defines app components"));
        quizModalArrayList.add(new QuizModal("What is the use of 'ViewModel' in Android Architecture Components?", "To handle user inputs", "To manage UI-related data", "To render layouts", "To fetch data from APIs", "To manage UI-related data"));
        quizModalArrayList.add(new QuizModal("What is the default database used in Android?", "PostgreSQL", "MySQL", "SQLite", "MongoDB", "SQLite"));
        quizModalArrayList.add(new QuizModal("Which method is used to save app preferences?", "SharedPreferences", "Room Database", "Files", "Services", "SharedPreferences"));
        quizModalArrayList.add(new QuizModal("What is the main purpose of ProGuard in Android?", "To improve app performance", "To reduce app size", "To obfuscate code and optimize APK", "To debug the app", "To obfuscate code and optimize APK"));
    }
}


