package com.example.proj4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button checkout, cont, clear;
    private TextView subtotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner badmintonTicket = (Spinner) findViewById(R.id.badmintonTicket); // for badminton tickets
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.num, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        badmintonTicket.setAdapter(adapter);

        Spinner basketballTicket = (Spinner) findViewById(R.id.basketballTicket); // for basketball tickets
        basketballTicket.setAdapter(adapter);

        Spinner swimmingTicket = (Spinner) findViewById(R.id.swimmingTicket); // for swimming tickets
        swimmingTicket.setAdapter(adapter);

        subtotal = (TextView) findViewById(R.id.subtotal);
        checkout = (Button)findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Checkout();
            }
        });
        cont = (Button)findViewById(R.id.cont);
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContinueShopping();
            }
        });
        clear = (Button)findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClearCart();
            }
        });

    }

    public void sum(View view) {
        Spinner badmintonTicket = (Spinner) findViewById(R.id.badmintonTicket);
        Spinner basketballTicket = (Spinner) findViewById(R.id.basketballTicket);
        Spinner swimmingTicket = (Spinner) findViewById(R.id.swimmingTicket);

        double badmintonQuant = Double.parseDouble(badmintonTicket.getSelectedItem().toString());
        double basketballQuant = Double.parseDouble(basketballTicket.getSelectedItem().toString());
        double swimmingQuant = Double.parseDouble(swimmingTicket.getSelectedItem().toString());

        double sum = ((badmintonQuant * 5.0) + (basketballQuant * 7.20) + (swimmingQuant * 9.40));
        String cost = String.format("%.2f", sum);
        subtotal = (TextView) findViewById(R.id.subtotal);

        subtotal.setText("SUBTOTAL: $" + cost);
    }

    public void Checkout(){
        Spinner badmintonTicket = (Spinner) findViewById(R.id.badmintonTicket);
        Spinner basketballTicket = (Spinner) findViewById(R.id.basketballTicket);
        Spinner swimmingTicket = (Spinner) findViewById(R.id.swimmingTicket);

        double badmintonQuant = Double.parseDouble(badmintonTicket.getSelectedItem().toString());
        double basketballQuant = Double.parseDouble(basketballTicket.getSelectedItem().toString());
        double swimmingQuant = Double.parseDouble(swimmingTicket.getSelectedItem().toString());

        double total = ((badmintonQuant * 5.05) + (basketballQuant * 7.25) + (swimmingQuant * 9.40));

        Intent intent = new Intent(this, payment.class);
        intent.putExtra("total", total);
        startActivity(intent);
    }

    public void ClearCart(){

    }

    public void ContinueShopping(){

    }
}
