package com.project.android.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.project.android.R;
import com.project.android.controller.AccountControl;
import com.project.android.model.Account;
// LoginActivity.java

public class LoginActivity extends AppCompatActivity {

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
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                AccountControl pro = new AccountControl();
                String rs= pro.getUserLogin(username);
                Account user= pro.getDirectAdminUser(username);
                // Kiểm tra tên đăng nhập và mật khẩu
                if (user.getId()!="") {
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công,"+user.getId(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, rs, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
