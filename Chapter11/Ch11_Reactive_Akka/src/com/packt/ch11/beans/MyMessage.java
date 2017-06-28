package com.packt.ch11.beans;

import java.io.Serializable;

public class MyMessage implements Serializable
{
    private String message;

    public MyMessage(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}