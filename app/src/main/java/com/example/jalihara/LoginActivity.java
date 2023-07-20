package com.example.jalihara;

import androidx.appcompat.app.AppCompatActivity;
import com.example.jalihara.databinding.ActivityLoginBinding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });

        binding.usernameEdit.setHint("Enter your username");
        binding.passwordEdit.setHint("Enter your password");

        binding.usernameEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        binding.passwordEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });



    }

    public void validation(){
        //get username
        String username = binding.usernameEdit.getText().toString();
        String password = binding.passwordEdit.getText().toString();
        if(username.length() <= 5){
            binding.usernameLayout.setError("Username must be longer than 5 characters");
        }
        else{
            binding.usernameLayout.setError(null);
            binding.usernameLayout.setErrorEnabled(false);
        }
        if(password.length() <= 8){
            binding.passwordLayout.setError("Password must be longer than 8 characters");
        }
        else{
            binding.passwordLayout.setError(null);
            binding.passwordLayout.setErrorEnabled(false);
        }

        if(username.length() > 5 && password.length() > 8){
            binding.usernameLayout.setErrorEnabled(false);
            binding.passwordLayout.setErrorEnabled(false);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        }
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}