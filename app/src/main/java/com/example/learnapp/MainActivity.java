package com.example.learnapp;



import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox courseJava, coursePython, courseKotlin;
    private RadioGroup radioGroup;
    private RadioButton selectedCourseType;
    private SeekBar courseDuration;
    private RatingBar ratingBar;
    private Switch switchNotification;
    private TextView displaySelections;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        courseJava = findViewById(R.id.courseJava);
        coursePython = findViewById(R.id.coursePython);
        courseKotlin = findViewById(R.id.courseKotlin);
        radioGroup = findViewById(R.id.radioGroup);
        courseDuration = findViewById(R.id.courseDuration);
        ratingBar = findViewById(R.id.ratingBar);
        switchNotification = findViewById(R.id.switchNotification);
        displaySelections = findViewById(R.id.displaySelections);
        submitBtn = findViewById(R.id.submitBtn);

        // Set OnClickListener for the Submit Button
        submitBtn.setOnClickListener(view -> {
            StringBuilder selectedCourses = new StringBuilder("Selected Courses: ");
            if (courseJava.isChecked()) selectedCourses.append("Java ");
            if (coursePython.isChecked()) selectedCourses.append("Python ");
            if (courseKotlin.isChecked()) selectedCourses.append("Kotlin ");

            // Get selected course type
            int selectedId = radioGroup.getCheckedRadioButtonId();
            selectedCourseType = findViewById(selectedId);

            // Get course duration
            int duration = courseDuration.getProgress();

            // Get rating
            float rating = ratingBar.getRating();

            // Get notification status
            boolean notificationsEnabled = switchNotification.isChecked();

            // Display selections
            displaySelections.setText(
                    selectedCourses + "\nCourse Type: " + selectedCourseType.getText() +
                            "\nDuration: " + duration + " weeks" +
                            "\nRating: " + rating + " stars" +
                            "\nNotifications: " + (notificationsEnabled ? "Enabled" : "Disabled")
            );
            displaySelections.setVisibility(TextView.VISIBLE);

            // Show a Toast as confirmation
            Toast.makeText(MainActivity.this, "Registration Submitted!", Toast.LENGTH_SHORT).show();
        });
    }
}