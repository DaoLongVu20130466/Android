package com.project.android.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.android.R;
import com.project.android.model.Account;
// LoginActivity.java

public class LoginActivity extends AppCompatActivity {

    Account account ;
    private EditText etUsername, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acctivity_login);

        etUsername = findViewById(R.id.usename);
        etPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account = new Account();
                String username = etUsername.getText().toString();
                Toast.makeText(LoginActivity.this, username, Toast.LENGTH_SHORT).show();
                String password = etPassword.getText().toString();
                DatabaseReference database = FirebaseDatabase.getInstance("https://quanlyquancom-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Account");
                database.child("User").child(username).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Account user= snapshot.getValue(Account.class);
                        Toast.makeText(LoginActivity.this, user.getPassword(), Toast.LENGTH_SHORT).show();
//                        account.setPassword( snapshot.child("password").getValue().toString());
                        methodToProcess( user);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

//                Toast.makeText(LoginActivity.this, account.getPassword(), Toast.LENGTH_SHORT).show();
                // Kiểm tra tên đăng nhập và mật khẩu
//                if (account!=null) {
//                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công,"+account.getPassword(), Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(LoginActivity.this, account.getPassword(), Toast.LENGTH_SHORT).show();
//                }
            }
        });

    }
    public void methodToProcess(Account a){
        this.account = a;
        Toast.makeText(LoginActivity.this, account.getEmail(), Toast.LENGTH_SHORT).show();
    }
}
