package com.example.afinal;

public class SharedPref {

    private String key;
    private static SharedPref pref = null;

    private SharedPref(){

    }

    public static SharedPref getInstance()
    {
        if(pref == null)
        {
            pref = new SharedPref();
        }
        return pref;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getKey()
    {
        return this.key;
    }

}
