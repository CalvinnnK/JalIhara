package com.example.jalihara.ui.aboutUs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jalihara.R;
import com.example.jalihara.databinding.FragmentTabContactUsBinding;


public class TabContactUsFragment extends Fragment {

    private com.example.jalihara.databinding.FragmentTabContactUsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTabContactUsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.contactUsText.setText("If you have any questions or feedback about JalIhara,we would love to hear from you. You can reach out to our customer support team by sending an email to support@jalihara.com or by filling out the contact form on our website jalihara.com. Our team is dedicated to providing you with the best possible experience, so please don't hesitate to get in touch if you need any assistance. You can also follow us on social media to stay up-to-date on the latest news and events. Thank you for choosing JalIhara, and we look forward to serving you.");

        // Inflate the layout for this fragment
        return root;
    }
}