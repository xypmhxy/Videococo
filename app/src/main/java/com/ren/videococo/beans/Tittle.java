package com.ren.videococo.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ren on 2017/09/27 0027
 */

public class Tittle implements Parcelable {
    private String categoryId;
    private String name;
    private String color;

    protected Tittle(Parcel in) {
        categoryId = in.readString();
        name = in.readString();
        color = in.readString();
    }

    public Tittle() {
    }

    public static final Creator<Tittle> CREATOR = new Creator<Tittle>() {
        @Override
        public Tittle createFromParcel(Parcel in) {
            return new Tittle(in);
        }

        @Override
        public Tittle[] newArray(int size) {
            return new Tittle[size];
        }
    };

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(categoryId);
        dest.writeString(name);
        dest.writeString(color);
    }
}
