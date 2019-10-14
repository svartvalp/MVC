package com.kasyan313.aaa;

public class Date
{
    public Date(String date, boolean value) {
        this.date = date;
        this.value = value;
    }

    public Date() {
    }

    private String date;
    private  boolean value;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
