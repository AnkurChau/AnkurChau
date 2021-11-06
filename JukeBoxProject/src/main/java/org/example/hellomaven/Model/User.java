package org.example.hellomaven.Model;

public class User {

    private String userID;
    public User(String userID)
    {
        this.userID=userID;
    }
    public void setUsername(String userID)
    {
        this.userID=userID;
    }
    public String getUsername()
    {
        return userID;
    }
    public String toString()
    {
        return userID;
    }
}
