package com.bean;

import java.util.Date;
import java.util.Objects;

public class Movie {
    private String name;
    private String actor;
    private  double time;
    private double price;
    private  int number;
    private Date startTime;

    public Movie() {
    }

    public Movie(String name, String actor, double price, double time, int number, Date startTime) {
        this.name = name;
        this.actor = actor;
        this.price = price;
        this.time = time;
        this.number = number;
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", actor='" + actor + '\'' +
                ", time=" + time +
                ", price=" + price +
                ", number=" + number +
                ", startTime=" + startTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(time, movie.time) == 0 && Double.compare(price, movie.price) == 0 && number == movie.number && Objects.equals(name, movie.name) && Objects.equals(actor, movie.actor) && Objects.equals(startTime, movie.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, actor, time, price, number, startTime);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
