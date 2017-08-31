package com.example.otto.presidentlist;

/**
 * Created by Otto on 25.8.2017.
 */

public class President {

    String name;
    String years;
    String description;

    public President(String name, String years, String description){
        this.name = name;
        this.years = years;
        this.description = description;
    }

    public String toString (){
        return name + " " + years;
    }

    public String getDescription () {
        return description;
    }
}
