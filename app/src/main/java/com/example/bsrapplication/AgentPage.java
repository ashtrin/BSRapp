package com.example.bsrapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgentPage extends AppCompatActivity {

    Button sho;
    Button rej;
    Button exit;
    Button accept;
    EditText typp;
    EditText crdscore;
    EditText vall;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_page);

        sho = findViewById(R.id.buttonsho);
        rej = findViewById(R.id.breject);
        accept= findViewById(R.id.bapply);
        typp = findViewById(R.id.texttype);
        crdscore = findViewById(R.id.textCrd);
        vall = findViewById(R.id.textval);
        exit = findViewById(R.id.buttonexit);


        sho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("sharedprefs",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String type = sharedPreferences.getString("ins","Type not found");
                String credit = sharedPreferences.getString("crd","NO CREDIT");
                String value = sharedPreferences.getString("val","NO PROPERTY");

                typp.setText("TYPE      "+type);
                crdscore.setText("CREDIT SCORE :"+credit);
                vall.setText("PROPERTY VAL :"+value);
                editor.commit();
                Toast.makeText(AgentPage.this,"DONE",Toast.LENGTH_LONG).show();


            }

        });


        rej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AgentPage.this,"REJECTED",Toast.LENGTH_SHORT).show();


            }
        });


        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AgentPage.this,"ACCEPTED",Toast.LENGTH_SHORT).show();


            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgentPage.this,MainActivity.class);
                startActivity(intent);
            }
        });




    }
}