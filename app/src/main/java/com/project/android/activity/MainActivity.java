package com.project.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.android.R;
import com.project.android.controller.AccountControl;
import com.project.android.controller.ProductControl;
import com.project.android.model.Account;
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
                Account test = new Account("001","123456","daolongvu01","daolongvu86@gmail.com","0985034347","https://firebasestorage.googleapis.com/v0/b/quanlyquancom.appspot.com/o/DefaultAvt.jpg?alt=media&token=364830d8-0c46-4353-995f-ff3e3d6c6c1d","Daolongvu");
                AccountControl pro = new AccountControl();
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