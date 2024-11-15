package com.tecsup.loginapp.Models;

public class PizzaHelp {
    private String title;
    private String statusAndDate;

    public PizzaHelp(String title, String statusAndDate) {
        this.title = title;
        this.statusAndDate = statusAndDate;
    }

    public String getTitle() {
        return title;
    }

    public String getStatusAndDate() {
        return statusAndDate;
    }
}
