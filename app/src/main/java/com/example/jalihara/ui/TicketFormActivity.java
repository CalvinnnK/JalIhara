package com.example.jalihara.ui;

import static com.google.android.material.internal.ViewUtils.hideKeyboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
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

        binding.usernameEdit.setHint("Enter your name");
        binding.qtyEdit.setHint("Enter the quantity");

        binding.usernameEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        binding.qtyEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });




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

        String desc = "One more step to enjoy your " + ticket_title + " performance, please fill below form";


        SpannableString desc1 = new SpannableString(desc);

        // Find the starting and ending indexes of the ticket_title in the text
        int startIndex = desc.indexOf(ticket_title);
        int endIndex = startIndex + ticket_title.length();

        // Set the color for the ticket_title part
        int desiredColor = Color.parseColor("#0056E0");
        desc1.setSpan(new ForegroundColorSpan(desiredColor), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        binding.ticketFillForm.setText(desc1);

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

        int desiredColor = Color.parseColor("#0056E0");

        if(username.length() == 0){
            binding.usernameLayout.setError("Name cannot be empty");
        }
        else {
            binding.usernameLayout.setErrorEnabled(false);
        }
        if(intQty<=0) {
            binding.qtyLayout.setError("Input a valid number");
        }
        else{
            binding.qtyLayout.setErrorEnabled(false);
        }
        if(binding.radioGroup.getCheckedRadioButtonId()==-1) {
            binding.radioError.setText("Please select booth type");
        }
        else{
            binding.radioError.setText("");
        }
        if(username.length()>0 && intQty>0 && binding.radioGroup.getCheckedRadioButtonId()!=-1){
            binding.usernameLayout.setErrorEnabled(false);
            binding.qtyLayout.setErrorEnabled(false);
            binding.radioError.setText("");

            Intent move = new Intent(this, MainActivity.class);
            builder.setMessage("Thank you for your order " + username +"!")
                    .setCancelable(false)
                    .setPositiveButton("Back to Home", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getApplicationContext(),"redirecting to home", Toast.LENGTH_SHORT).show();
                            startActivity(move);
                            finish();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.setTitle("Purchase Success");
            alert.show();
            Button pbutton = alert.getButton(DialogInterface.BUTTON_POSITIVE);
            pbutton.setTextColor(desiredColor);
        }
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}