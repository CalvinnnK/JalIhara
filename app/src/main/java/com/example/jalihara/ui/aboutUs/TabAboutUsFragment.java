package com.example.jalihara.ui.aboutUs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jalihara.R;
import com.example.jalihara.databinding.FragmentTabAboutUsBinding;

public class TabAboutUsFragment extends Fragment {

    private com.example.jalihara.databinding.FragmentTabAboutUsBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTabAboutUsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        binding.abousUsText.setText("JalIhara is a user-friendly mobile app that brings the world of art performances to your fingertips. Our app allows you to easily browse and choose from a wide range of art performances, so you can find the perfect event that matches your interests. Whether you're into music, theater, dance, or any other form of art, JalIhara has got you covered. With a simple and intuitive interface, purchasing your favorite art performance tickets has never been easier. So why wait? Download JalIhara today and experience the joy of art performances like never before.");

        return root;
    }
}