package com.example.ht_422;

import android.graphics.drawable.Drawable;
import android.widget.Button;

public class ItemData {
    private Drawable image;
    private String text;
    private String subText;
    private Button button;

    public ItemData(Drawable image, String text, String subText, Button button) {
        this.image = image;
        this.text = text;
        this.subText = subText;
        this.button = button;
    }

    public Drawable getImage() {
        return image;
    }

    public String getText() {
        return text;
    }

    public String getSubText() {
        return subText;
    }

}
