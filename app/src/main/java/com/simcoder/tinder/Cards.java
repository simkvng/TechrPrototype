package com.simcoder.tinder;

/**
 * Created by natha on 3/30/2018.
 */

public class Cards {

    private String userID;
    private String name;

    public Cards(String userID, String name)
    {
        this.userID = userID;
        this.name = name;
    }

    public String getUserID()
    {
        return userID;
    }
    public void setUserID(String userID)
    {
        this.userID = userID;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

}
