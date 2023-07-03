package com.example.jalihara.ui;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.time.LocalTime;
import java.util.Date;

public class Performance implements Parcelable {
    public Performance(String title, String date, int price, String desc, int image) {
        this.title = title;
        this.date = date;
        this.price = price;
        this.description = desc;
        this.image = image;
    }
    private String title;
    private int image;
    private String date;
    private int price;

    private String description;

    public String getTitle() {
        return title;
    }
    public int getImage() {
        return image;
    }
    public String getDate() {
        return date.toString();
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(date);
        dest.writeInt(image);
        dest.writeInt(price);
    }

}
