package com.project.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.android.R;
import com.project.android.controller.ProductControl;
import com.project.android.model.Product;

public class MainActivity extends AppCompatActivity {
    Button check ;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check = (Button) findViewById(R.id.saveFile);
        next = (Button) findViewById(R.id.next);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product test = new Product("001","fucking comga","1",100,true,true,true,"Fucking Link",300000,20000);
                ProductControl pro = new ProductControl();
                pro.SaveProduct(test);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity3.class);
                startActivity(intent);
            }
        });

    }
}