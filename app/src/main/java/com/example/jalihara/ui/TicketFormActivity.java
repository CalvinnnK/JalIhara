package com.example.jalihara.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.jalihara.MainActivity;
import com.example.jalihara.R;
import com.example.jalihara.databinding.ActivityTicketFormBinding;
import com.example.jalihara.ui.home.HomeFragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class TicketFormActivity extends AppCompatActivity {

    private ActivityTicketFormBinding binding;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTicketFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        builder = new AlertDialog.Builder(this);

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        String ticket_title =  getIntent().getStringExtra("ticketTitle");
        int ticket_image =  getIntent().getIntExtra("ticketImage",0);
        String ticket_date =  getIntent().getStringExtra("ticketDate");
        String ticket_desc = getIntent().getStringExtra("ticketDesc");


        binding.ticketTitle.setText(ticket_title);
        binding.ticketDesc.setText(ticket_desc);
        binding.ticketImage.setImageResource(ticket_image);
        binding.ticketFillForm.setText("One more step to enjoy your " + ticket_title + " performance, please fill below form");

        RadioGroup radioGroup = binding.radioGroup;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Get the selected RadioButton
                RadioButton selectedRadioButton = findViewById(checkedId);

                // Get the text of the selected RadioButton
                String selectedText = selectedRadioButton.getText().toString();

            }
        });

        binding.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }

        });

    }

    private void validation(){
        String username = binding.usernameEdit.getText().toString();
        String qty = binding.qtyEdit.getText().toString();
        if(qty.isEmpty()){qty = "0";}
        Integer intQty = Integer.valueOf(qty);


        if(username.length() <= 5){
            binding.usernameLayout.setError("Username must be longer than 5 characters");
        }
        else if(intQty<=0) {
            binding.qtyLayout.setError("Input a valid number");
        }
        else if(binding.radioGroup.getCheckedRadioButtonId()==-1) {
            binding.radioError.setText("Please select booth type");
        }
        else{
            Intent move = new Intent(this, MainActivity.class);
            builder.setMessage("Thank you for your order " + username)
                    .setCancelable(false)
                    .setPositiveButton("Back to Home", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(),"redirecting to home", Toast.LENGTH_SHORT).show();
                            startActivity(move);
                            finish();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.setTitle("Purchase Success");
            alert.show();
        }
    }


}