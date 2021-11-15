package com.brunorm.ar_pdm;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class PersonalInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        String[] genders = {"Masculino", "Feminino", "Outro"};
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.inputPersonalInfoGender);
        for (int i = 0; i < 3; i++) {
            String gender = genders[i];
            RadioButton button = new RadioButton(this);
            button.setText(gender);
            button.setId(i);

            radioGroup.addView(button);
        }
        radioGroup.setOrientation(LinearLayout.HORIZONTAL);
    }
}