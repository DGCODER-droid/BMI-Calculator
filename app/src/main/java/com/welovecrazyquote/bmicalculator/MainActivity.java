package com.welovecrazyquote.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //Class variables are also called "Fields"
    private TextView resultText;
    private Button calculate;
    private RadioButton male;
    private RadioButton female;
    private EditText age;
    private EditText feet;
    private EditText inches;
    private EditText weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        findViews();

        setupButtonClickListener();
        String alertText = "This is my variable text";
        Toast.makeText(this, alertText, Toast.LENGTH_LONG).show();
    }

    private void findViews() {
        resultText = findViewById(R.id.text_view_result);
        resultText.setText("This is the updated text");
        male = findViewById(R.id.radio_button_male);
        female = findViewById(R.id.radio_button_female);
        age = findViewById(R.id.edit_text_age);
        feet = findViewById(R.id.edit_text_feet);
        inches = findViewById(R.id.edit_text_inches);
        weight = findViewById(R.id.edittext_weight);
        calculate = findViewById(R.id.button_calculate);
    }

    private void setupButtonClickListener() {
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatebmi();
            }
        });
    }

    private void calculatebmi() {
        String ageText = age.getText().toString();
        String feetText = feet.getText().toString();
        String inchesText = inches.getText().toString();
        String weightText = weight.getText().toString();
        int age = Integer.parseInt(ageText);
        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);
        int totalInches  = (feet * 12) + inches;

        //Height in meters is the inches multiplied by 0.0254
        double heightInMeters = totalInches * 0.0254;

        //BMI formula = weight in kg divided by height in meters squared
        double bmi = weight / (heightInMeters * heightInMeters);

        // We must convert the decimal / double into a String for our TextView
        String bmiTextResult = String.valueOf(bmi);
        resultText.setText(bmiTextResult);
    }
}