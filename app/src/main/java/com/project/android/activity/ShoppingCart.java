package com.project.android.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import com.project.android.R;

public class ShoppingCart extends AppCompatActivity {
     TextView giohangtrong, tongtien;
     Toolbar toolbar;
     RecyclerView recyclerView;
     Button btnmuahang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        initView();
    }
    private void initView(){
        giohangtrong = findViewById(R.id.txtgiohangtrong);
        tongtien = findViewById(R.id.txttongtien);
        toolbar = findViewById(R.id.toolbar);
        recyclerView= findViewById(R.id.recyclerViewgiohang);
        btnmuahang = findViewById(R.id.btnmuahang);

    }
}