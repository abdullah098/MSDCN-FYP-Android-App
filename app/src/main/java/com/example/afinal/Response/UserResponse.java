package com.example.afinal.Response;

public class UserResponse {

    int id;
    String name, email,api_token, CnicCardNumber, CnicFrontPic, CnicBackPic, AccountStatus, CreditCardId, UserType,created_at;

    public UserResponse(int id, String name, String email, String api_token, String cnicCardNumber, String cnicFrontPic, String cnicBackPic, String accountStatus, String creditCardId, String userType, String created_at) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.api_token = api_token;
        CnicCardNumber = cnicCardNumber;
        CnicFrontPic = cnicFrontPic;
        CnicBackPic = cnicBackPic;
        AccountStatus = accountStatus;
        CreditCardId = creditCardId;
        UserType = userType;
        this.created_at = created_at;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    public String getCnicCardNumber() {
        return CnicCardNumber;
    }

    public void setCnicCardNumber(String cnicCardNumber) {
        CnicCardNumber = cnicCardNumber;
    }

    public String getCnicFrontPic() {
        return CnicFrontPic;
    }

    public void setCnicFrontPic(String cnicFrontPic) {
        CnicFrontPic = cnicFrontPic;
    }

    public String getCnicBackPic() {
        return CnicBackPic;
    }

    public void setCnicBackPic(String cnicBackPic) {
        CnicBackPic = cnicBackPic;
    }

    public String getAccountStatus() {
        return AccountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        AccountStatus = accountStatus;
    }

    public String getCreditCardId() {
        return CreditCardId;
    }

    public void setCreditCardId(String creditCardId) {
        CreditCardId = creditCardId;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
