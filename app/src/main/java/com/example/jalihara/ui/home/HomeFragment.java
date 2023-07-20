package com.example.jalihara.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.jalihara.R;
import com.example.jalihara.databinding.FragmentHomeBinding;
import com.smarteist.autoimageslider.SliderView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        String username = getActivity().getIntent().getStringExtra("username");
        final TextView textView = binding.textHome;
        textView.setText("Welcome, " + username);

        SliderView sliderView = binding.slider;

        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();
        sliderDataArrayList.add(new SliderData(R.drawable.carousel_1));
        sliderDataArrayList.add(new SliderData(R.drawable.carousel_2));
        sliderDataArrayList.add(new SliderData(R.drawable.carousel_3));

        SliderAdapter adapter = new SliderAdapter(requireContext(), sliderDataArrayList);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

        binding.homeGridLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_home_to_nav_tickets);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}