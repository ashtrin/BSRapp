package com.example.bsrapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class InsuranceApplication extends AppCompatActivity {

    RadioGroup radiog;
    RadioButton radioB;
    EditText credit;
    EditText property;
    Button aply;
    Button exittt;
    String insurancetype,creditscore,propertyval;

    public static final String SHARED_PREFS ="sharedprefs";
    public static final String INS ="ins";
    public static final String CRD ="crd";
    public static final String VAL ="val";






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance_application);

        radiog = findViewById(R.id.radioGroup);
        credit = findViewById(R.id.editTextCredit);
        property = findViewById(R.id.editTextvalue);
        aply = findViewById(R.id.buttonapply);
        exittt = findViewById(R.id.exitins);



        exittt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsuranceApplication.this,MainActivity.class);
                startActivity(intent);
            }
        });


        aply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioID = radiog.getCheckedRadioButtonId();
                radioB = findViewById(radioID);
                insurancetype = radioB.getText().toString();
                creditscore = credit.getText().toString();
                propertyval = property.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(INS,insurancetype);
                editor.putString(CRD,creditscore);
                editor.putString(VAL,propertyval);

                editor.commit();

                Toast.makeText(InsuranceApplication.this,"Application sent",Toast.LENGTH_LONG).show();






            }
        });



    }


    public void checkButton(View v){
        int radioID = radiog.getCheckedRadioButtonId();
        radioB = findViewById(radioID);

    }
}


