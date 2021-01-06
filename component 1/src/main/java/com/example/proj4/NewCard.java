package com.example.proj4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewCard extends AppCompatActivity {

    private Button confirm;
    private EditText cardName, cardAddress, cardNumber, cardCode, cardDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_card);

        cardName = (EditText)findViewById(R.id.cardName);
        cardNumber = (EditText)findViewById(R.id.cardNumber);
        cardAddress = (EditText)findViewById(R.id.cardAddress);
        cardCode = (EditText)findViewById(R.id.cardCode);
        cardDate = (EditText)findViewById(R.id.cardDate);

        confirm = (Button)findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cardName.length() == 0)
                    invName();
                else if (cardNumber.length() != 16)
                    invCard();
                else if (cardAddress.length() == 0)
                    invAddress();
                else if (cardCode.length() != 3)
                    invCode();
                else if (cardDate.length() != 8)
                    invDate();
                else
                {   Confirm(); }
            }
        });
    }

    public void invName(){
        Toast.makeText(this, "enter full Name", Toast.LENGTH_LONG).show();
    }
    public void invCard(){
        Toast.makeText(this, "enter 16 digit card number", Toast.LENGTH_LONG).show();
    }
    public void invAddress(){
        Toast.makeText(this, "enter full address", Toast.LENGTH_LONG).show();
    }
    public void invCode(){
        Toast.makeText(this, "enter 3 digit security code", Toast.LENGTH_LONG).show();
    }
    public void invDate(){
        Toast.makeText(this, "enter valid expiry date in format ddmmyyyy", Toast.LENGTH_LONG).show();
    }
    public void Confirm(){

    }
    public void Cancel(View view){
        finish();
    }
}
