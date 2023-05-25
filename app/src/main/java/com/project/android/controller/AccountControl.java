package com.project.android.controller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.android.model.Account;
import com.project.android.model.Product;

import java.util.ArrayList;

public class AccountControl {
    public AccountControl() {
        getProduct();
    }

    ArrayList<Account> list;
    public void SaveProduct(Account account){
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://quanlyquancom-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("Account");
        myRef.child("Admin").child(account.getUserName()).setValue(account);
    }
    public void getProduct(){
        ArrayList<Account> list = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://quanlyquancom-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("Account");
        myRef.child("Admin").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Account rs = snapshot.getValue(Account.class);
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
        for (Account e: this.list
        ) {
            this.SaveProduct(e);
        }
    }
}
