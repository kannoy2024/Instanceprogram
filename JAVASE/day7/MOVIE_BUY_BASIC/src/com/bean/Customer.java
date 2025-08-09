package com.bean;

import java.util.HashMap;
import java.util.Map;

public class Customer extends User{
    private Map<String,Boolean> buyMovies = new HashMap<>();

    public Map<String,Boolean> getBuyMovies(){
        return buyMovies;
    }

    public void setBuyMovies(Map<String, Boolean> buyMovies) {
        this.buyMovies = buyMovies;
    }
}
