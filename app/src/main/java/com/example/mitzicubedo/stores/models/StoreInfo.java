package com.example.mitzicubedo.stores.models;

/**
 * Created by MitziCubedo on 29/06/16.
 */
public class StoreInfo {
    protected String message;
    protected String date;

    public StoreInfo() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = "Message: " + message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = "Date: " + date.substring(0,10) + " Time: "+ date.substring(11, 16);
    }
}
