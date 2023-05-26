package com.project.android.controller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.android.model.Account;
import com.project.android.model.Product;

import java.lang.ref.Reference;
import java.util.ArrayList;

public class AccountControl {
    public AccountControl() {
        getProduct();
        getUser();
    }

    ArrayList<Account> adminlist;
    ArrayList<Account> Userlist;
    public void SaveProduct(Account account) {
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://quanlyquancom-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("Account");
        myRef.child("User").child(account.getUserName()).setValue(account);
    }

    public void getProduct() {
        ArrayList<Account> list = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://quanlyquancom-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("Account");
        myRef.child("User").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Account rs = snapshot.getValue(Account.class);
                list.add(rs);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        this.Userlist = list;
    }

    public void getUser() {
        ArrayList<Account> list = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://quanlyquancom-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("Account");
        myRef.child("Admin").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Account rs = snapshot.getValue(Account.class);
                list.add(rs);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        this.adminlist = list;
    }

    public void saveallChange() {
        for (Account e : this.Userlist
        ) {
            this.SaveProduct(e);
        }

    }
    public Account getDirectAdminUser(String id) {
         Account[] rs = {};
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://quanlyquancom-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("Account");
        myRef.child("Admin").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               rs[0] = snapshot.getValue(Account.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return rs[0];
    }
}
