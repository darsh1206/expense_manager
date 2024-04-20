package com.example.expensemanager;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import javax.mail.MessagingException;

public class SignUp extends AppCompatActivity {
    private Button signin;
    private Button signup;
    TextInputLayout usernameLayout;
    TextInputEditText usernameEditText;
    TextInputLayout emailLayout;
    TextInputEditText emailEditText;
    TextInputLayout passwordLayout;
    TextInputEditText passwordEditText;
    DBDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

        signin = findViewById(R.id.signin);
        signup = findViewById(R.id.signup_btn);

        // text layouts
        usernameLayout = findViewById(R.id.username_layout);
        emailLayout = findViewById(R.id.email_layout);
        passwordLayout = findViewById(R.id.password_layout);

        // text inputs
        usernameEditText = usernameLayout.findViewById(R.id.username);
        emailEditText = emailLayout.findViewById(R.id.email);
        passwordEditText = passwordLayout.findViewById(R.id.password);

        dataSource = new DBDataSource(this);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, SignIn.class);
                startActivity(intent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkErrors()){
                    Log.d("A", "Signup successful");
                    long userID = dataSource.insertUser(Objects.requireNonNull(usernameEditText.getText()).toString(), Objects.requireNonNull(emailEditText.getText()).toString(), Objects.requireNonNull(passwordEditText.getText()).toString());
                    dataSource.insertUserDetails((int) userID, "", "", "", "", "");
                    Intent intent = new Intent(SignUp.this, VerifyUser.class);
                    intent.putExtra("user_id", String.valueOf(userID));
                    startActivity(intent);
                }
                Log.d("A", "Signup failed");
            }
        });
    }

    private boolean checkErrors(){
        int errorColor = ContextCompat.getColor(this, R.color.black);
        usernameLayout.setError(null);
        emailLayout.setError(null);
        passwordLayout.setError(null);
        if(Objects.requireNonNull(usernameEditText.getText()).toString().equals("")){
            usernameLayout.setError("Username cannot be empty");
            usernameLayout.setErrorTextColor(ColorStateList.valueOf(errorColor));
            return false;
        }
        else if(Objects.requireNonNull(emailEditText.getText()).toString().equals("")){
            emailLayout.setError("Email Address cannot be empty");
            emailLayout.setErrorTextColor(ColorStateList.valueOf(errorColor));
            return false;
        }
        else if(Objects.requireNonNull(passwordEditText.getText()).toString().equals("")){
            passwordLayout.setError("Password cannot be empty");
            passwordLayout.setErrorTextColor(ColorStateList.valueOf(errorColor));
            return false;
        }
        return true;
    }

}
