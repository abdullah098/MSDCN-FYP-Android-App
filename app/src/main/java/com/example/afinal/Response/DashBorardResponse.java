package com.example.afinal.Response;

import java.util.List;

public class DashBorardResponse {

    String message;
    float TotalRevenue;
    int TotalSales;
    int TodaySales;
    float TodayRevenue;
    List LowInvetory;


    public DashBorardResponse(String message, float totalRevenue, int totalSales, int todaySales, float todayRevenue, List lowInvetory) {
        this.message = message;
        TotalRevenue = totalRevenue;
        TotalSales = totalSales;
        TodaySales = todaySales;
        TodayRevenue = todayRevenue;
        LowInvetory = lowInvetory;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public float getTotalRevenue() {
        return TotalRevenue;
    }

    public void setTotalRevenue(float totalRevenue) {
        TotalRevenue = totalRevenue;
    }

    public int getTotalSales() {
        return TotalSales;
    }

    public void setTotalSales(int totalSales) {
        TotalSales = totalSales;
    }

    public int getTodaySales() {
        return TodaySales;
    }

    public void setTodaySales(int todaySales) {
        TodaySales = todaySales;
    }

    public float getTodayRevenue() {
        return TodayRevenue;
    }

    public void setTodayRevenue(float todayRevenue) {
        TodayRevenue = todayRevenue;
    }

    public List getLowInvetory() {
        return LowInvetory;
    }

    public void setLowInvetory(List lowInvetory) {
        LowInvetory = lowInvetory;
    }
}