package com.example.jalihara.ui.tickets;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jalihara.R;
import com.example.jalihara.ui.Performance;
import com.example.jalihara.ui.TicketFormActivity;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.ViewHolder> {
    ArrayList<Performance> tickets;
    Context context;

    public TicketAdapter(Context context, ArrayList<Performance> tickets) {
        this.context = context;
        this.tickets = tickets;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView textTitle;
        private TextView date;
        private TextView price;
        private Button buyButton;



        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            image = (ImageView) view.findViewById(R.id.ticket_image);
            textTitle = (TextView) view.findViewById(R.id.ticket_title);
            date = (TextView) view.findViewById(R.id.ticket_date);
            price = (TextView) view.findViewById(R.id.ticket_price);
            buyButton = (Button) view.findViewById(R.id.buyBtn);
        }

    }


    @NonNull
    @Override
    public TicketAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_tickets, parent, false);
        return new TicketAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        Performance ticket = (Performance) tickets.get(position);

        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        String formattedNumber = numberFormat.format(ticket.getPrice());

        holder.textTitle.setText(ticket.getTitle());
        holder.date.setText(ticket.getDate());
        holder.image.setImageResource(ticket.getImage());
        holder.price.setText("Rp " + formattedNumber);


        holder.buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to launch the ticket form page
                Intent intent = new Intent(v.getContext(), TicketFormActivity.class);

                // Pass the ticket data as extras in the Intent
                intent.putExtra("ticketTitle", ticket.getTitle());
                intent.putExtra("ticketImage", ticket.getImage());
                intent.putExtra("ticketPrice", formattedNumber);
                intent.putExtra("ticketDate", ticket.getDate());
                intent.putExtra("ticketDesc", ticket.getDescription());
                // Add other ticket properties as extras as needed

                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return tickets.size();
    }

}


