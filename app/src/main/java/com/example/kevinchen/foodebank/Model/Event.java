package com.example.kevinchen.foodebank.Model;

import java.util.HashMap;

public class Event {
    HashMap<String , Participant> mParticipants;
    String mDate;

    public Event(String date) {
        mParticipants = new HashMap<String, Participant>();
        mDate = date;
    }

    public HashMap<String, Participant> getParticipants() {
        return mParticipants;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public boolean addParticipant(String name, String ID, String Load) {
        if (!mParticipants.keySet().contains(ID)) {
            mParticipants.put(ID, new Participant(name, ID, Load));
            return true;
        } else {
            return false;
        }
    }

    public void removeParticipant(String ID) {
        if (mParticipants.get(ID)!=null) {
            mParticipants.remove(mParticipants.get(ID));
        }
    }
}
