package com.example.kevinchen.foodebank.Model;

/**
 * Created by kevinchen on 7/9/16.
 */
public class Participant {
    public String getLoad() {
        return mLoad;
    }

    public void setLoad(String load) {
        mLoad = load;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getID() {
        return mID;
    }

    public void setID(String ID) {
        mID = ID;
    }

    private String mName;
    private String mID;
    private String mLoad;

    public Participant(String name, String ID, String Load) {
        mName = name;
        mID = ID;
        mLoad = Load;
    }
}
