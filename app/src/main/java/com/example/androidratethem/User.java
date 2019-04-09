package com.example.androidratethem;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    public String uid;
    public String displayName;
    public String token;

    public User() {
    }

    public User(String uid, String displayName, String token) {
        this.uid = uid;
        this.displayName = displayName;
        this.token = token;
    }
}