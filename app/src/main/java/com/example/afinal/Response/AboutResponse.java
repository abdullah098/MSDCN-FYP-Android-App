package com.example.afinal.Response;

public class AboutResponse {

    String message;
    UserResponse User;
    ShopResponse Shop;

    public AboutResponse(String message, UserResponse user, ShopResponse shop) {
        this.message = message;
        User = user;
        Shop = shop;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserResponse getUser() {
        return User;
    }

    public void setUser(UserResponse user) {
        User = user;
    }

    public ShopResponse getShop() {
        return Shop;
    }

    public void setShop(ShopResponse shop) {
        Shop = shop;
    }
}
