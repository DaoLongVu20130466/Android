package com.project.android.controller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.android.model.Oder;
import com.project.android.model.Product;

import java.util.ArrayList;

public class ProductControl {
    public ProductControl() {
        getProduct();
    }

    ArrayList<Product> list;
    public void SaveProduct(Product product){
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://quanlyquancom-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("Product");
        myRef.child("Product").child(product.getId()).setValue(product);
    }
    public void getProduct(){
        ArrayList<Product> list = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://quanlyquancom-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("Product");
        myRef.child("Product").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        this.list = list;
    }
    public void saveallChange(){
        for (Product e: this.list
             ) {
            this.SaveProduct(e);
        }
    }
}
