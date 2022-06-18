package com.example.a5l4.network;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoveModel  {
    @SerializedName("fname")
    public String firstName;
    @SerializedName("sname")
    public String secondName;
    public String percentage;
    public String result;
}
