package com.example.androidratethem;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Like {
    public String imageId;
    public String userId;

    public Like() {
    }

    public Like(String imageId, String userId) {
        this.imageId = imageId;
        this.userId = userId;
    }
}
