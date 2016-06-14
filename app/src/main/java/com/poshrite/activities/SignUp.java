package com.poshrite.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.poshrite.R;
import com.poshrite.helper.CustomTextView;

public class SignUp extends AppCompatActivity {

    CustomTextView textWhoYouAre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        textWhoYouAre = (CustomTextView) findViewById(R.id.textWhoYouAre);
        textWhoYouAre.setText(R.string.choose_who_you_are);


    }
}
