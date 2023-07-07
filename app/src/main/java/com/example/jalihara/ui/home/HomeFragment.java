package com.example.jalihara.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.fragment.app.Fragment;

import com.example.jalihara.R;
import com.example.jalihara.databinding.FragmentHomeBinding;
import com.smarteist.autoimageslider.SliderView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        String username = getActivity().getIntent().getStringExtra("username");
        final TextView textView = binding.textHome;
        textView.setText("Welcome, " + username);

        SliderView sliderView = binding.slider;
        sliderDataArrayList.add(new SliderData(R.drawable.carousel_1));
        sliderDataArrayList.add(new SliderData(R.drawable.carousel_2));
        sliderDataArrayList.add(new SliderData(R.drawable.carousel_3));
        SliderAdapter adapter = new SliderAdapter(requireContext(), sliderDataArrayList);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}