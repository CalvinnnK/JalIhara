package com.example.jalihara.ui.tickets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jalihara.R;
import com.example.jalihara.databinding.FragmentTicketsBinding;
import com.example.jalihara.ui.Performance;
import com.example.jalihara.ui.SpacingItem;

import java.util.ArrayList;
import java.util.Arrays;

public class TicketsFragment extends Fragment {

    private FragmentTicketsBinding binding;
    ArrayList<Performance> performances = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTicketsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        performances.add(new Performance("Kecak & Fire Dance Show","April 23, 2023, 05:00 - 06:00 PM", 67000, "Desc", R.drawable.kecak_fire_dance));
        performances.add(new Performance("Barong Dance Show","May 12, 2023, 07:30 - 09:00 PM", 50000, "Desc", R.drawable.rindukubalitours));
        performances.add(new Performance("The Amazing Devdan Show","June 4, 2023, 07:30 - 09:00 PM", 250000, "Desc", R.drawable.devdan));
        performances.add(new Performance("Wayang Lemah Show","July 29, 2023, 08:00 - 10:00 PM", 35000, "Desc", R.drawable.wayang_lemah));
        performances.add(new Performance("Legong Dance Show","August 5, 2023, 06:00 - 08:00 PM", 120000, "Desc", R.drawable.legong_dance));

        RecyclerView recyclerView = (RecyclerView) binding.ticketRV;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        TicketAdapter adapter = new TicketAdapter(getActivity(), performances);
        recyclerView.setAdapter(adapter);

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.card_spacing);
        SpacingItem spacingItemDecoration = new SpacingItem(spacingInPixels);
        recyclerView.addItemDecoration(spacingItemDecoration);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}