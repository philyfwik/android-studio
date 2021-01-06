package com.example.proj4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.net.Inet4Address;

public class payment extends AppCompatActivity {

    private Button pay;
    private ImageButton paypal;
    private Double total;
    private RadioGroup radioGroup;
    private RadioButton selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        total = getIntent().getExtras().getDouble("total");

        paypal = (ImageButton)findViewById(R.id.paypal);
        paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPayPal();
            }
        });

        radioGroup = (RadioGroup)findViewById(R.id.cards) ;

        pay = (Button)findViewById(R.id.pay);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = findViewById(radioGroup.getCheckedRadioButtonId());
                if(selected == null)
                    invCard();
                else
                    Pay(total);
            }
        });
    }

    public void backToCart(View view){
        finish();
    }

    public void openPayPal(){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/ca/signin"));
        startActivity(intent);
    }

    public void addCard(View view){
        Intent intent = new Intent(this, NewCard.class);
        startActivity(intent);
    }

    public void invCard(){
        Toast.makeText(this, "select a card", Toast.LENGTH_LONG).show();
    }

    public void Pay(Double total){

    }
}
