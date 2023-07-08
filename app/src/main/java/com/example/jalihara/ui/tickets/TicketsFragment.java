package com.example.jalihara.ui.tickets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jalihara.R;
import com.example.jalihara.databinding.FragmentTicketsBinding;
import com.example.jalihara.ui.Performance;
import com.example.jalihara.ui.SpacingItem;

import java.util.ArrayList;

public class TicketsFragment extends Fragment {

    private FragmentTicketsBinding binding;
    ArrayList<Performance> performances = new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTicketsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        performances.add(new Performance("Kecak & Fire Dance Show","April 23, 2023, 05:00 - 06:00 PM", 67000, "Kecak and Fire Dance is a traditional Balinese performance that combines chanting, dance, and storytelling. The show features a large group of male performers chanting in rhythmic patterns to depict the Ramayana epic, while a dancer in a trance-like state performs barefoot on burning coconut husks, symbolizing the victory of good over evil. This captivating spectacle, set in an outdoor amphitheater or temple courtyard, creates a mesmerizing experience with its vibrant music, dynamic choreography, and the mystical element of fire.", R.drawable.kecak_fire_dance));
        performances.add(new Performance("Barong Dance Show","May 12, 2023, 07:30 - 09:00 PM", 50000, "The Barong Dance is a traditional Balinese performance that showcases a mythical battle between the forces of good and evil. It is a captivating spectacle where performers don elaborate costumes, with the Barong representing the benevolent spirit and the Rangda symbolizing the evil witch. The dancers skillfully bring these characters to life through intricate movements and dramatic storytelling. The show is accompanied by traditional music and chanting, creating a vibrant and immersive experience for the audience. The Barong Dance is not only a form of entertainment but also carries deep cultural and spiritual significance, reflecting the ongoing struggle between good and evil in Balinese mythology.", R.drawable.rindukubalitours));
        performances.add(new Performance("The Amazing Devdan Show","June 4, 2023, 07:30 - 09:00 PM", 250000, "The Amazing Devdan Show is a spectacular performance that takes audiences on a journey through the diverse cultures of Indonesia. This breathtaking show combines traditional dances, acrobatics, aerial stunts, and dazzling visual effects to showcase the rich heritage of the archipelago. From the graceful movements of Balinese dancers to the fiery warrior dances of Sumatra and the enchanting rituals of Papua, the show seamlessly weaves together a tapestry of Indonesian culture. With vibrant costumes, vibrant music, and awe-inspiring choreography, the Amazing Devdan Show offers a mesmerizing experience that celebrates the beauty and diversity of Indonesia's traditions and artistic expressions.", R.drawable.devdanticket));
        performances.add(new Performance("Wayang Lemah Show","July 29, 2023, 08:00 - 10:00 PM", 35000, "The Wayang Lemah show is a captivating traditional Javanese puppet performance that brings ancient stories to life through intricately crafted puppets and masterful storytelling. This unique form of shadow puppetry showcases a fusion of music, drama, and visual artistry. Skilled puppeteers skillfully manipulate the intricately designed leather puppets behind a backlit screen, creating mesmerizing shadow projections that portray legendary tales from Javanese folklore, mythology, and epic narratives such as the Mahabharata and Ramayana. Accompanied by a traditional Gamelan orchestra, the Wayang Lemah show transports the audience into a world of enchantment and cultural richness, where they witness the artistry and enduring charm of this traditional Indonesian art form.", R.drawable.wayang_lemah));
        performances.add(new Performance("Legong Dance Show","August 5, 2023, 06:00 - 08:00 PM", 120000, "The Legong Dance show is a captivating and graceful Balinese dance performance that showcases the beauty and precision of traditional Balinese dance. Featuring young female dancers, the Legong Dance is characterized by intricate hand movements, delicate footwork, and intricate facial expressions. The dancers wear ornate costumes and headdresses, adding to the visual splendor of the performance. Accompanied by traditional Gamelan music, the Legong Dance tells enchanting stories from Balinese mythology and folklore, depicting themes of love, loyalty, and the eternal struggle between good and evil. With its precise choreography, vibrant costumes, and evocative storytelling, the Legong Dance captivates audiences and offers a glimpse into the rich cultural heritage of Bali.", R.drawable.legong_dance));

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