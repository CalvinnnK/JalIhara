package com.example.jalihara.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.jalihara.R;
import com.example.jalihara.databinding.ActivityTicketFormBinding;

public class TicketFormActivity extends AppCompatActivity {

    private ActivityTicketFormBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTicketFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
            finish();
        }

    }


}