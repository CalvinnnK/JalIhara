package com.example.jalihara;

import androidx.appcompat.app.AppCompatActivity;
import com.example.jalihara.databinding.ActivityLoginBinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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


    }

    public void validation(){
        //get username
        String username = binding.usernameEdit.getText().toString();
        String password = binding.passwordEdit.getText().toString();
        if(username.length() <= 5){
            binding.usernameLayout.setError("Username must be longer than 5 characters");
        }

        if(password.length() <= 8){
            binding.passwordLayout.setError("Password must be longer than 8 characters");
        }

        if(username.length() > 5 && password.length() > 8){
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);

        }


    }

}