package com.example.bsrapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserPage extends AppCompatActivity {


    private  Button Bid;
    private  EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);

        Button Bid = (Button) findViewById(R.id.button_bid);
        EditText id = (EditText) findViewById(R.id.textID) ;


        Bid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(id.getText().toString());

            }
        });


    }

    private void validate(String bussid){


        int b =Integer.parseInt(bussid);

        if(b < 7){
            Intent intent = new Intent(UserPage.this,LoanApplication.class);
            startActivity(intent);

        }
        else
            if (b >= 7){
            Intent intent = new Intent(UserPage.this,InsuranceApplication.class);
            startActivity(intent);
            }
         //   else{

         //   }


    }


}