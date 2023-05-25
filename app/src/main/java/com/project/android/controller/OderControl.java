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

public class OderControl {
    public OderControl() {
        getProduct();
    }

    ArrayList<Oder> list;
    public void SaveOder(Oder Oder){
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://quanlyquancom-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("Product");
        myRef.child("Product").child(Oder.getId()).setValue(Oder);

    }
    public void getProduct(){
        ArrayList<Oder> list = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://quanlyquancom-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("Oder");
        myRef.child("Oder").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Oder rs = snapshot.getValue(Oder.class);
                list.add(rs);
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
        for (Oder e: this.list
        ) {
            this.SaveOder(e);
        }
    }
}