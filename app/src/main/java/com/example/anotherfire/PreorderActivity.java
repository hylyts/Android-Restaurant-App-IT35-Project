package com.example.anotherfire;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import android.os.Bundle;

public class PreorderActivity extends AppCompatActivity {

    private TextView show_cart;
    private Button button1,button2,button3;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preorder);
        reference = FirebaseDatabase.getInstance().getReference("Cart");


        show_cart = findViewById(R.id.show_cart);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID_cart = reference.push().getKey();
                HashMap<String, String> parameters = new HashMap<>();
                parameters.put("Product_Name","Apple");
                parameters.put("Price","20");
                reference.child(ID_cart).setValue(parameters);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID_cart = reference.push().getKey();
                HashMap<String, String> parameters = new HashMap<>();
                parameters.put("Product_Name","Banana");
                parameters.put("Price","25");
                reference.child(ID_cart).setValue(parameters);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ID_cart = reference.push().getKey();
                HashMap<String, String> parameters = new HashMap<>();
                parameters.put("Product_Name","Orange");
                parameters.put("Price","15");
                reference.child(ID_cart).setValue(parameters);
            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                show_cart.setText(""+ snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        show_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ShowCart.class));
            }
        });


    }
}